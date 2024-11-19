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
    builder = FiatPaymentMethod.Builder.class
)
public final class FiatPaymentMethod {
  private final Optional<String> currency;

  private final Optional<String> billingEmail;

  private final Optional<OneOfFiatPaymentInformation> paymentInformation;

  private final Map<String, Object> additionalProperties;

  private FiatPaymentMethod(Optional<String> currency, Optional<String> billingEmail,
      Optional<OneOfFiatPaymentInformation> paymentInformation,
      Map<String, Object> additionalProperties) {
    this.currency = currency;
    this.billingEmail = billingEmail;
    this.paymentInformation = paymentInformation;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("currency")
  public Optional<String> getCurrency() {
    return currency;
  }

  @JsonProperty("billingEmail")
  public Optional<String> getBillingEmail() {
    return billingEmail;
  }

  @JsonProperty("paymentInformation")
  public Optional<OneOfFiatPaymentInformation> getPaymentInformation() {
    return paymentInformation;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FiatPaymentMethod && equalTo((FiatPaymentMethod) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(FiatPaymentMethod other) {
    return currency.equals(other.currency) && billingEmail.equals(other.billingEmail) && paymentInformation.equals(other.paymentInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.currency, this.billingEmail, this.paymentInformation);
  }

  @Override
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

    private Optional<String> billingEmail = Optional.empty();

    private Optional<OneOfFiatPaymentInformation> paymentInformation = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(FiatPaymentMethod other) {
      currency(other.getCurrency());
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

    public FiatPaymentMethod build() {
      return new FiatPaymentMethod(currency, billingEmail, paymentInformation, additionalProperties);
    }
  }
}
