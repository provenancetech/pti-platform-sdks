/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.resources.paymentinformation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.pti.sdk.core.ClientOptions;
import com.pti.sdk.core.MediaTypes;
import com.pti.sdk.core.ObjectMappers;
import com.pti.sdk.core.PTIClientApiException;
import com.pti.sdk.core.PTIClientException;
import com.pti.sdk.core.RequestOptions;
import com.pti.sdk.errors.BadRequestError;
import com.pti.sdk.errors.NotFoundError;
import com.pti.sdk.errors.TooManyRequestsError;
import com.pti.sdk.errors.UnauthorizedError;
import com.pti.sdk.resources.paymentinformation.requests.GetUserPaymentInformationsRequest;
import com.pti.sdk.types.InvalidRequestError;
import com.pti.sdk.types.OneOfExternalPaymentInformation;
import com.pti.sdk.types.UnmanagedError;
import java.io.IOException;
import java.lang.Object;
import java.lang.String;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class PaymentInformationClient {
  protected final ClientOptions clientOptions;

  public PaymentInformationClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  /**
   * This endpoint is used to get the Payment Information for a specific User. The information returned is the information that was collected for the User. You can filter by Payment Information type
   */
  public List<OneOfExternalPaymentInformation> getUserPaymentInformations(String userId) {
    return getUserPaymentInformations(userId,GetUserPaymentInformationsRequest.builder().build());
  }

  /**
   * This endpoint is used to get the Payment Information for a specific User. The information returned is the information that was collected for the User. You can filter by Payment Information type
   */
  public List<OneOfExternalPaymentInformation> getUserPaymentInformations(String userId,
      GetUserPaymentInformationsRequest request) {
    return getUserPaymentInformations(userId,request,null);
  }

  /**
   * This endpoint is used to get the Payment Information for a specific User. The information returned is the information that was collected for the User. You can filter by Payment Information type
   */
  public List<OneOfExternalPaymentInformation> getUserPaymentInformations(String userId,
      GetUserPaymentInformationsRequest request, RequestOptions requestOptions) {
    HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users")
      .addPathSegment(userId)
      .addPathSegments("payment-information");if (request.getType().isPresent()) {
        httpUrl.addQueryParameter("type", request.getType().get().toString());
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), new TypeReference<List<OneOfExternalPaymentInformation>>() {});
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

    /**
     * This endpoint is used to add a Payment Information for a specific User.
     */
    public OneOfExternalPaymentInformation addUserPaymentInformation(String userId,
        OneOfExternalPaymentInformation request) {
      return addUserPaymentInformation(userId,request,null);
    }

    /**
     * This endpoint is used to add a Payment Information for a specific User.
     */
    public OneOfExternalPaymentInformation addUserPaymentInformation(String userId,
        OneOfExternalPaymentInformation request, RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
        .addPathSegment(userId)
        .addPathSegments("payment-information")
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), OneOfExternalPaymentInformation.class);
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

    /**
     * This endpoint is used to get a Payment Information for a specific User.
     */
    public OneOfExternalPaymentInformation getUserPaymentInformation(String userId,
        String paymentInformationId) {
      return getUserPaymentInformation(userId,paymentInformationId,null);
    }

    /**
     * This endpoint is used to get a Payment Information for a specific User.
     */
    public OneOfExternalPaymentInformation getUserPaymentInformation(String userId,
        String paymentInformationId, RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
        .addPathSegment(userId)
        .addPathSegments("payment-information")
        .addPathSegment(paymentInformationId)
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), OneOfExternalPaymentInformation.class);
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

    /**
     * This endpoint is used to delete a Payment Information for a specific User.
     */
    public void deleteUserPaymentInformations(String userId, String paymentInformationId) {
      deleteUserPaymentInformations(userId,paymentInformationId,null);
    }

    /**
     * This endpoint is used to delete a Payment Information for a specific User.
     */
    public void deleteUserPaymentInformations(String userId, String paymentInformationId,
        RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
        .addPathSegment(userId)
        .addPathSegments("payment-information")
        .addPathSegment(paymentInformationId)
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

    /**
     * This endpoint is used to update a Payment Information for a specific User. Note: This endpoint does not support updating Credit Cards.
     */
    public OneOfExternalPaymentInformation updatePaymentInformation(String userId,
        String paymentInformationId, OneOfExternalPaymentInformation request) {
      return updatePaymentInformation(userId,paymentInformationId,request,null);
    }

    /**
     * This endpoint is used to update a Payment Information for a specific User. Note: This endpoint does not support updating Credit Cards.
     */
    public OneOfExternalPaymentInformation updatePaymentInformation(String userId,
        String paymentInformationId, OneOfExternalPaymentInformation request,
        RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
        .addPathSegment(userId)
        .addPathSegments("payment-information")
        .addPathSegment(paymentInformationId)
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
        .method("PATCH", body)
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), OneOfExternalPaymentInformation.class);
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
