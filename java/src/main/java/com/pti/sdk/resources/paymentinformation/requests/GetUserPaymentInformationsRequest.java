/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.resources.paymentinformation.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pti.sdk.core.ObjectMappers;
import com.pti.sdk.types.ExternalPaymentInformationType;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = GetUserPaymentInformationsRequest.Builder.class
)
public final class GetUserPaymentInformationsRequest {
  private final Optional<ExternalPaymentInformationType> type;

  private final Map<String, Object> additionalProperties;

  private GetUserPaymentInformationsRequest(Optional<ExternalPaymentInformationType> type,
      Map<String, Object> additionalProperties) {
    this.type = type;
    this.additionalProperties = additionalProperties;
  }

  /**
   * @return Type of external Payment Information. If not specified, the default value is ENCRYPTED_CREDIT_CARD. This is used to filter the external Payment Information by type.
   */
  @JsonProperty("type")
  public Optional<ExternalPaymentInformationType> getType() {
    return type;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetUserPaymentInformationsRequest && equalTo((GetUserPaymentInformationsRequest) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(GetUserPaymentInformationsRequest other) {
    return type.equals(other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.type);
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
    private Optional<ExternalPaymentInformationType> type = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(GetUserPaymentInformationsRequest other) {
      type(other.getType());
      return this;
    }

    @JsonSetter(
        value = "type",
        nulls = Nulls.SKIP
    )
    public Builder type(Optional<ExternalPaymentInformationType> type) {
      this.type = type;
      return this;
    }

    public Builder type(ExternalPaymentInformationType type) {
      this.type = Optional.ofNullable(type);
      return this;
    }

    public GetUserPaymentInformationsRequest build() {
      return new GetUserPaymentInformationsRequest(type, additionalProperties);
    }
  }
}