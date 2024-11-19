/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.resources.wallets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.pti.sdk.core.ClientOptions;
import com.pti.sdk.core.MediaTypes;
import com.pti.sdk.core.ObjectMappers;
import com.pti.sdk.core.PTIClientApiException;
import com.pti.sdk.core.PTIClientException;
import com.pti.sdk.core.RequestOptions;
import com.pti.sdk.errors.BadRequestError;
import com.pti.sdk.errors.ForbiddenError;
import com.pti.sdk.errors.NotFoundError;
import com.pti.sdk.errors.TooManyRequestsError;
import com.pti.sdk.errors.UnauthorizedError;
import com.pti.sdk.resources.wallets.requests.SimulatePaymentRequest;
import com.pti.sdk.resources.wallets.requests.WalletCreation;
import com.pti.sdk.types.CurrencyAsset;
import com.pti.sdk.types.InvalidRequestError;
import com.pti.sdk.types.UnmanagedError;
import com.pti.sdk.types.Wallet;
import java.io.IOException;
import java.lang.Object;
import java.lang.String;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class WalletsClient {
  protected final ClientOptions clientOptions;

  public WalletsClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  public List<CurrencyAsset> getListOfAssets() {
    return getListOfAssets(null);
  }

  public List<CurrencyAsset> getListOfAssets(RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("assets")
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("GET", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), new TypeReference<List<CurrencyAsset>>() {});
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 429:throw new TooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        }
      }
      catch (JsonProcessingException ignored) {
        // unable to map error response, throwing generic error
      }
      throw new PTIClientApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new PTIClientException("Network error executing HTTP request", e);
    }
  }

  public List<Wallet> getWallets(String userId) {
    return getWallets(userId,null);
  }

  public List<Wallet> getWallets(String userId, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users")
      .addPathSegment(userId)
      .addPathSegments("wallets")
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("GET", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), new TypeReference<List<Wallet>>() {});
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 404:throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 429:throw new TooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        }
      }
      catch (JsonProcessingException ignored) {
        // unable to map error response, throwing generic error
      }
      throw new PTIClientApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new PTIClientException("Network error executing HTTP request", e);
    }
  }

  public Wallet createWallet(String userId, WalletCreation request) {
    return createWallet(userId,request,null);
  }

  public Wallet createWallet(String userId, WalletCreation request, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users")
      .addPathSegment(userId)
      .addPathSegments("wallets")
      .build();
    RequestBody body;
    try {
      body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
    }
    catch(JsonProcessingException e) {
      throw new PTIClientException("Failed to serialize request", e);
    }
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("POST", body)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Wallet.class);
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 400:throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, InvalidRequestError.class));
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 404:throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 429:throw new TooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        }
      }
      catch (JsonProcessingException ignored) {
        // unable to map error response, throwing generic error
      }
      throw new PTIClientApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new PTIClientException("Network error executing HTTP request", e);
    }
  }

  public Wallet getWallet(String userId, String walletId) {
    return getWallet(userId,walletId,null);
  }

  public Wallet getWallet(String userId, String walletId, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users")
      .addPathSegment(userId)
      .addPathSegments("wallets")
      .addPathSegment(walletId)
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("GET", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Wallet.class);
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 429:throw new TooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        }
      }
      catch (JsonProcessingException ignored) {
        // unable to map error response, throwing generic error
      }
      throw new PTIClientApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new PTIClientException("Network error executing HTTP request", e);
    }
  }

  public void deleteWallet(String userId, String walletId) {
    deleteWallet(userId,walletId,null);
  }

  public void deleteWallet(String userId, String walletId, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users")
      .addPathSegment(userId)
      .addPathSegments("wallets")
      .addPathSegment(walletId)
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("DELETE", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return;
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 404:throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 429:throw new TooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        }
      }
      catch (JsonProcessingException ignored) {
        // unable to map error response, throwing generic error
      }
      throw new PTIClientApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new PTIClientException("Network error executing HTTP request", e);
    }
  }

  public void simulateWalletPayment(String userId, String walletId) {
    simulateWalletPayment(userId,walletId,SimulatePaymentRequest.builder().build());
  }

  public void simulateWalletPayment(String userId, String walletId,
      SimulatePaymentRequest request) {
    simulateWalletPayment(userId,walletId,request,null);
  }

  public void simulateWalletPayment(String userId, String walletId, SimulatePaymentRequest request,
      RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users")
      .addPathSegment(userId)
      .addPathSegments("wallets")
      .addPathSegment(walletId)
      .addPathSegments("simulate-payment")
      .build();
    RequestBody body;
    try {
      body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
    }
    catch(JsonProcessingException e) {
      throw new PTIClientException("Failed to serialize request", e);
    }
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("POST", body)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return;
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 403:throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 404:throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 429:throw new TooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        }
      }
      catch (JsonProcessingException ignored) {
        // unable to map error response, throwing generic error
      }
      throw new PTIClientApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new PTIClientException("Network error executing HTTP request", e);
    }
  }

  public Wallet createWalletDepositAddress(String userId, String walletId,
      Map<String, Object> request) {
    return createWalletDepositAddress(userId,walletId,request,null);
  }

  public Wallet createWalletDepositAddress(String userId, String walletId,
      Map<String, Object> request, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users")
      .addPathSegment(userId)
      .addPathSegments("wallets")
      .addPathSegment(walletId)
      .addPathSegments("deposit-address")
      .build();
    RequestBody body;
    try {
      body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
    }
    catch(JsonProcessingException e) {
      throw new PTIClientException("Failed to serialize request", e);
    }
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("POST", body)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Wallet.class);
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 403:throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 404:throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 429:throw new TooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        }
      }
      catch (JsonProcessingException ignored) {
        // unable to map error response, throwing generic error
      }
      throw new PTIClientApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new PTIClientException("Network error executing HTTP request", e);
    }
  }

  public Wallet createWalletVirtualBankAccount(String userId, String walletId,
      Map<String, Object> request) {
    return createWalletVirtualBankAccount(userId,walletId,request,null);
  }

  public Wallet createWalletVirtualBankAccount(String userId, String walletId,
      Map<String, Object> request, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users")
      .addPathSegment(userId)
      .addPathSegments("wallets")
      .addPathSegment(walletId)
      .addPathSegments("virtual-bank-account")
      .build();
    RequestBody body;
    try {
      body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
    }
    catch(JsonProcessingException e) {
      throw new PTIClientException("Failed to serialize request", e);
    }
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("POST", body)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), Wallet.class);
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 403:throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 404:throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 429:throw new TooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        }
      }
      catch (JsonProcessingException ignored) {
        // unable to map error response, throwing generic error
      }
      throw new PTIClientApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new PTIClientException("Network error executing HTTP request", e);
    }
  }
}
