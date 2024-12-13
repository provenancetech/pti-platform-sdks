/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pti.sdk.core.ObjectMappers;
import java.lang.Double;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = Transaction.Builder.class
)
public final class Transaction implements ITransaction {
  private final Optional<String> transactionGroupId;

  private final Optional<String> subClientId;

  private final Optional<Total> transactionTotal;

  private final Optional<Double> usdValue;

  private final double amount;

  private final String date;

  private final OneOfUserSubTypes initiator;

  private final Optional<Map<String, Object>> ptiMeta;

  private final Optional<Map<String, Object>> clientMeta;

  private final Map<String, Object> additionalProperties;

  private Transaction(Optional<String> transactionGroupId, Optional<String> subClientId,
      Optional<Total> transactionTotal, Optional<Double> usdValue, double amount, String date,
      OneOfUserSubTypes initiator, Optional<Map<String, Object>> ptiMeta,
      Optional<Map<String, Object>> clientMeta, Map<String, Object> additionalProperties) {
    this.transactionGroupId = transactionGroupId;
    this.subClientId = subClientId;
    this.transactionTotal = transactionTotal;
    this.usdValue = usdValue;
    this.amount = amount;
    this.date = date;
    this.initiator = initiator;
    this.ptiMeta = ptiMeta;
    this.clientMeta = clientMeta;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("transactionGroupId")
  @Override
  public Optional<String> getTransactionGroupId() {
    return transactionGroupId;
  }

  @JsonProperty("subClientId")
  @Override
  public Optional<String> getSubClientId() {
    return subClientId;
  }

  @JsonProperty("transactionTotal")
  @Override
  public Optional<Total> getTransactionTotal() {
    return transactionTotal;
  }

  @JsonProperty("usdValue")
  @Override
  public Optional<Double> getUsdValue() {
    return usdValue;
  }

  @JsonProperty("amount")
  @Override
  public double getAmount() {
    return amount;
  }

  /**
   * @return ISO-8601
   */
  @JsonProperty("date")
  @Override
  public String getDate() {
    return date;
  }

  @JsonProperty("initiator")
  @Override
  public OneOfUserSubTypes getInitiator() {
    return initiator;
  }

  /**
   * @return key/value map of extra meta data for this request (used by PTI)
   */
  @JsonProperty("ptiMeta")
  @Override
  public Optional<Map<String, Object>> getPtiMeta() {
    return ptiMeta;
  }

  /**
   * @return key/value map of extra meta data for this request (used by Client)
   */
  @JsonProperty("clientMeta")
  @Override
  public Optional<Map<String, Object>> getClientMeta() {
    return clientMeta;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Transaction && equalTo((Transaction) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(Transaction other) {
    return transactionGroupId.equals(other.transactionGroupId) && subClientId.equals(other.subClientId) && transactionTotal.equals(other.transactionTotal) && usdValue.equals(other.usdValue) && amount == other.amount && date.equals(other.date) && initiator.equals(other.initiator) && ptiMeta.equals(other.ptiMeta) && clientMeta.equals(other.clientMeta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.transactionGroupId, this.subClientId, this.transactionTotal, this.usdValue, this.amount, this.date, this.initiator, this.ptiMeta, this.clientMeta);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static AmountStage builder() {
    return new Builder();
  }

  public interface AmountStage {
    DateStage amount(double amount);

    Builder from(Transaction other);
  }

  public interface DateStage {
    InitiatorStage date(@NotNull String date);
  }

  public interface InitiatorStage {
    _FinalStage initiator(@NotNull OneOfUserSubTypes initiator);
  }

  public interface _FinalStage {
    Transaction build();

    _FinalStage transactionGroupId(Optional<String> transactionGroupId);

    _FinalStage transactionGroupId(String transactionGroupId);

    _FinalStage subClientId(Optional<String> subClientId);

    _FinalStage subClientId(String subClientId);

    _FinalStage transactionTotal(Optional<Total> transactionTotal);

    _FinalStage transactionTotal(Total transactionTotal);

    _FinalStage usdValue(Optional<Double> usdValue);

    _FinalStage usdValue(Double usdValue);

    _FinalStage ptiMeta(Optional<Map<String, Object>> ptiMeta);

    _FinalStage ptiMeta(Map<String, Object> ptiMeta);

    _FinalStage clientMeta(Optional<Map<String, Object>> clientMeta);

    _FinalStage clientMeta(Map<String, Object> clientMeta);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements AmountStage, DateStage, InitiatorStage, _FinalStage {
    private double amount;

    private String date;

    private OneOfUserSubTypes initiator;

    private Optional<Map<String, Object>> clientMeta = Optional.empty();

    private Optional<Map<String, Object>> ptiMeta = Optional.empty();

    private Optional<Double> usdValue = Optional.empty();

    private Optional<Total> transactionTotal = Optional.empty();

    private Optional<String> subClientId = Optional.empty();

    private Optional<String> transactionGroupId = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(Transaction other) {
      transactionGroupId(other.getTransactionGroupId());
      subClientId(other.getSubClientId());
      transactionTotal(other.getTransactionTotal());
      usdValue(other.getUsdValue());
      amount(other.getAmount());
      date(other.getDate());
      initiator(other.getInitiator());
      ptiMeta(other.getPtiMeta());
      clientMeta(other.getClientMeta());
      return this;
    }

    @Override
    @JsonSetter("amount")
    public DateStage amount(double amount) {
      this.amount = amount;
      return this;
    }

    /**
     * <p>ISO-8601</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("date")
    public InitiatorStage date(@NotNull String date) {
      this.date = Objects.requireNonNull(date, "date must not be null");
      return this;
    }

    @Override
    @JsonSetter("initiator")
    public _FinalStage initiator(@NotNull OneOfUserSubTypes initiator) {
      this.initiator = Objects.requireNonNull(initiator, "initiator must not be null");
      return this;
    }

    /**
     * <p>key/value map of extra meta data for this request (used by Client)</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage clientMeta(Map<String, Object> clientMeta) {
      this.clientMeta = Optional.ofNullable(clientMeta);
      return this;
    }

    @Override
    @JsonSetter(
        value = "clientMeta",
        nulls = Nulls.SKIP
    )
    public _FinalStage clientMeta(Optional<Map<String, Object>> clientMeta) {
      this.clientMeta = clientMeta;
      return this;
    }

    /**
     * <p>key/value map of extra meta data for this request (used by PTI)</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage ptiMeta(Map<String, Object> ptiMeta) {
      this.ptiMeta = Optional.ofNullable(ptiMeta);
      return this;
    }

    @Override
    @JsonSetter(
        value = "ptiMeta",
        nulls = Nulls.SKIP
    )
    public _FinalStage ptiMeta(Optional<Map<String, Object>> ptiMeta) {
      this.ptiMeta = ptiMeta;
      return this;
    }

    @Override
    public _FinalStage usdValue(Double usdValue) {
      this.usdValue = Optional.ofNullable(usdValue);
      return this;
    }

    @Override
    @JsonSetter(
        value = "usdValue",
        nulls = Nulls.SKIP
    )
    public _FinalStage usdValue(Optional<Double> usdValue) {
      this.usdValue = usdValue;
      return this;
    }

    @Override
    public _FinalStage transactionTotal(Total transactionTotal) {
      this.transactionTotal = Optional.ofNullable(transactionTotal);
      return this;
    }

    @Override
    @JsonSetter(
        value = "transactionTotal",
        nulls = Nulls.SKIP
    )
    public _FinalStage transactionTotal(Optional<Total> transactionTotal) {
      this.transactionTotal = transactionTotal;
      return this;
    }

    @Override
    public _FinalStage subClientId(String subClientId) {
      this.subClientId = Optional.ofNullable(subClientId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "subClientId",
        nulls = Nulls.SKIP
    )
    public _FinalStage subClientId(Optional<String> subClientId) {
      this.subClientId = subClientId;
      return this;
    }

    @Override
    public _FinalStage transactionGroupId(String transactionGroupId) {
      this.transactionGroupId = Optional.ofNullable(transactionGroupId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "transactionGroupId",
        nulls = Nulls.SKIP
    )
    public _FinalStage transactionGroupId(Optional<String> transactionGroupId) {
      this.transactionGroupId = transactionGroupId;
      return this;
    }

    @Override
    public Transaction build() {
      return new Transaction(transactionGroupId, subClientId, transactionTotal, usdValue, amount, date, initiator, ptiMeta, clientMeta, additionalProperties);
    }
  }
}
