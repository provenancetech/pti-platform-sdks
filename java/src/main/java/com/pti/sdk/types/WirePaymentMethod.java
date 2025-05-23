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

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = WirePaymentMethod.Builder.class
)
public final class WirePaymentMethod {
  private final Optional<String> currency;

  private final Optional<String> purposeOfPayment;

  private final Optional<String> memo;

  private final Optional<String> billingEmail;

  private final Optional<OneOfFiatPaymentInformation> paymentInformation;

  private final Map<String, Object> additionalProperties;

  private WirePaymentMethod(Optional<String> currency, Optional<String> purposeOfPayment,
      Optional<String> memo, Optional<String> billingEmail,
      Optional<OneOfFiatPaymentInformation> paymentInformation,
      Map<String, Object> additionalProperties) {
    this.currency = currency;
    this.purposeOfPayment = purposeOfPayment;
    this.memo = memo;
    this.billingEmail = billingEmail;
    this.paymentInformation = paymentInformation;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("currency")
  public Optional<String> getCurrency() {
    return currency;
  }

  @JsonProperty("purposeOfPayment")
  public Optional<String> getPurposeOfPayment() {
    return purposeOfPayment;
  }

  @JsonProperty("memo")
  public Optional<String> getMemo() {
    return memo;
  }

  @JsonProperty("billingEmail")
  public Optional<String> getBillingEmail() {
    return billingEmail;
  }

  @JsonProperty("paymentInformation")
  public Optional<OneOfFiatPaymentInformation> getPaymentInformation() {
    return paymentInformation;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof WirePaymentMethod && equalTo((WirePaymentMethod) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(WirePaymentMethod other) {
    return currency.equals(other.currency) && purposeOfPayment.equals(other.purposeOfPayment) && memo.equals(other.memo) && billingEmail.equals(other.billingEmail) && paymentInformation.equals(other.paymentInformation);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.currency, this.purposeOfPayment, this.memo, this.billingEmail, this.paymentInformation);
  }

  @java.lang.Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> currency = Optional.empty();

    private Optional<String> purposeOfPayment = Optional.empty();

    private Optional<String> memo = Optional.empty();

    private Optional<String> billingEmail = Optional.empty();

    private Optional<OneOfFiatPaymentInformation> paymentInformation = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(WirePaymentMethod other) {
      currency(other.getCurrency());
      purposeOfPayment(other.getPurposeOfPayment());
      memo(other.getMemo());
      billingEmail(other.getBillingEmail());
      paymentInformation(other.getPaymentInformation());
      return this;
    }

    @JsonSetter(
        value = "currency",
        nulls = Nulls.SKIP
    )
    public Builder currency(Optional<String> currency) {
      this.currency = currency;
      return this;
    }

    public Builder currency(String currency) {
      this.currency = Optional.ofNullable(currency);
      return this;
    }

    @JsonSetter(
        value = "purposeOfPayment",
        nulls = Nulls.SKIP
    )
    public Builder purposeOfPayment(Optional<String> purposeOfPayment) {
      this.purposeOfPayment = purposeOfPayment;
      return this;
    }

    public Builder purposeOfPayment(String purposeOfPayment) {
      this.purposeOfPayment = Optional.ofNullable(purposeOfPayment);
      return this;
    }

    @JsonSetter(
        value = "memo",
        nulls = Nulls.SKIP
    )
    public Builder memo(Optional<String> memo) {
      this.memo = memo;
      return this;
    }

    public Builder memo(String memo) {
      this.memo = Optional.ofNullable(memo);
      return this;
    }

    @JsonSetter(
        value = "billingEmail",
        nulls = Nulls.SKIP
    )
    public Builder billingEmail(Optional<String> billingEmail) {
      this.billingEmail = billingEmail;
      return this;
    }

    public Builder billingEmail(String billingEmail) {
      this.billingEmail = Optional.ofNullable(billingEmail);
      return this;
    }

    @JsonSetter(
        value = "paymentInformation",
        nulls = Nulls.SKIP
    )
    public Builder paymentInformation(Optional<OneOfFiatPaymentInformation> paymentInformation) {
      this.paymentInformation = paymentInformation;
      return this;
    }

    public Builder paymentInformation(OneOfFiatPaymentInformation paymentInformation) {
      this.paymentInformation = Optional.ofNullable(paymentInformation);
      return this;
    }

    public WirePaymentMethod build() {
      return new WirePaymentMethod(currency, purposeOfPayment, memo, billingEmail, paymentInformation, additionalProperties);
    }
  }
}
