/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.resources.estimatetransactioncost;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import com.pti.sdk.types.InvalidRequestError;
import com.pti.sdk.types.ObjectReference;
import com.pti.sdk.types.TradeTransaction;
import com.pti.sdk.types.UnmanagedError;
import java.io.IOException;
import java.lang.Object;
import java.lang.String;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class EstimateTransactionCostClient {
  protected final ClientOptions clientOptions;

  public EstimateTransactionCostClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  public ObjectReference estimationTransactionCost(TradeTransaction request) {
    return estimationTransactionCost(request,null);
  }

  public ObjectReference estimationTransactionCost(TradeTransaction request,
      RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("transactions/trades/price-estimation")
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
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ObjectReference.class);
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      try {
        switch (response.code()) {
          case 400:throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, InvalidRequestError.class));
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
