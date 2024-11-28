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
    builder = Itin.Builder.class
)
public final class Itin implements IPii {
  private final PiiType type;

  private final Optional<String> value;

  private final Map<String, Object> additionalProperties;

  private Itin(PiiType type, Optional<String> value, Map<String, Object> additionalProperties) {
    this.type = type;
    this.value = value;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("type")
  @Override
  public PiiType getType() {
    return type;
  }

  /**
   * @return itin number, properly formatted, example 911-83-1111
   */
  @JsonProperty("value")
  public Optional<String> getValue() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Itin && equalTo((Itin) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(Itin other) {
    return type.equals(other.type) && value.equals(other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.type, this.value);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static TypeStage builder() {
    return new Builder();
  }

  public interface TypeStage {
    _FinalStage type(@NotNull PiiType type);

    Builder from(Itin other);
  }

  public interface _FinalStage {
    Itin build();

    _FinalStage value(Optional<String> value);

    _FinalStage value(String value);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TypeStage, _FinalStage {
    private PiiType type;

    private Optional<String> value = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(Itin other) {
      type(other.getType());
      value(other.getValue());
      return this;
    }

    @Override
    @JsonSetter("type")
    public _FinalStage type(@NotNull PiiType type) {
      this.type = Objects.requireNonNull(type, "type must not be null");
      return this;
    }

    /**
     * <p>itin number, properly formatted, example 911-83-1111</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage value(String value) {
      this.value = Optional.ofNullable(value);
      return this;
    }

    @Override
    @JsonSetter(
        value = "value",
        nulls = Nulls.SKIP
    )
    public _FinalStage value(Optional<String> value) {
      this.value = value;
      return this;
    }

    @Override
    public Itin build() {
      return new Itin(type, value, additionalProperties);
    }
  }
}
