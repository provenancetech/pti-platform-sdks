/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.pti.sdk.core.ObjectMappers;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    using = OneOfAssessmentValidationError.Deserializer.class
)
public final class OneOfAssessmentValidationError {
  private final Object value;

  private final int type;

  private OneOfAssessmentValidationError(Object value, int type) {
    this.value = value;
    this.type = type;
  }

  @JsonValue
  public Object get() {
    return this.value;
  }

  public <T> T visit(Visitor<T> visitor) {
    if(this.type == 0) {
      return visitor.visit((MissingInformationError) this.value);
    } else if(this.type == 1) {
      return visitor.visit((InvalidUserAssessmentError) this.value);
    } else if(this.type == 2) {
      return visitor.visit((NoAssessmentError) this.value);
    }
    throw new IllegalStateException("Failed to visit value. This should never happen.");
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof OneOfAssessmentValidationError && equalTo((OneOfAssessmentValidationError) other);
  }

  private boolean equalTo(OneOfAssessmentValidationError other) {
    return value.equals(other.value);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.value);
  }

  @java.lang.Override
  public String toString() {
    return this.value.toString();
  }

  public static OneOfAssessmentValidationError of(MissingInformationError value) {
    return new OneOfAssessmentValidationError(value, 0);
  }

  public static OneOfAssessmentValidationError of(InvalidUserAssessmentError value) {
    return new OneOfAssessmentValidationError(value, 1);
  }

  public static OneOfAssessmentValidationError of(NoAssessmentError value) {
    return new OneOfAssessmentValidationError(value, 2);
  }

  public interface Visitor<T> {
    T visit(MissingInformationError value);

    T visit(InvalidUserAssessmentError value);

    T visit(NoAssessmentError value);
  }

  static final class Deserializer extends StdDeserializer<OneOfAssessmentValidationError> {
    Deserializer() {
      super(OneOfAssessmentValidationError.class);
    }

    @java.lang.Override
    public OneOfAssessmentValidationError deserialize(JsonParser p, DeserializationContext context)
        throws IOException {
      Object value = p.readValueAs(Object.class);
      try {
        return of(ObjectMappers.JSON_MAPPER.convertValue(value, MissingInformationError.class));
      } catch(IllegalArgumentException e) {
      }
      try {
        return of(ObjectMappers.JSON_MAPPER.convertValue(value, InvalidUserAssessmentError.class));
      } catch(IllegalArgumentException e) {
      }
      try {
        return of(ObjectMappers.JSON_MAPPER.convertValue(value, NoAssessmentError.class));
      } catch(IllegalArgumentException e) {
      }
      throw new JsonParseException(p, "Failed to deserialize");
    }
  }
}
