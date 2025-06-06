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
    builder = CryptoPaymentMethod.Builder.class
)
public final class CryptoPaymentMethod {
  private final Optional<String> billingEmail;

  private final Optional<CryptoPaymentInformation> paymentInformation;

  private final Map<String, Object> additionalProperties;

  private CryptoPaymentMethod(Optional<String> billingEmail,
      Optional<CryptoPaymentInformation> paymentInformation,
      Map<String, Object> additionalProperties) {
    this.billingEmail = billingEmail;
    this.paymentInformation = paymentInformation;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("billingEmail")
  public Optional<String> getBillingEmail() {
    return billingEmail;
  }

  @JsonProperty("paymentInformation")
  public Optional<CryptoPaymentInformation> getPaymentInformation() {
    return paymentInformation;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CryptoPaymentMethod && equalTo((CryptoPaymentMethod) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(CryptoPaymentMethod other) {
    return billingEmail.equals(other.billingEmail) && paymentInformation.equals(other.paymentInformation);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.billingEmail, this.paymentInformation);
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
    private Optional<String> billingEmail = Optional.empty();

    private Optional<CryptoPaymentInformation> paymentInformation = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(CryptoPaymentMethod other) {
      billingEmail(other.getBillingEmail());
      paymentInformation(other.getPaymentInformation());
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
    public Builder paymentInformation(Optional<CryptoPaymentInformation> paymentInformation) {
      this.paymentInformation = paymentInformation;
      return this;
    }

    public Builder paymentInformation(CryptoPaymentInformation paymentInformation) {
      this.paymentInformation = Optional.ofNullable(paymentInformation);
      return this;
    }

    public CryptoPaymentMethod build() {
      return new CryptoPaymentMethod(billingEmail, paymentInformation, additionalProperties);
    }
  }
}
