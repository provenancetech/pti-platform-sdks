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
    builder = ObjectReference.Builder.class
)
public final class ObjectReference {
  private final String id;

  private final String link;

  private final Map<String, Object> additionalProperties;

  private ObjectReference(String id, String link, Map<String, Object> additionalProperties) {
    this.id = id;
    this.link = link;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("link")
  public String getLink() {
    return link;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ObjectReference && equalTo((ObjectReference) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(ObjectReference other) {
    return id.equals(other.id) && link.equals(other.link);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.link);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    LinkStage id(@NotNull String id);

    Builder from(ObjectReference other);
  }

  public interface LinkStage {
    _FinalStage link(@NotNull String link);
  }

  public interface _FinalStage {
    ObjectReference build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdStage, LinkStage, _FinalStage {
    private String id;

    private String link;

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(ObjectReference other) {
      id(other.getId());
      link(other.getLink());
      return this;
    }

    @Override
    @JsonSetter("id")
    public LinkStage id(@NotNull String id) {
      this.id = Objects.requireNonNull(id, "id must not be null");
      return this;
    }

    @Override
    @JsonSetter("link")
    public _FinalStage link(@NotNull String link) {
      this.link = Objects.requireNonNull(link, "link must not be null");
      return this;
    }

    @Override
    public ObjectReference build() {
      return new ObjectReference(id, link, additionalProperties);
    }
  }
}
