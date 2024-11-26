package com.pti.sdk.core;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.lang.JoseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AuthInterceptor implements Interceptor {
    private final String privateKey;
    
    public AuthInterceptor(String privateKey) {
        this.privateKey = privateKey;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        var date = getDate();
        var clientId = request.header("x-pti-client-id");
        
        var body = "";
        var contentType = "";
        if (request.body() != null) {
            var buffer = new Buffer();
            request.body().writeTo(buffer);
            body = buffer.readUtf8();
            contentType = request.body().contentType().toString();
            // Special case for file uploads, where we only need to grab the part named 'metaInformation' 
            if (request.body() instanceof MultipartBody multipartBody) {
                Optional<MultipartBody.Part> partOptional = multipartBody.parts().stream().filter(p -> p.headers().toString().contains("\"metaInformation\"")).findAny();
                if (partOptional.isPresent()) {
                    buffer = new Buffer();
                    partOptional.get().body().writeTo(buffer);
                    body = buffer.readUtf8();
                }
            }
        }

        var payload = buildPayload(request.method(), body, date, request.url().toString(), clientId, contentType);
        String signature;
        try {
            signature = signPayload(clientId, privateKey, payload);
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        request = request.newBuilder()
                .addHeader("Date", date)
                .addHeader("x-pti-signature", signature)
                .build();

        return chain.proceed(request);
    }

    public static String getDate() {
        final SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM, yyyy hh:mm:ss z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(new Date());
    }

    public String buildPayload(String method, String payload, String date, String urlOrPath, String clientId, String contentType) throws MalformedURLException {

        var path = urlOrPath;
        if(urlOrPath.startsWith("http")) {
            path = new URL(urlOrPath).getPath();
        }

        if (Set.of("POST", "PUT", "PATCH").contains(method)) {
            return method + "\n" +
                    Objects.requireNonNull(getContentSha256(payload)).toUpperCase() + "\n" +
                    "content-type:" + contentType + "\n" +
                    "date:" + date + "\n" +
                    "x-pti-client-id:" + clientId + "\n" +
                    path;
        }

        return method + "\n\n\n" +
                "date:" + date + "\n" +
                "x-pti-client-id:" + clientId + "\n" +
                path;
    }

    private String getContentSha256(String originalContent) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return bytesToHex(digest.digest(originalContent.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e){
            return null;
        }
    }

    public String signPayload(String clientId, String clientPrivateKey, String payload) throws NoSuchAlgorithmException, ParseException, JOSEException, JoseException {
        RSAKey rsaKey = RSAKey.parse(clientPrivateKey);

        String filteredPrivateKey = String.format("{\"e\":\"%s\",\"kty\":\"%s\",\"n\":\"%s\"}", rsaKey.getPublicExponent(), rsaKey.getKeyType(), rsaKey.getModulus());

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(filteredPrivateKey.getBytes(StandardCharsets.UTF_8));
        byte[] encode = Base64.getUrlEncoder().withoutPadding().encode(digest.digest());

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(payload);
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA512);

        jws.setKey(rsaKey.toPrivateKey());
        jws.setHeader("alg", "RS512");
        jws.setHeader("cid", clientId);
        jws.setHeader("kid", new String(encode));

        return jws.getCompactSerialization();
    }

    static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
