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
import com.pti.sdk.types.ITransactionType;
import com.pti.sdk.types.OneOfExternalPaymentMethod;
import com.pti.sdk.types.OneOfUserSubTypes;
import com.pti.sdk.types.Total;
import com.pti.sdk.types.TransactionTypeEnum;
import com.pti.sdk.types.WalletPaymentMethod;
import java.lang.Boolean;
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
    builder = ExecuteDepositTransaction.Builder.class
)
public final class ExecuteDepositTransaction implements ITransactionType {
  private final TransactionTypeEnum type;

  private final Optional<String> transactionGroupId;

  private final Optional<String> subClientId;

  private final Optional<Total> transactionTotal;

  private final Optional<Double> usdValue;

  private final double amount;

  private final String date;

  private final OneOfUserSubTypes initiator;

  private final Optional<Map<String, Object>> ptiMeta;

  private final Optional<Map<String, Object>> clientMeta;

  private final String ptiRequestId;

  private final String ptiScenarioId;

  private final Optional<String> ptiSessionId;

  private final Optional<Boolean> ptiDisableWebhook;

  private final Optional<String> ptiProviderName;

  private final OneOfExternalPaymentMethod sourceMethod;

  private final Optional<WalletPaymentMethod> destinationMethod;

  private final Map<String, Object> additionalProperties;

