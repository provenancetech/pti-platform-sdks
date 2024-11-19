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
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = UserAssessStatusObject.Builder.class
)
public final class UserAssessStatusObject implements IActionStatus {
  private final Optional<ResourceType> resourceType;

  private final Optional<String> requestId;

  private final Optional<String> clientId;

  private final Optional<String> userId;

  private final Optional<String> date;

  private final Optional<UserAssessStatus> assessment;

  private final Optional<Map<String, Object>> meta;

  private final Optional<Integer> tier;

  private final Optional<KycProviderResponseCode> refusalReason;

  private final Map<String, Object> additionalProperties;

  private UserAssessStatusObject(Optional<ResourceType> resourceType, Optional<String> requestId,
      Optional<String> clientId, Optional<String> userId, Optional<String> date,
      Optional<UserAssessStatus> assessment, Optional<Map<String, Object>> meta,
      Optional<Integer> tier, Optional<KycProviderResponseCode> refusalReason,
      Map<String, Object> additionalProperties) {
    this.resourceType = resourceType;
    this.requestId = requestId;
    this.clientId = clientId;
    this.userId = userId;
    this.date = date;
    this.assessment = assessment;
    this.meta = meta;
    this.tier = tier;
    this.refusalReason = refusalReason;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("resourceType")
  @Override
  public Optional<ResourceType> getResourceType() {
    return resourceType;
  }

  @JsonProperty("requestId")
  @Override
  public Optional<String> getRequestId() {
    return requestId;
  }

  @JsonProperty("clientId")
  @Override
  public Optional<String> getClientId() {
    return clientId;
  }

  @JsonProperty("userId")
  @Override
  public Optional<String> getUserId() {
    return userId;
  }

  /**
   * @return ISO-8601
   */
  @JsonProperty("date")
  @Override
  public Optional<String> getDate() {
    return date;
  }

  @JsonProperty("assessment")
  public Optional<UserAssessStatus> getAssessment() {
    return assessment;
  }

  /**
   * @return key/value map of extra information
   */
  @JsonProperty("meta")
  public Optional<Map<String, Object>> getMeta() {
    return meta;
  }

  @JsonProperty("tier")
  public Optional<Integer> getTier() {
    return tier;
  }

  @JsonProperty("refusalReason")
  public Optional<KycProviderResponseCode> getRefusalReason() {
    return refusalReason;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UserAssessStatusObject && equalTo((UserAssessStatusObject) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(UserAssessStatusObject other) {
    return resourceType.equals(other.resourceType) && requestId.equals(other.requestId) && clientId.equals(other.clientId) && userId.equals(other.userId) && date.equals(other.date) && assessment.equals(other.assessment) && meta.equals(other.meta) && tier.equals(other.tier) && refusalReason.equals(other.refusalReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.resourceType, this.requestId, this.clientId, this.userId, this.date, this.assessment, this.meta, this.tier, this.refusalReason);
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
    private Optional<ResourceType> resourceType = Optional.empty();

    private Optional<String> requestId = Optional.empty();

    private Optional<String> clientId = Optional.empty();

    private Optional<String> userId = Optional.empty();

    private Optional<String> date = Optional.empty();

    private Optional<UserAssessStatus> assessment = Optional.empty();

    private Optional<Map<String, Object>> meta = Optional.empty();

    private Optional<Integer> tier = Optional.empty();

    private Optional<KycProviderResponseCode> refusalReason = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(UserAssessStatusObject other) {
      resourceType(other.getResourceType());
      requestId(other.getRequestId());
      clientId(other.getClientId());
      userId(other.getUserId());
      date(other.getDate());
      assessment(other.getAssessment());
      meta(other.getMeta());
      tier(other.getTier());
      refusalReason(other.getRefusalReason());
      return this;
    }

    @JsonSetter(
        value = "resourceType",
        nulls = Nulls.SKIP
    )
    public Builder resourceType(Optional<ResourceType> resourceType) {
      this.resourceType = resourceType;
      return this;
    }

    public Builder resourceType(ResourceType resourceType) {
      this.resourceType = Optional.ofNullable(resourceType);
      return this;
    }

    @JsonSetter(
        value = "requestId",
        nulls = Nulls.SKIP
    )
    public Builder requestId(Optional<String> requestId) {
      this.requestId = requestId;
      return this;
    }

    public Builder requestId(String requestId) {
      this.requestId = Optional.ofNullable(requestId);
      return this;
    }

    @JsonSetter(
        value = "clientId",
        nulls = Nulls.SKIP
    )
    public Builder clientId(Optional<String> clientId) {
      this.clientId = clientId;
      return this;
    }

    public Builder clientId(String clientId) {
      this.clientId = Optional.ofNullable(clientId);
      return this;
    }

    @JsonSetter(
        value = "userId",
        nulls = Nulls.SKIP
    )
    public Builder userId(Optional<String> userId) {
      this.userId = userId;
      return this;
    }

    public Builder userId(String userId) {
      this.userId = Optional.ofNullable(userId);
      return this;
    }

    @JsonSetter(
        value = "date",
        nulls = Nulls.SKIP
    )
    public Builder date(Optional<String> date) {
      this.date = date;
      return this;
    }

    public Builder date(String date) {
      this.date = Optional.ofNullable(date);
      return this;
    }

    @JsonSetter(
        value = "assessment",
        nulls = Nulls.SKIP
    )
    public Builder assessment(Optional<UserAssessStatus> assessment) {
      this.assessment = assessment;
      return this;
    }

    public Builder assessment(UserAssessStatus assessment) {
      this.assessment = Optional.ofNullable(assessment);
      return this;
    }

    @JsonSetter(
        value = "meta",
        nulls = Nulls.SKIP
    )
    public Builder meta(Optional<Map<String, Object>> meta) {
      this.meta = meta;
      return this;
    }

    public Builder meta(Map<String, Object> meta) {
      this.meta = Optional.ofNullable(meta);
      return this;
    }

    @JsonSetter(
        value = "tier",
        nulls = Nulls.SKIP
    )
    public Builder tier(Optional<Integer> tier) {
      this.tier = tier;
      return this;
    }

    public Builder tier(Integer tier) {
      this.tier = Optional.ofNullable(tier);
      return this;
    }

    @JsonSetter(
        value = "refusalReason",
        nulls = Nulls.SKIP
    )
    public Builder refusalReason(Optional<KycProviderResponseCode> refusalReason) {
      this.refusalReason = refusalReason;
      return this;
    }

    public Builder refusalReason(KycProviderResponseCode refusalReason) {
      this.refusalReason = Optional.ofNullable(refusalReason);
      return this;
    }

    public UserAssessStatusObject build() {
      return new UserAssessStatusObject(resourceType, requestId, clientId, userId, date, assessment, meta, tier, refusalReason, additionalProperties);
    }
  }
}
