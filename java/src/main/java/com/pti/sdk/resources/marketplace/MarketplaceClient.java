/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.resources.marketplace;

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
import com.pti.sdk.errors.UnprocessableEntityError;
import com.pti.sdk.resources.marketplace.requests.ExecuteBuyTransaction;
import com.pti.sdk.resources.marketplace.requests.ExecuteSellTransaction;
import com.pti.sdk.resources.marketplace.requests.GetDigitalItemsRequest;
import com.pti.sdk.types.DigitalItem;
import com.pti.sdk.types.InvalidRequestError;
import com.pti.sdk.types.ObjectReference;
import com.pti.sdk.types.ObjectReferencePage;
import com.pti.sdk.types.OneOfAssessmentValidationError;
import com.pti.sdk.types.UnmanagedError;
import java.io.IOException;
import java.lang.Exception;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MarketplaceClient {
  protected final ClientOptions clientOptions;

  public MarketplaceClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  /**
   * This endpoint is used to execute a Digital Item buy (token, nft, other) transaction for a User. The Transaction Assessment and User information requirement are evaluated before the Transaction is executed.
   */
  public ObjectReference digitalItemBuy(ExecuteBuyTransaction request) {
    return digitalItemBuy(request,null);
  }

  /**
   * This endpoint is used to execute a Digital Item buy (token, nft, other) transaction for a User. The Transaction Assessment and User information requirement are evaluated before the Transaction is executed.
   */
  public ObjectReference digitalItemBuy(ExecuteBuyTransaction request,
      RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("transactions/purchases")
      .build();
    Map<String, Object> properties = new HashMap<>();
    if (request.getDigitalItem().isPresent()) {
      properties.put("digitalItem", request.getDigitalItem());
    }
    if (request.getDigitalItems().isPresent()) {
      properties.put("digitalItems", request.getDigitalItems());
    }
    properties.put("sourceMethod", request.getSourceMethod());
    if (request.getSeller().isPresent()) {
      properties.put("seller", request.getSeller());
    }
    if (request.getFeeRecipients().isPresent()) {
      properties.put("feeRecipients", request.getFeeRecipients());
    }
    properties.put("type", request.getType());
    if (request.getTransactionGroupId().isPresent()) {
      properties.put("transactionGroupId", request.getTransactionGroupId());
    }
    if (request.getSubClientId().isPresent()) {
      properties.put("subClientId", request.getSubClientId());
    }
    if (request.getTransactionTotal().isPresent()) {
      properties.put("transactionTotal", request.getTransactionTotal());
    }
    if (request.getUsdValue().isPresent()) {
      properties.put("usdValue", request.getUsdValue());
    }
    properties.put("amount", request.getAmount());
    properties.put("date", request.getDate());
    properties.put("initiator", request.getInitiator());
    if (request.getPtiMeta().isPresent()) {
      properties.put("ptiMeta", request.getPtiMeta());
    }
    if (request.getClientMeta().isPresent()) {
      properties.put("clientMeta", request.getClientMeta());
    }
    RequestBody body;
    try {
      body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(properties), MediaTypes.APPLICATION_JSON);
    }
    catch(Exception e) {
      throw new RuntimeException(e);
    }
    Request.Builder _requestBuilder = new Request.Builder()
      .url(httpUrl)
      .method("POST", body)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json").addHeader("Accept", "application/json");
    _requestBuilder.addHeader("x-pti-request-id", request.getPtiRequestId());
    _requestBuilder.addHeader("x-pti-scenario-id", request.getPtiScenarioId());
    if (request.getPtiSessionId().isPresent()) {
      _requestBuilder.addHeader("x-pti-session-id", request.getPtiSessionId().get());
    }
    if (request.getPtiDisableWebhook().isPresent()) {
      _requestBuilder.addHeader("x-pti-disable-webhook", request.getPtiDisableWebhook().get().toString());
    }
    if (request.getPtiProviderName().isPresent()) {
      _requestBuilder.addHeader("x-pti-provider-name", request.getPtiProviderName().get());
    }
    Request okhttpRequest = _requestBuilder.build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ObjectReference.class);
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 400:throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, InvalidRequestError.class));
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 403:throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 404:throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 422:throw new UnprocessableEntityError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, OneOfAssessmentValidationError.class));
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

  /**
   * This endpoint is used to execute a Digital Item sell (token, nft, other) transaction for a User. The Transaction Assessment and User information requirement are evaluated before the transaction is executed.
   */
  public ObjectReference digitalItemSell(ExecuteSellTransaction request) {
    return digitalItemSell(request,null);
  }

  /**
   * This endpoint is used to execute a Digital Item sell (token, nft, other) transaction for a User. The Transaction Assessment and User information requirement are evaluated before the transaction is executed.
   */
  public ObjectReference digitalItemSell(ExecuteSellTransaction request,
      RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("transactions/sales")
      .build();
    Map<String, Object> properties = new HashMap<>();
    if (request.getDigitalItem().isPresent()) {
      properties.put("digitalItem", request.getDigitalItem());
    }
    if (request.getDigitalItems().isPresent()) {
      properties.put("digitalItems", request.getDigitalItems());
    }
    properties.put("destinationMethod", request.getDestinationMethod());
    if (request.getBuyer().isPresent()) {
      properties.put("buyer", request.getBuyer());
    }
    if (request.getFeeRecipients().isPresent()) {
      properties.put("feeRecipients", request.getFeeRecipients());
    }
    properties.put("type", request.getType());
    if (request.getTransactionGroupId().isPresent()) {
      properties.put("transactionGroupId", request.getTransactionGroupId());
    }
    if (request.getSubClientId().isPresent()) {
      properties.put("subClientId", request.getSubClientId());
    }
    if (request.getTransactionTotal().isPresent()) {
      properties.put("transactionTotal", request.getTransactionTotal());
    }
    if (request.getUsdValue().isPresent()) {
      properties.put("usdValue", request.getUsdValue());
    }
    properties.put("amount", request.getAmount());
    properties.put("date", request.getDate());
    properties.put("initiator", request.getInitiator());
    if (request.getPtiMeta().isPresent()) {
      properties.put("ptiMeta", request.getPtiMeta());
    }
    if (request.getClientMeta().isPresent()) {
      properties.put("clientMeta", request.getClientMeta());
    }
    RequestBody body;
    try {
      body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(properties), MediaTypes.APPLICATION_JSON);
    }
    catch(Exception e) {
      throw new RuntimeException(e);
    }
    Request.Builder _requestBuilder = new Request.Builder()
      .url(httpUrl)
      .method("POST", body)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json").addHeader("Accept", "application/json");
    _requestBuilder.addHeader("x-pti-request-id", request.getPtiRequestId());
    _requestBuilder.addHeader("x-pti-scenario-id", request.getPtiScenarioId());
    if (request.getPtiSessionId().isPresent()) {
      _requestBuilder.addHeader("x-pti-session-id", request.getPtiSessionId().get());
    }
    if (request.getPtiDisableWebhook().isPresent()) {
      _requestBuilder.addHeader("x-pti-disable-webhook", request.getPtiDisableWebhook().get().toString());
    }
    if (request.getPtiProviderName().isPresent()) {
      _requestBuilder.addHeader("x-pti-provider-name", request.getPtiProviderName().get());
    }
    Request okhttpRequest = _requestBuilder.build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ObjectReference.class);
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 400:throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, InvalidRequestError.class));
          case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
          case 403:throw new ForbiddenError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 404:throw new NotFoundError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          case 422:throw new UnprocessableEntityError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, OneOfAssessmentValidationError.class));
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

  public DigitalItem getDigitalItem(String digitalItemId) {
    return getDigitalItem(digitalItemId,null);
  }

  public DigitalItem getDigitalItem(String digitalItemId, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("digital-items")
      .addPathSegment(digitalItemId)
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("GET", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .addHeader("Accept", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), DigitalItem.class);
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

  public void deleteDigitalItem(String digitalItemId) {
    deleteDigitalItem(digitalItemId,null);
  }

  public void deleteDigitalItem(String digitalItemId, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("digital-items")
      .addPathSegment(digitalItemId)
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("DELETE", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Accept", "application/json")
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

  public ObjectReferencePage getDigitalItems(String userId) {
    return getDigitalItems(userId,GetDigitalItemsRequest.builder().build());
  }

  public ObjectReferencePage getDigitalItems(String userId, GetDigitalItemsRequest request) {
    return getDigitalItems(userId,request,null);
  }

  public ObjectReferencePage getDigitalItems(String userId, GetDigitalItemsRequest request,
      RequestOptions requestOptions) {
    HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users")
      .addPathSegment(userId)
      .addPathSegments("digital-items");if (request.getPage().isPresent()) {
        httpUrl.addQueryParameter("page", request.getPage().get().toString());
      }
      if (request.getSize().isPresent()) {
        httpUrl.addQueryParameter("size", request.getSize().get().toString());
      }
      if (request.getSortBy().isPresent()) {
        httpUrl.addQueryParameter("sortBy", request.getSortBy().get());
      }
      Request.Builder _requestBuilder = new Request.Builder()
        .url(httpUrl.build())
        .method("GET", null)
        .headers(Headers.of(clientOptions.headers(requestOptions)))
        .addHeader("Content-Type", "application/json").addHeader("Accept", "application/json");
      Request okhttpRequest = _requestBuilder.build();
      OkHttpClient client = clientOptions.httpClient();
      if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
        client = clientOptions.httpClientWithTimeout(requestOptions);
      }
      try (Response response = client.newCall(okhttpRequest).execute()) {
        ResponseBody responseBody = response.body();
        if (response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ObjectReferencePage.class);
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

    public List<ObjectReference> createDigitalItems(String userId, List<DigitalItem> request) {
      return createDigitalItems(userId,request,null);
    }

    public List<ObjectReference> createDigitalItems(String userId, List<DigitalItem> request,
        RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
        .addPathSegment(userId)
        .addPathSegments("digital-items")
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
        .addHeader("Accept", "application/json")
        .build();
      OkHttpClient client = clientOptions.httpClient();
      if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
        client = clientOptions.httpClientWithTimeout(requestOptions);
      }
      try (Response response = client.newCall(okhttpRequest).execute()) {
        ResponseBody responseBody = response.body();
        if (response.isSuccessful()) {
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), new TypeReference<List<ObjectReference>>() {});
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
  }
