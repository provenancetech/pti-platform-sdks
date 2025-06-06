/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.core;

import java.io.File;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import com.nimbusds.jose.util.IOUtils;
import okhttp3.OkHttpClient;

public final class ClientOptions {
    private final Environment environment;

    private final Map<String, String> headers;

    private final Map<String, Supplier<String>> headerSuppliers;

    private final OkHttpClient httpClient;
    
    private final String privateKey;
    
    private ClientOptions(Environment environment, String privateKey, Map<String, String> headers,
                          Map<String, Supplier<String>> headerSuppliers, OkHttpClient httpClient) {
        this.environment = environment;
        this.headers = new HashMap<>();
        this.headers.putAll(headers);
        this.headerSuppliers = headerSuppliers;
        this.httpClient = httpClient;
        this.privateKey = privateKey;
    }

    public Environment environment() {
        return this.environment;
    }

    public Map<String, String> headers(RequestOptions requestOptions) {
        Map<String, String> values = new HashMap<>(this.headers);
        headerSuppliers.forEach((key, supplier) -> {
            values.put(key, supplier.get());
        });
        if (requestOptions != null) {
            values.putAll(requestOptions.getHeaders());
        }
        return values;
    }

    public OkHttpClient httpClient() {
        return this.httpClient;
    }

    public OkHttpClient httpClientWithTimeout(RequestOptions requestOptions) {
        if (requestOptions == null) {
            return this.httpClient;
        }
        return this.httpClient.newBuilder().callTimeout(requestOptions.getTimeout().get(), requestOptions.getTimeoutTimeUnit()).connectTimeout(0, TimeUnit.SECONDS).writeTimeout(0, TimeUnit.SECONDS).readTimeout(0, TimeUnit.SECONDS).build();
    }

    public String privateKey() {
        return this.privateKey;
    }
    
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Environment environment;

        private final Map<String, String> headers = new HashMap<>();

        private final Map<String, Supplier<String>> headerSuppliers = new HashMap<>();

        private String privateKeyPath = null;

        public Builder privateKeyPath(String privateKeyPath) {
            this.privateKeyPath = privateKeyPath;
            return this;
        }

        public Builder environment(Environment environment) {
            this.environment = environment;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder addHeader(String key, Supplier<String> value) {
            this.headerSuppliers.put(key, value);
            return this;
        }

        private String getPrivateKeyFileContent() {
            if (privateKeyPath == null) {
                throw new IllegalArgumentException("privateKeyPath cannot be null");
            }
            File file = new File(privateKeyPath);
            if (!file.exists() || !file.isFile()) {
                throw new IllegalArgumentException("privateKeyPath points to an invalid file: " + privateKeyPath);
            }
            try {
                return IOUtils.readFileToString(file);
            } catch (Exception x) {
                throw new IllegalArgumentException("Unable to read file: " + privateKeyPath);
            }
        }
        
        public ClientOptions build() {
            String privateKey = getPrivateKeyFileContent();
            OkHttpClient okhttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new AuthInterceptor(privateKey))
                    .addInterceptor(new RetryInterceptor(3))
                    .build();
            return new ClientOptions(environment, privateKey, headers, headerSuppliers, okhttpClient);
        }
    }
}
