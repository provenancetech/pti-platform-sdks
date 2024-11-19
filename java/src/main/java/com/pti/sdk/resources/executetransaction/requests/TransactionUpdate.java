/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.resources.executetransaction.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pti.sdk.core.ObjectMappers;
import com.pti.sdk.resources.executetransaction.types.TransactionUpdateFeedback;
import com.pti.sdk.resources.executetransaction.types.TransactionUpdateProviderName;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = TransactionUpdate.Builder.class
)
public final class TransactionUpdate {
  private final Optional<String> payload;

  private final TransactionUpdateProviderName providerName;

  private final TransactionUpdateFeedback feedback;

  private final Optional<String> transactionId;

  private final Optional<String> date;

  private final Map<String, Object> additionalProperties;

  private TransactionUpdate(Optional<String> payload, TransactionUpdateProviderName providerName,
      TransactionUpdateFeedback feedback, Optional<String> transactionId, Optional<String> date,
      Map<String, Object> additionalProperties) {
    this.payload = payload;
    this.providerName = providerName;
    this.feedback = feedback;
    this.transactionId = transactionId;
    this.date = date;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("payload")
  public Optional<String> getPayload() {
    return payload;
  }

  @JsonProperty("providerName")
  public TransactionUpdateProviderName getProviderName() {
    return providerName;
  }

  @JsonProperty("feedback")
  public TransactionUpdateFeedback getFeedback() {
    return feedback;
  }

  /**
   * @return A transaction hash or any relevant identifier for the transaction
   */
  @JsonProperty("transactionId")
  public Optional<String> getTransactionId() {
    return transactionId;
  }

  /**
   * @return Timestamp when the transaction feedback changed. This will be used in transaction reports. If not provided, it will be set to the time at which the api call is made. The format must be compatible with the ISO-8601 standard. e.g. 2022-01-01T00:00:00
   */
  @JsonProperty("date")
  public Optional<String> getDate() {
    return date;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof TransactionUpdate && equalTo((TransactionUpdate) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(TransactionUpdate other) {
    return payload.equals(other.payload) && providerName.equals(other.providerName) && feedback.equals(other.feedback) && transactionId.equals(other.transactionId) && date.equals(other.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.payload, this.providerName, this.feedback, this.transactionId, this.date);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static ProviderNameStage builder() {
    return new Builder();
  }

  public interface ProviderNameStage {
    FeedbackStage providerName(@NotNull TransactionUpdateProviderName providerName);

    Builder from(TransactionUpdate other);
  }

  public interface FeedbackStage {
    _FinalStage feedback(@NotNull TransactionUpdateFeedback feedback);
  }

  public interface _FinalStage {
    TransactionUpdate build();

    _FinalStage payload(Optional<String> payload);

    _FinalStage payload(String payload);

    _FinalStage transactionId(Optional<String> transactionId);

    _FinalStage transactionId(String transactionId);

    _FinalStage date(Optional<String> date);

    _FinalStage date(String date);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ProviderNameStage, FeedbackStage, _FinalStage {
    private TransactionUpdateProviderName providerName;

    private TransactionUpdateFeedback feedback;

    private Optional<String> date = Optional.empty();

    private Optional<String> transactionId = Optional.empty();

    private Optional<String> payload = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(TransactionUpdate other) {
      payload(other.getPayload());
      providerName(other.getProviderName());
      feedback(other.getFeedback());
      transactionId(other.getTransactionId());
      date(other.getDate());
      return this;
    }

    @Override
    @JsonSetter("providerName")
    public FeedbackStage providerName(@NotNull TransactionUpdateProviderName providerName) {
      this.providerName = Objects.requireNonNull(providerName, "providerName must not be null");
      return this;
    }

    @Override
    @JsonSetter("feedback")
    public _FinalStage feedback(@NotNull TransactionUpdateFeedback feedback) {
      this.feedback = Objects.requireNonNull(feedback, "feedback must not be null");
      return this;
    }

    /**
     * <p>Timestamp when the transaction feedback changed. This will be used in transaction reports. If not provided, it will be set to the time at which the api call is made. The format must be compatible with the ISO-8601 standard. e.g. 2022-01-01T00:00:00</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage date(String date) {
      this.date = Optional.ofNullable(date);
      return this;
    }

    @Override
    @JsonSetter(
        value = "date",
        nulls = Nulls.SKIP
    )
    public _FinalStage date(Optional<String> date) {
      this.date = date;
      return this;
    }

    /**
     * <p>A transaction hash or any relevant identifier for the transaction</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage transactionId(String transactionId) {
      this.transactionId = Optional.ofNullable(transactionId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "transactionId",
        nulls = Nulls.SKIP
    )
    public _FinalStage transactionId(Optional<String> transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    @Override
    public _FinalStage payload(String payload) {
      this.payload = Optional.ofNullable(payload);
      return this;
    }

    @Override
    @JsonSetter(
        value = "payload",
        nulls = Nulls.SKIP
    )
    public _FinalStage payload(Optional<String> payload) {
      this.payload = payload;
      return this;
    }

    @Override
    public TransactionUpdate build() {
      return new TransactionUpdate(payload, providerName, feedback, transactionId, date, additionalProperties);
    }
  }
}
