/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.resources.transactionassessment.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pti.sdk.core.ObjectMappers;
import com.pti.sdk.types.OneOfTransactionSubTypes;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = AssessTransactionRequest.Builder.class
)
public final class AssessTransactionRequest {
  private final String ptiRequestId;

  private final String ptiScenarioId;

  private final Optional<String> ptiSessionId;

  private final Optional<Boolean> ptiDisableWebhook;

  private final OneOfTransactionSubTypes body;

  private final Map<String, Object> additionalProperties;

  private AssessTransactionRequest(String ptiRequestId, String ptiScenarioId,
      Optional<String> ptiSessionId, Optional<Boolean> ptiDisableWebhook,
      OneOfTransactionSubTypes body, Map<String, Object> additionalProperties) {
    this.ptiRequestId = ptiRequestId;
    this.ptiScenarioId = ptiScenarioId;
    this.ptiSessionId = ptiSessionId;
    this.ptiDisableWebhook = ptiDisableWebhook;
    this.body = body;
    this.additionalProperties = additionalProperties;
  }

  /**
   * @return Unique identifier of the request. This ID must be provided and stored by the client of this API at the creation of a transaction. This ID is attached to all PTI internal operations as well as the webhook calls. This ID is required to post feedback about a transaction and get support from PTI for a problem on a transaction. Creating two transactions having the same requestId is not allowed.
   */
  @JsonProperty("x-pti-request-id")
  public String getPtiRequestId() {
    return ptiRequestId;
  }

  /**
   * @return Represents a User action under which transaction amounts will accumulated and will control the User Assessment requirements. The values this header can take must be agreed upon and communicated to PTI. Setting unknown values here will generate an error.
   */
  @JsonProperty("x-pti-scenario-id")
  public String getPtiScenarioId() {
    return ptiScenarioId;
  }

  /**
   * @return Session ID associated to a UI session for a specific User. Should match the value passed to the PTI SDK at initialization.
   */
  @JsonProperty("x-pti-session-id")
  public Optional<String> getPtiSessionId() {
    return ptiSessionId;
  }

  /**
   * @return Set to true to disable webhook calls for this request.
   */
  @JsonProperty("x-pti-disable-webhook")
  public Optional<Boolean> getPtiDisableWebhook() {
    return ptiDisableWebhook;
  }

  @JsonProperty("body")
  public OneOfTransactionSubTypes getBody() {
    return body;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AssessTransactionRequest && equalTo((AssessTransactionRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(AssessTransactionRequest other) {
    return ptiRequestId.equals(other.ptiRequestId) && ptiScenarioId.equals(other.ptiScenarioId) && ptiSessionId.equals(other.ptiSessionId) && ptiDisableWebhook.equals(other.ptiDisableWebhook) && body.equals(other.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.ptiRequestId, this.ptiScenarioId, this.ptiSessionId, this.ptiDisableWebhook, this.body);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static PtiRequestIdStage builder() {
    return new Builder();
  }

  public interface PtiRequestIdStage {
    PtiScenarioIdStage ptiRequestId(@NotNull String ptiRequestId);

    Builder from(AssessTransactionRequest other);
  }

  public interface PtiScenarioIdStage {
    BodyStage ptiScenarioId(@NotNull String ptiScenarioId);
  }

  public interface BodyStage {
    _FinalStage body(@NotNull OneOfTransactionSubTypes body);
  }

  public interface _FinalStage {
    AssessTransactionRequest build();

    _FinalStage ptiSessionId(Optional<String> ptiSessionId);

    _FinalStage ptiSessionId(String ptiSessionId);

    _FinalStage ptiDisableWebhook(Optional<Boolean> ptiDisableWebhook);

    _FinalStage ptiDisableWebhook(Boolean ptiDisableWebhook);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PtiRequestIdStage, PtiScenarioIdStage, BodyStage, _FinalStage {
    private String ptiRequestId;

    private String ptiScenarioId;

    private OneOfTransactionSubTypes body;

    private Optional<Boolean> ptiDisableWebhook = Optional.empty();

    private Optional<String> ptiSessionId = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(AssessTransactionRequest other) {
      ptiRequestId(other.getPtiRequestId());
      ptiScenarioId(other.getPtiScenarioId());
      ptiSessionId(other.getPtiSessionId());
      ptiDisableWebhook(other.getPtiDisableWebhook());
      body(other.getBody());
      return this;
    }

    /**
     * <p>Unique identifier of the request. This ID must be provided and stored by the client of this API at the creation of a transaction. This ID is attached to all PTI internal operations as well as the webhook calls. This ID is required to post feedback about a transaction and get support from PTI for a problem on a transaction. Creating two transactions having the same requestId is not allowed.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("x-pti-request-id")
    public PtiScenarioIdStage ptiRequestId(@NotNull String ptiRequestId) {
      this.ptiRequestId = Objects.requireNonNull(ptiRequestId, "ptiRequestId must not be null");
      return this;
    }

    /**
     * <p>Represents a User action under which transaction amounts will accumulated and will control the User Assessment requirements. The values this header can take must be agreed upon and communicated to PTI. Setting unknown values here will generate an error.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("x-pti-scenario-id")
    public BodyStage ptiScenarioId(@NotNull String ptiScenarioId) {
      this.ptiScenarioId = Objects.requireNonNull(ptiScenarioId, "ptiScenarioId must not be null");
      return this;
    }

    @Override
    @JsonSetter("body")
    public _FinalStage body(@NotNull OneOfTransactionSubTypes body) {
      this.body = Objects.requireNonNull(body, "body must not be null");
      return this;
    }

    /**
     * <p>Set to true to disable webhook calls for this request.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage ptiDisableWebhook(Boolean ptiDisableWebhook) {
      this.ptiDisableWebhook = Optional.ofNullable(ptiDisableWebhook);
      return this;
    }

    @Override
    @JsonSetter(
        value = "x-pti-disable-webhook",
        nulls = Nulls.SKIP
    )
    public _FinalStage ptiDisableWebhook(Optional<Boolean> ptiDisableWebhook) {
      this.ptiDisableWebhook = ptiDisableWebhook;
      return this;
    }

    /**
     * <p>Session ID associated to a UI session for a specific User. Should match the value passed to the PTI SDK at initialization.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage ptiSessionId(String ptiSessionId) {
      this.ptiSessionId = Optional.ofNullable(ptiSessionId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "x-pti-session-id",
        nulls = Nulls.SKIP
    )
    public _FinalStage ptiSessionId(Optional<String> ptiSessionId) {
      this.ptiSessionId = ptiSessionId;
      return this;
    }

    @Override
    public AssessTransactionRequest build() {
      return new AssessTransactionRequest(ptiRequestId, ptiScenarioId, ptiSessionId, ptiDisableWebhook, body, additionalProperties);
    }
  }
}