  private ExecuteDepositTransaction(TransactionTypeEnum type, Optional<String> transactionGroupId,
      Optional<String> subClientId, Optional<Total> transactionTotal, Optional<Double> usdValue,
      double amount, String date, OneOfUserSubTypes initiator,
      Optional<Map<String, Object>> ptiMeta, Optional<Map<String, Object>> clientMeta,
      String ptiRequestId, String ptiScenarioId, Optional<String> ptiSessionId,
      Optional<Boolean> ptiDisableWebhook, Optional<String> ptiProviderName,
      OneOfExternalPaymentMethod sourceMethod, Optional<WalletPaymentMethod> destinationMethod,
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
    this.ptiRequestId = ptiRequestId;
    this.ptiScenarioId = ptiScenarioId;
    this.ptiSessionId = ptiSessionId;
    this.ptiDisableWebhook = ptiDisableWebhook;
    this.ptiProviderName = ptiProviderName;
    this.sourceMethod = sourceMethod;
    this.destinationMethod = destinationMethod;
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

  /**
   * @return Unique identifier of the request. This ID must be provided and stored by the client of this API at the creation of a transaction. This ID is attached to all PTI internal operations as well as the webhook calls. This ID is required to post feedback about a transaction and get support from PTI for a problem on a transaction. Creating two transactions having the same requestId is not allowed.
   */
  @JsonProperty("x-pti-request-id")
  public String getPtiRequestId() {
    return ptiRequestId;
  }

  /**
   * @return Represents a user action under which transaction amounts will accumulated and will control the User assessment requirements. The values this header can take must be agreed upon and communicated to PTI. Setting unknown values here will generate an error.
   */
  @JsonProperty("x-pti-scenario-id")
  public String getPtiScenarioId() {
    return ptiScenarioId;
  }

  /**
   * @return Session ID associated to a UI session for a specific user. Should match the value passed to the PTI SDK at initialization.
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

  /**
   * @return Used to specify which provider is responsible for handling the given operation. Ignored if the client configuration is not set for passive mode.
   */
  @JsonProperty("x-pti-provider-name")
  public Optional<String> getPtiProviderName() {
    return ptiProviderName;
  }

  @JsonProperty("sourceMethod")
  public OneOfExternalPaymentMethod getSourceMethod() {
    return sourceMethod;
  }

  @JsonProperty("destinationMethod")
  public Optional<WalletPaymentMethod> getDestinationMethod() {
    return destinationMethod;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ExecuteDepositTransaction && equalTo((ExecuteDepositTransaction) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(ExecuteDepositTransaction other) {
    return type.equals(other.type) && transactionGroupId.equals(other.transactionGroupId) && subClientId.equals(other.subClientId) && transactionTotal.equals(other.transactionTotal) && usdValue.equals(other.usdValue) && amount == other.amount && date.equals(other.date) && initiator.equals(other.initiator) && ptiMeta.equals(other.ptiMeta) && clientMeta.equals(other.clientMeta) && ptiRequestId.equals(other.ptiRequestId) && ptiScenarioId.equals(other.ptiScenarioId) && ptiSessionId.equals(other.ptiSessionId) && ptiDisableWebhook.equals(other.ptiDisableWebhook) && ptiProviderName.equals(other.ptiProviderName) && sourceMethod.equals(other.sourceMethod) && destinationMethod.equals(other.destinationMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.type, this.transactionGroupId, this.subClientId, this.transactionTotal, this.usdValue, this.amount, this.date, this.initiator, this.ptiMeta, this.clientMeta, this.ptiRequestId, this.ptiScenarioId, this.ptiSessionId, this.ptiDisableWebhook, this.ptiProviderName, this.sourceMethod, this.destinationMethod);
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

    Builder from(ExecuteDepositTransaction other);
  }

  public interface AmountStage {
    DateStage amount(double amount);
  }

  public interface DateStage {
    InitiatorStage date(@NotNull String date);
  }

  public interface InitiatorStage {
    PtiRequestIdStage initiator(@NotNull OneOfUserSubTypes initiator);
  }

  public interface PtiRequestIdStage {
    PtiScenarioIdStage ptiRequestId(@NotNull String ptiRequestId);
  }

  public interface PtiScenarioIdStage {
    SourceMethodStage ptiScenarioId(@NotNull String ptiScenarioId);
  }

  public interface SourceMethodStage {
    _FinalStage sourceMethod(@NotNull OneOfExternalPaymentMethod sourceMethod);
  }

  public interface _FinalStage {
    ExecuteDepositTransaction build();

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

    _FinalStage ptiSessionId(Optional<String> ptiSessionId);

    _FinalStage ptiSessionId(String ptiSessionId);

    _FinalStage ptiDisableWebhook(Optional<Boolean> ptiDisableWebhook);

    _FinalStage ptiDisableWebhook(Boolean ptiDisableWebhook);

    _FinalStage ptiProviderName(Optional<String> ptiProviderName);

    _FinalStage ptiProviderName(String ptiProviderName);

    _FinalStage destinationMethod(Optional<WalletPaymentMethod> destinationMethod);

    _FinalStage destinationMethod(WalletPaymentMethod destinationMethod);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TypeStage, AmountStage, DateStage, InitiatorStage, PtiRequestIdStage, PtiScenarioIdStage, SourceMethodStage, _FinalStage {
    private TransactionTypeEnum type;

    private double amount;

    private String date;

    private OneOfUserSubTypes initiator;

    private String ptiRequestId;

    private String ptiScenarioId;

    private OneOfExternalPaymentMethod sourceMethod;

    private Optional<WalletPaymentMethod> destinationMethod = Optional.empty();

    private Optional<String> ptiProviderName = Optional.empty();

    private Optional<Boolean> ptiDisableWebhook = Optional.empty();

    private Optional<String> ptiSessionId = Optional.empty();

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
    public Builder from(ExecuteDepositTransaction other) {
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
      ptiRequestId(other.getPtiRequestId());
      ptiScenarioId(other.getPtiScenarioId());
      ptiSessionId(other.getPtiSessionId());
      ptiDisableWebhook(other.getPtiDisableWebhook());
      ptiProviderName(other.getPtiProviderName());
      sourceMethod(other.getSourceMethod());
      destinationMethod(other.getDestinationMethod());
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
    public PtiRequestIdStage initiator(@NotNull OneOfUserSubTypes initiator) {
      this.initiator = Objects.requireNonNull(initiator, "initiator must not be null");
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
     * <p>Represents a user action under which transaction amounts will accumulated and will control the User assessment requirements. The values this header can take must be agreed upon and communicated to PTI. Setting unknown values here will generate an error.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("x-pti-scenario-id")
    public SourceMethodStage ptiScenarioId(@NotNull String ptiScenarioId) {
      this.ptiScenarioId = Objects.requireNonNull(ptiScenarioId, "ptiScenarioId must not be null");
      return this;
    }

    @Override
    @JsonSetter("sourceMethod")
    public _FinalStage sourceMethod(@NotNull OneOfExternalPaymentMethod sourceMethod) {
      this.sourceMethod = Objects.requireNonNull(sourceMethod, "sourceMethod must not be null");
      return this;
    }

    @Override
    public _FinalStage destinationMethod(WalletPaymentMethod destinationMethod) {
      this.destinationMethod = Optional.ofNullable(destinationMethod);
      return this;
    }

    @Override
    @JsonSetter(
        value = "destinationMethod",
        nulls = Nulls.SKIP
    )
    public _FinalStage destinationMethod(Optional<WalletPaymentMethod> destinationMethod) {
      this.destinationMethod = destinationMethod;
      return this;
    }

    /**
     * <p>Used to specify which provider is responsible for handling the given operation. Ignored if the client configuration is not set for passive mode.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage ptiProviderName(String ptiProviderName) {
      this.ptiProviderName = Optional.ofNullable(ptiProviderName);
      return this;
    }

    @Override
    @JsonSetter(
        value = "x-pti-provider-name",
        nulls = Nulls.SKIP
    )
    public _FinalStage ptiProviderName(Optional<String> ptiProviderName) {
      this.ptiProviderName = ptiProviderName;
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
     * <p>Session ID associated to a UI session for a specific user. Should match the value passed to the PTI SDK at initialization.</p>
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
    public ExecuteDepositTransaction build() {
      return new ExecuteDepositTransaction(type, transactionGroupId, subClientId, transactionTotal, usdValue, amount, date, initiator, ptiMeta, clientMeta, ptiRequestId, ptiScenarioId, ptiSessionId, ptiDisableWebhook, ptiProviderName, sourceMethod, destinationMethod, additionalProperties);
    }
  }
}
