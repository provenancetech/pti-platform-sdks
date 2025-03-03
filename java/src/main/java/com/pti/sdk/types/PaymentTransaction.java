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
    builder = PaymentTransaction.Builder.class
)
public final class PaymentTransaction implements ITransactionType, ITransaction {
  private final TransactionTypeEnum type;

  private final Optional<String> id;

  private final Optional<String> transactionGroupId;

  private final Optional<String> subClientId;

  private final Optional<Total> transactionTotal;

  private final Optional<Double> usdValue;

  private final double amount;

  private final String date;

  private final OneOfUserSubTypes initiator;

  private final Optional<Map<String, Object>> ptiMeta;

  private final Optional<Map<String, Object>> clientMeta;

  private final Optional<OneOfPaymentMethod> sourceMethod;

  private final Map<String, Object> additionalProperties;

  private PaymentTransaction(TransactionTypeEnum type, Optional<String> id,
      Optional<String> transactionGroupId, Optional<String> subClientId,
      Optional<Total> transactionTotal, Optional<Double> usdValue, double amount, String date,
      OneOfUserSubTypes initiator, Optional<Map<String, Object>> ptiMeta,
      Optional<Map<String, Object>> clientMeta, Optional<OneOfPaymentMethod> sourceMethod,
      Map<String, Object> additionalProperties) {
    this.type = type;
    this.id = id;
    this.transactionGroupId = transactionGroupId;
    this.subClientId = subClientId;
    this.transactionTotal = transactionTotal;
    this.usdValue = usdValue;
    this.amount = amount;
    this.date = date;
    this.initiator = initiator;
    this.ptiMeta = ptiMeta;
    this.clientMeta = clientMeta;
    this.sourceMethod = sourceMethod;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("type")
  @Override
  public TransactionTypeEnum getType() {
    return type;
  }

  /**
   * @return The id of the transaction/payment. Optional, will be populated with the value provided in the x-pti-request-id header.
   */
  @JsonProperty("id")
  @Override
  public Optional<String> getId() {
    return id;
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

  @JsonProperty("sourceMethod")
  public Optional<OneOfPaymentMethod> getSourceMethod() {
    return sourceMethod;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PaymentTransaction && equalTo((PaymentTransaction) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(PaymentTransaction other) {
    return type.equals(other.type) && id.equals(other.id) && transactionGroupId.equals(other.transactionGroupId) && subClientId.equals(other.subClientId) && transactionTotal.equals(other.transactionTotal) && usdValue.equals(other.usdValue) && amount == other.amount && date.equals(other.date) && initiator.equals(other.initiator) && ptiMeta.equals(other.ptiMeta) && clientMeta.equals(other.clientMeta) && sourceMethod.equals(other.sourceMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.type, this.id, this.transactionGroupId, this.subClientId, this.transactionTotal, this.usdValue, this.amount, this.date, this.initiator, this.ptiMeta, this.clientMeta, this.sourceMethod);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static TypeStage builder() {
    return new Builder();
  }

  public interface TypeStage {
    AmountStage type(@NotNull TransactionTypeEnum type);

    Builder from(PaymentTransaction other);
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
    PaymentTransaction build();

    _FinalStage id(Optional<String> id);

    _FinalStage id(String id);

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

    _FinalStage sourceMethod(Optional<OneOfPaymentMethod> sourceMethod);

    _FinalStage sourceMethod(OneOfPaymentMethod sourceMethod);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TypeStage, AmountStage, DateStage, InitiatorStage, _FinalStage {
    private TransactionTypeEnum type;

    private double amount;

    private String date;

    private OneOfUserSubTypes initiator;

    private Optional<OneOfPaymentMethod> sourceMethod = Optional.empty();

    private Optional<Map<String, Object>> clientMeta = Optional.empty();

    private Optional<Map<String, Object>> ptiMeta = Optional.empty();

    private Optional<Double> usdValue = Optional.empty();

    private Optional<Total> transactionTotal = Optional.empty();

    private Optional<String> subClientId = Optional.empty();

    private Optional<String> transactionGroupId = Optional.empty();

    private Optional<String> id = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(PaymentTransaction other) {
      type(other.getType());
      id(other.getId());
      transactionGroupId(other.getTransactionGroupId());
      subClientId(other.getSubClientId());
      transactionTotal(other.getTransactionTotal());
      usdValue(other.getUsdValue());
      amount(other.getAmount());
      date(other.getDate());
      initiator(other.getInitiator());
      ptiMeta(other.getPtiMeta());
      clientMeta(other.getClientMeta());
      sourceMethod(other.getSourceMethod());
      return this;
    }

    @Override
    @JsonSetter("type")
    public AmountStage type(@NotNull TransactionTypeEnum type) {
      this.type = Objects.requireNonNull(type, "type must not be null");
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

    /**
     * <p>The id of the transaction/payment. Optional, will be populated with the value provided in the x-pti-request-id header.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage id(String id) {
      this.id = Optional.ofNullable(id);
      return this;
    }

    @Override
    @JsonSetter(
        value = "id",
        nulls = Nulls.SKIP
    )
    public _FinalStage id(Optional<String> id) {
      this.id = id;
      return this;
    }

    @Override
    public PaymentTransaction build() {
      return new PaymentTransaction(type, id, transactionGroupId, subClientId, transactionTotal, usdValue, amount, date, initiator, ptiMeta, clientMeta, sourceMethod, additionalProperties);
    }
  }
}
