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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pti.sdk.core.ObjectMappers;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = FeeRecipient.Builder.class
)
public final class FeeRecipient {
  private final String feeRecipientId;

  private final String walletId;

  private final String currency;

  private final double amount;

  private final FeeRecipientFeeRecipientType feeRecipientType;

  private final Map<String, Object> additionalProperties;

  private FeeRecipient(String feeRecipientId, String walletId, String currency, double amount,
      FeeRecipientFeeRecipientType feeRecipientType, Map<String, Object> additionalProperties) {
    this.feeRecipientId = feeRecipientId;
    this.walletId = walletId;
    this.currency = currency;
    this.amount = amount;
    this.feeRecipientType = feeRecipientType;
    this.additionalProperties = additionalProperties;
  }

  /**
   * @return User ID of the Commission Recipient
   */
  @JsonProperty("feeRecipientId")
  public String getFeeRecipientId() {
    return feeRecipientId;
  }

  @JsonProperty("walletId")
  public String getWalletId() {
    return walletId;
  }

  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  @JsonProperty("amount")
  public double getAmount() {
    return amount;
  }

  @JsonProperty("feeRecipientType")
  public FeeRecipientFeeRecipientType getFeeRecipientType() {
    return feeRecipientType;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FeeRecipient && equalTo((FeeRecipient) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(FeeRecipient other) {
    return feeRecipientId.equals(other.feeRecipientId) && walletId.equals(other.walletId) && currency.equals(other.currency) && amount == other.amount && feeRecipientType.equals(other.feeRecipientType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.feeRecipientId, this.walletId, this.currency, this.amount, this.feeRecipientType);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static FeeRecipientIdStage builder() {
    return new Builder();
  }

  public interface FeeRecipientIdStage {
    WalletIdStage feeRecipientId(@NotNull String feeRecipientId);

    Builder from(FeeRecipient other);
  }

  public interface WalletIdStage {
    CurrencyStage walletId(@NotNull String walletId);
  }

  public interface CurrencyStage {
    AmountStage currency(@NotNull String currency);
  }

  public interface AmountStage {
    FeeRecipientTypeStage amount(double amount);
  }

  public interface FeeRecipientTypeStage {
    _FinalStage feeRecipientType(@NotNull FeeRecipientFeeRecipientType feeRecipientType);
  }

  public interface _FinalStage {
    FeeRecipient build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements FeeRecipientIdStage, WalletIdStage, CurrencyStage, AmountStage, FeeRecipientTypeStage, _FinalStage {
    private String feeRecipientId;

    private String walletId;

    private String currency;

    private double amount;

    private FeeRecipientFeeRecipientType feeRecipientType;

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(FeeRecipient other) {
      feeRecipientId(other.getFeeRecipientId());
      walletId(other.getWalletId());
      currency(other.getCurrency());
      amount(other.getAmount());
      feeRecipientType(other.getFeeRecipientType());
      return this;
    }

    /**
     * <p>User ID of the Commission Recipient</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("feeRecipientId")
    public WalletIdStage feeRecipientId(@NotNull String feeRecipientId) {
      this.feeRecipientId = Objects.requireNonNull(feeRecipientId, "feeRecipientId must not be null");
      return this;
    }

    @Override
    @JsonSetter("walletId")
    public CurrencyStage walletId(@NotNull String walletId) {
      this.walletId = Objects.requireNonNull(walletId, "walletId must not be null");
      return this;
    }

    @Override
    @JsonSetter("currency")
    public AmountStage currency(@NotNull String currency) {
      this.currency = Objects.requireNonNull(currency, "currency must not be null");
      return this;
    }

    @Override
    @JsonSetter("amount")
    public FeeRecipientTypeStage amount(double amount) {
      this.amount = amount;
      return this;
    }

    @Override
    @JsonSetter("feeRecipientType")
    public _FinalStage feeRecipientType(@NotNull FeeRecipientFeeRecipientType feeRecipientType) {
      this.feeRecipientType = Objects.requireNonNull(feeRecipientType, "feeRecipientType must not be null");
      return this;
    }

    @Override
    public FeeRecipient build() {
      return new FeeRecipient(feeRecipientId, walletId, currency, amount, feeRecipientType, additionalProperties);
    }
  }
}
