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
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = WithdrawalTransaction.Builder.class
)
public final class WithdrawalTransaction implements ITransactionType {
  private final TransactionTypeEnum type;

  private final Optional<String> transactionGroupId;

  private final Optional<String> subClientId;

  private final Optional<Total> transactionTotal;

  private final double usdValue;

  private final double amount;

  private final String date;

  private final OneOfUserSubTypes initiator;

  private final Optional<Map<String, Object>> ptiMeta;

  private final Optional<Map<String, Object>> clientMeta;

  private final Optional<OneOfPaymentMethod> destinationMethod;

  private final Optional<OneOfPaymentMethod> sourceMethod;

  private final Map<String, Object> additionalProperties;

  private WithdrawalTransaction(TransactionTypeEnum type, Optional<String> transactionGroupId,
      Optional<String> subClientId, Optional<Total> transactionTotal, double usdValue,
      double amount, String date, OneOfUserSubTypes initiator,
      Optional<Map<String, Object>> ptiMeta, Optional<Map<String, Object>> clientMeta,
      Optional<OneOfPaymentMethod> destinationMethod, Optional<OneOfPaymentMethod> sourceMethod,
      Map<String, Object> additionalProperties) {
    this.type = type;
    this.transactionGroupId = transactionGroupId;
    this.subClientId = subClientId;
    this.transactionTotal = transactionTotal;
    this.usdValue = usdValue;
    this.amount = amount;
    this.date = date;
    this.initiator = initiator;
    this.ptiMeta = ptiMeta;
    this.clientMeta = clientMeta;
    this.destinationMethod = destinationMethod;
    this.sourceMethod = sourceMethod;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("type")
  @Override
  public TransactionTypeEnum getType() {
    return type;
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
  public double getUsdValue() {
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

  @JsonProperty("destinationMethod")
  public Optional<OneOfPaymentMethod> getDestinationMethod() {
    return destinationMethod;
  }

  @JsonProperty("sourceMethod")
  public Optional<OneOfPaymentMethod> getSourceMethod() {
    return sourceMethod;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof WithdrawalTransaction && equalTo((WithdrawalTransaction) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(WithdrawalTransaction other) {
    return type.equals(other.type) && transactionGroupId.equals(other.transactionGroupId) && subClientId.equals(other.subClientId) && transactionTotal.equals(other.transactionTotal) && usdValue == other.usdValue && amount == other.amount && date.equals(other.date) && initiator.equals(other.initiator) && ptiMeta.equals(other.ptiMeta) && clientMeta.equals(other.clientMeta) && destinationMethod.equals(other.destinationMethod) && sourceMethod.equals(other.sourceMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.type, this.transactionGroupId, this.subClientId, this.transactionTotal, this.usdValue, this.amount, this.date, this.initiator, this.ptiMeta, this.clientMeta, this.destinationMethod, this.sourceMethod);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static TypeStage builder() {
    return new Builder();
  }

  public interface TypeStage {
    UsdValueStage type(@NotNull TransactionTypeEnum type);

    Builder from(WithdrawalTransaction other);
  }

  public interface UsdValueStage {
    AmountStage usdValue(double usdValue);
  }

  public interface AmountStage {
    DateStage amount(double amount);
  }

  public interface DateStage {
    InitiatorStage date(@NotNull String date);
  }

  public interface InitiatorStage {
    _FinalStage initiator(@NotNull OneOfUserSubTypes initiator);
  }

  public interface _FinalStage {
    WithdrawalTransaction build();

    _FinalStage transactionGroupId(Optional<String> transactionGroupId);

    _FinalStage transactionGroupId(String transactionGroupId);

    _FinalStage subClientId(Optional<String> subClientId);

    _FinalStage subClientId(String subClientId);

    _FinalStage transactionTotal(Optional<Total> transactionTotal);

    _FinalStage transactionTotal(Total transactionTotal);

    _FinalStage ptiMeta(Optional<Map<String, Object>> ptiMeta);

    _FinalStage ptiMeta(Map<String, Object> ptiMeta);

    _FinalStage clientMeta(Optional<Map<String, Object>> clientMeta);

    _FinalStage clientMeta(Map<String, Object> clientMeta);

    _FinalStage destinationMethod(Optional<OneOfPaymentMethod> destinationMethod);

    _FinalStage destinationMethod(OneOfPaymentMethod destinationMethod);

    _FinalStage sourceMethod(Optional<OneOfPaymentMethod> sourceMethod);

    _FinalStage sourceMethod(OneOfPaymentMethod sourceMethod);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TypeStage, UsdValueStage, AmountStage, DateStage, InitiatorStage, _FinalStage {
    private TransactionTypeEnum type;

    private double usdValue;

    private double amount;

    private String date;

    private OneOfUserSubTypes initiator;

    private Optional<OneOfPaymentMethod> sourceMethod = Optional.empty();

    private Optional<OneOfPaymentMethod> destinationMethod = Optional.empty();

    private Optional<Map<String, Object>> clientMeta = Optional.empty();

    private Optional<Map<String, Object>> ptiMeta = Optional.empty();

    private Optional<Total> transactionTotal = Optional.empty();

    private Optional<String> subClientId = Optional.empty();

    private Optional<String> transactionGroupId = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(WithdrawalTransaction other) {
      type(other.getType());
      transactionGroupId(other.getTransactionGroupId());
      subClientId(other.getSubClientId());
      transactionTotal(other.getTransactionTotal());
      usdValue(other.getUsdValue());
      amount(other.getAmount());
      date(other.getDate());
      initiator(other.getInitiator());
      ptiMeta(other.getPtiMeta());
      clientMeta(other.getClientMeta());
      destinationMethod(other.getDestinationMethod());
      sourceMethod(other.getSourceMethod());
      return this;
    }

    @Override
    @JsonSetter("type")
    public UsdValueStage type(@NotNull TransactionTypeEnum type) {
      this.type = Objects.requireNonNull(type, "type must not be null");
      return this;
    }

    @Override
    @JsonSetter("usdValue")
    public AmountStage usdValue(double usdValue) {
      this.usdValue = usdValue;
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

    @Override
    public _FinalStage sourceMethod(OneOfPaymentMethod sourceMethod) {
      this.sourceMethod = Optional.ofNullable(sourceMethod);
      return this;
    }

    @Override
    @JsonSetter(
        value = "sourceMethod",
        nulls = Nulls.SKIP
    )
    public _FinalStage sourceMethod(Optional<OneOfPaymentMethod> sourceMethod) {
      this.sourceMethod = sourceMethod;
      return this;
    }

    @Override
    public _FinalStage destinationMethod(OneOfPaymentMethod destinationMethod) {
      this.destinationMethod = Optional.ofNullable(destinationMethod);
      return this;
    }

    @Override
    @JsonSetter(
        value = "destinationMethod",
        nulls = Nulls.SKIP
    )
    public _FinalStage destinationMethod(Optional<OneOfPaymentMethod> destinationMethod) {
      this.destinationMethod = destinationMethod;
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
    public WithdrawalTransaction build() {
      return new WithdrawalTransaction(type, transactionGroupId, subClientId, transactionTotal, usdValue, amount, date, initiator, ptiMeta, clientMeta, destinationMethod, sourceMethod, additionalProperties);
    }
  }
}
