/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.util.Base64URL;
import com.pti.sdk.core.ClientOptions;
import com.pti.sdk.core.Suppliers;
import com.pti.sdk.resources.authentication.AuthenticationClient;
import com.pti.sdk.resources.marketplace.MarketplaceClient;
import com.pti.sdk.resources.paymentinformation.PaymentInformationClient;
import com.pti.sdk.resources.transactionassessment.TransactionAssessmentClient;
import com.pti.sdk.resources.transactions.TransactionsClient;
import com.pti.sdk.resources.users.UsersClient;
import com.pti.sdk.resources.wallets.WalletsClient;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Map;
import java.util.function.Supplier;

public class PTIClient {
  protected final ClientOptions clientOptions;

  protected final Supplier<AuthenticationClient> authenticationClient;

  protected final Supplier<WalletsClient> walletsClient;

  protected final Supplier<UsersClient> usersClient;

  protected final Supplier<PaymentInformationClient> paymentInformationClient;

  protected final Supplier<TransactionAssessmentClient> transactionAssessmentClient;

  protected final Supplier<TransactionsClient> transactionsClient;

  protected final Supplier<MarketplaceClient> marketplaceClient;

  public PTIClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    this.authenticationClient = Suppliers.memoize(() -> new AuthenticationClient(clientOptions));
    this.walletsClient = Suppliers.memoize(() -> new WalletsClient(clientOptions));
    this.usersClient = Suppliers.memoize(() -> new UsersClient(clientOptions));
    this.paymentInformationClient = Suppliers.memoize(() -> new PaymentInformationClient(clientOptions));
    this.transactionAssessmentClient = Suppliers.memoize(() -> new TransactionAssessmentClient(clientOptions));
    this.transactionsClient = Suppliers.memoize(() -> new TransactionsClient(clientOptions));
    this.marketplaceClient = Suppliers.memoize(() -> new MarketplaceClient(clientOptions));
  }

  public AuthenticationClient authentication() {
    return this.authenticationClient.get();
  }

  public WalletsClient wallets() {
    return this.walletsClient.get();
  }

  public UsersClient users() {
    return this.usersClient.get();
  }

  public PaymentInformationClient paymentInformation() {
    return this.paymentInformationClient.get();
  }

  public TransactionAssessmentClient transactionAssessment() {
    return this.transactionAssessmentClient.get();
  }

  public TransactionsClient transactions() {
    return this.transactionsClient.get();
  }

  public MarketplaceClient marketplace() {
    return this.marketplaceClient.get();
  }

  public static PTIClientBuilder builder() {
    return new PTIClientBuilder();
  }
  
  public String decodeWebhookPayload(String payload) throws ParseException, JOSEException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, String> payloadMap = mapper.readValue(payload, new TypeReference<>() {});
    RSAKey privateKey = RSAKey.parse(clientOptions.privateKey());
    JWEObject jweObject = new JWEObject(
            Base64URL.from(payloadMap.get("protected")),
            Base64URL.from(payloadMap.get("encrypted_key")),
            Base64URL.from(payloadMap.get("iv")),
            Base64URL.from(payloadMap.get("ciphertext")),
            Base64URL.from(payloadMap.get("tag"))
    );  
    jweObject.decrypt(new RSADecrypter(privateKey));
    Map<String, Object> jwsParts = jweObject.getPayload().toJSONObject(); 
    JWSObject jwsObject = new JWSObject(
            Base64URL.from((String) jwsParts.get("protected")),
            Base64URL.from((String) jwsParts.get("payload")),
            Base64URL.from((String) jwsParts.get("signature"))
    );
    String ptiPublicKey = IOUtils.resourceToString("/" + clientOptions.environment().getKeyName(), StandardCharsets.UTF_8);
    RSAKey publicKey = RSAKey.parse(ptiPublicKey);
    if (!jwsObject.verify(new RSASSAVerifier(publicKey))) {
      throw new IllegalStateException("JWE verification failed");
    }
    return jwsObject.getPayload().toString();
  }
}
