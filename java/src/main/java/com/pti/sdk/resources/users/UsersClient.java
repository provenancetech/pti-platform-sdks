/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.resources.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pti.sdk.core.ClientOptions;
import com.pti.sdk.core.MediaTypes;
import com.pti.sdk.core.ObjectMappers;
import com.pti.sdk.core.PTIClientApiException;
import com.pti.sdk.core.PTIClientException;
import com.pti.sdk.core.RequestOptions;
import com.pti.sdk.errors.BadRequestError;
import com.pti.sdk.errors.ConflictError;
import com.pti.sdk.errors.ForbiddenError;
import com.pti.sdk.errors.NotFoundError;
import com.pti.sdk.errors.TooManyRequestsError;
import com.pti.sdk.errors.UnauthorizedError;
import com.pti.sdk.errors.UnprocessableEntityError;
import com.pti.sdk.resources.users.requests.GetListOfUsersRequest;
import com.pti.sdk.resources.users.requests.StartUserAssessmentRequest;
import com.pti.sdk.resources.users.requests.UploadDocumentRequest;
import com.pti.sdk.types.InvalidRequestError;
import com.pti.sdk.types.ObjectReference;
import com.pti.sdk.types.OneOfAssessmentValidationError;
import com.pti.sdk.types.OneOfUserSubTypes;
import com.pti.sdk.types.UnmanagedError;
import com.pti.sdk.types.UserAssessStatusObject;
import com.pti.sdk.types.UserPage;
import java.io.File;
import java.io.IOException;
import java.lang.Exception;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.nio.file.Files;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class UsersClient {
  protected final ClientOptions clientOptions;

  public UsersClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  public UserPage getListOfUsers() {
    return getListOfUsers(GetListOfUsersRequest.builder().build());
  }

  public UserPage getListOfUsers(GetListOfUsersRequest request) {
    return getListOfUsers(request,null);
  }

  public UserPage getListOfUsers(GetListOfUsersRequest request, RequestOptions requestOptions) {
    HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

      .addPathSegments("users");if (request.getPage().isPresent()) {
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UserPage.class);
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

    public OneOfUserSubTypes addAUser(OneOfUserSubTypes request) {
      return addAUser(request,null);
    }

    public OneOfUserSubTypes addAUser(OneOfUserSubTypes request, RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), OneOfUserSubTypes.class);
        }
        String responseBodyString = responseBody != null ? responseBody.string() : "{}";
        try {
          switch (response.code()) {
            case 400:throw new BadRequestError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, InvalidRequestError.class));
            case 401:throw new UnauthorizedError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
            case 409:throw new ConflictError(ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnmanagedError.class));
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

    public OneOfUserSubTypes updateUser(OneOfUserSubTypes request) {
      return updateUser(request,null);
    }

    public OneOfUserSubTypes updateUser(OneOfUserSubTypes request, RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
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
        .method("PUT", body)
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), OneOfUserSubTypes.class);
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

    public OneOfUserSubTypes mergeUserInfo(OneOfUserSubTypes request) {
      return mergeUserInfo(request,null);
    }

    public OneOfUserSubTypes mergeUserInfo(OneOfUserSubTypes request,
        RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), OneOfUserSubTypes.class);
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
     * This endpoint is used to get the information for a specific User. The information returned is the information that was collected for the User. PII information is not returned.
     */
    public OneOfUserSubTypes getUser(String userId) {
      return getUser(userId,null);
    }

    /**
     * This endpoint is used to get the information for a specific User. The information returned is the information that was collected for the User. PII information is not returned.
     */
    public OneOfUserSubTypes getUser(String userId, RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
        .addPathSegment(userId)
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), OneOfUserSubTypes.class);
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
     * This endpoint is used to assess a User. Depending on what information is available on the User,  a tier level will be assigned to the assessment, the higher the level is, the more permission he will get on your platform.  Please refer to PTI documentation for more information on the tier levels configuration and scenarios.
     */
    public ObjectReference startUserAssessment(StartUserAssessmentRequest request) {
      return startUserAssessment(request,null);
    }

    /**
     * This endpoint is used to assess a User. Depending on what information is available on the User,  a tier level will be assigned to the assessment, the higher the level is, the more permission he will get on your platform.  Please refer to PTI documentation for more information on the tier levels configuration and scenarios.
     */
    public ObjectReference startUserAssessment(StartUserAssessmentRequest request,
        RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users/assessments")
        .build();
      RequestBody body;
      try {
        body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request.getBody()), MediaTypes.APPLICATION_JSON);
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

    public UserAssessStatusObject getLastKyc(String userId) {
      return getLastKyc(userId,null);
    }

    public UserAssessStatusObject getLastKyc(String userId, RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
        .addPathSegment(userId)
        .addPathSegments("assessments")
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
          return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), UserAssessStatusObject.class);
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

    public void uploadDocument(String userId, Optional<File> document) {
      uploadDocument(userId,document,UploadDocumentRequest.builder().build());
    }

    public void uploadDocument(String userId, Optional<File> document,
        UploadDocumentRequest request) {
      uploadDocument(userId,document,request,null);
    }

    public void uploadDocument(String userId, Optional<File> document,
        UploadDocumentRequest request, RequestOptions requestOptions) {
      HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()

        .addPathSegments("users")
        .addPathSegment(userId)
        .addPathSegments("documents")
        .build();
      MultipartBody.Builder body = new MultipartBody.Builder().setType(MultipartBody.FORM);
      try {
        if (request.getMetaInformation().isPresent()) {
          body.addFormDataPart("metaInformation", ObjectMappers.JSON_MAPPER.writeValueAsString(request.getMetaInformation()));
        }
        if (request.getIdDocumentMetaData().isPresent()) {
          body.addFormDataPart("idDocumentMetaData", ObjectMappers.JSON_MAPPER.writeValueAsString(request.getIdDocumentMetaData()));
        }
        if (document.isPresent()) {
          String documentMimeType = Files.probeContentType(document.get().toPath());
          MediaType documentMimeTypeMediaType = documentMimeType != null ? MediaType.parse(documentMimeType) : null;
          body.addFormDataPart("document", document.get().getName(), RequestBody.create(documentMimeTypeMediaType, document.get()));
        }
      }
      catch(Exception e) {
        throw new RuntimeException(e);
      }
      Request.Builder _requestBuilder = new Request.Builder()
        .url(httpUrl)
        .method("POST", body.build())
        .headers(Headers.of(clientOptions.headers(requestOptions)))
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "application/json");
      Request okhttpRequest = _requestBuilder.build();
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
  }
