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
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = Address.Builder.class
)
public final class Address {
  private final Optional<String> streetAddress;

  private final Optional<String> city;

  private final Optional<String> postalCode;

  private final Optional<StateCode> stateCode;

  private final Optional<CountryCode> country;

  private final Optional<Boolean> default_;

  private final Map<String, Object> additionalProperties;

  private Address(Optional<String> streetAddress, Optional<String> city,
      Optional<String> postalCode, Optional<StateCode> stateCode, Optional<CountryCode> country,
      Optional<Boolean> default_, Map<String, Object> additionalProperties) {
    this.streetAddress = streetAddress;
    this.city = city;
    this.postalCode = postalCode;
    this.stateCode = stateCode;
    this.country = country;
    this.default_ = default_;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("streetAddress")
  public Optional<String> getStreetAddress() {
    return streetAddress;
  }

  @JsonProperty("city")
  public Optional<String> getCity() {
    return city;
  }

  @JsonProperty("postalCode")
  public Optional<String> getPostalCode() {
    return postalCode;
  }

  @JsonProperty("stateCode")
  public Optional<StateCode> getStateCode() {
    return stateCode;
  }

  @JsonProperty("country")
  public Optional<CountryCode> getCountry() {
    return country;
  }

  @JsonProperty("default")
  public Optional<Boolean> getDefault() {
    return default_;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Address && equalTo((Address) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(Address other) {
    return streetAddress.equals(other.streetAddress) && city.equals(other.city) && postalCode.equals(other.postalCode) && stateCode.equals(other.stateCode) && country.equals(other.country) && default_.equals(other.default_);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.streetAddress, this.city, this.postalCode, this.stateCode, this.country, this.default_);
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
    private Optional<String> streetAddress = Optional.empty();

    private Optional<String> city = Optional.empty();

    private Optional<String> postalCode = Optional.empty();

    private Optional<StateCode> stateCode = Optional.empty();

    private Optional<CountryCode> country = Optional.empty();

    private Optional<Boolean> default_ = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(Address other) {
      streetAddress(other.getStreetAddress());
      city(other.getCity());
      postalCode(other.getPostalCode());
      stateCode(other.getStateCode());
      country(other.getCountry());
      default_(other.getDefault());
      return this;
    }

    @JsonSetter(
        value = "streetAddress",
        nulls = Nulls.SKIP
    )
    public Builder streetAddress(Optional<String> streetAddress) {
      this.streetAddress = streetAddress;
      return this;
    }

    public Builder streetAddress(String streetAddress) {
      this.streetAddress = Optional.ofNullable(streetAddress);
      return this;
    }

    @JsonSetter(
        value = "city",
        nulls = Nulls.SKIP
    )
    public Builder city(Optional<String> city) {
      this.city = city;
      return this;
    }

    public Builder city(String city) {
      this.city = Optional.ofNullable(city);
      return this;
    }

    @JsonSetter(
        value = "postalCode",
        nulls = Nulls.SKIP
    )
    public Builder postalCode(Optional<String> postalCode) {
      this.postalCode = postalCode;
      return this;
    }

    public Builder postalCode(String postalCode) {
      this.postalCode = Optional.ofNullable(postalCode);
      return this;
    }

    @JsonSetter(
        value = "stateCode",
        nulls = Nulls.SKIP
    )
    public Builder stateCode(Optional<StateCode> stateCode) {
      this.stateCode = stateCode;
      return this;
    }

    public Builder stateCode(StateCode stateCode) {
      this.stateCode = Optional.ofNullable(stateCode);
      return this;
    }

    @JsonSetter(
        value = "country",
        nulls = Nulls.SKIP
    )
    public Builder country(Optional<CountryCode> country) {
      this.country = country;
      return this;
    }

    public Builder country(CountryCode country) {
      this.country = Optional.ofNullable(country);
      return this;
    }

    @JsonSetter(
        value = "default",
        nulls = Nulls.SKIP
    )
    public Builder default_(Optional<Boolean> default_) {
      this.default_ = default_;
      return this;
    }

    public Builder default_(Boolean default_) {
      this.default_ = Optional.ofNullable(default_);
      return this;
    }

    public Address build() {
      return new Address(streetAddress, city, postalCode, stateCode, country, default_, additionalProperties);
    }
  }
}
