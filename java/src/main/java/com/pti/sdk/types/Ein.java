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
    builder = Ein.Builder.class
)
public final class Ein {
  private final Optional<String> value;

  private final Map<String, Object> additionalProperties;

  private Ein(Optional<String> value, Map<String, Object> additionalProperties) {
    this.value = value;
    this.additionalProperties = additionalProperties;
  }

  /**
   * @return Ein number, properly formatted, example 12-3456789
   */
  @JsonProperty("value")
  public Optional<String> getValue() {
    return value;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Ein && equalTo((Ein) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(Ein other) {
    return value.equals(other.value);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.value);
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
    private Optional<String> value = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(Ein other) {
      value(other.getValue());
      return this;
    }

    @JsonSetter(
        value = "value",
        nulls = Nulls.SKIP
    )
    public Builder value(Optional<String> value) {
      this.value = value;
      return this;
    }

    public Builder value(String value) {
      this.value = Optional.ofNullable(value);
      return this;
    }

    public Ein build() {
      return new Ein(value, additionalProperties);
    }
  }
}
