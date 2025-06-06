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
import java.lang.Double;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = WalletHistory.Builder.class
)
public final class WalletHistory {
  private final String walletId;

  private final Optional<Double> pendingBalanceBefore;

  private final Optional<Double> totalBalanceBefore;

  private final Optional<Double> lockedBalanceBefore;

  private final Optional<String> createDateTime;

  private final Optional<Double> change;

  private final Optional<WalletHistoryOperationTarget> operationTarget;

  private final Optional<String> requestId;

  private final Map<String, Object> additionalProperties;

  private WalletHistory(String walletId, Optional<Double> pendingBalanceBefore,
      Optional<Double> totalBalanceBefore, Optional<Double> lockedBalanceBefore,
      Optional<String> createDateTime, Optional<Double> change,
      Optional<WalletHistoryOperationTarget> operationTarget, Optional<String> requestId,
      Map<String, Object> additionalProperties) {
    this.walletId = walletId;
    this.pendingBalanceBefore = pendingBalanceBefore;
    this.totalBalanceBefore = totalBalanceBefore;
    this.lockedBalanceBefore = lockedBalanceBefore;
    this.createDateTime = createDateTime;
    this.change = change;
    this.operationTarget = operationTarget;
    this.requestId = requestId;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("walletId")
  public String getWalletId() {
    return walletId;
  }

  @JsonProperty("pendingBalanceBefore")
  public Optional<Double> getPendingBalanceBefore() {
    return pendingBalanceBefore;
  }

  @JsonProperty("totalBalanceBefore")
  public Optional<Double> getTotalBalanceBefore() {
    return totalBalanceBefore;
  }

  @JsonProperty("lockedBalanceBefore")
  public Optional<Double> getLockedBalanceBefore() {
    return lockedBalanceBefore;
  }

  @JsonProperty("createDateTime")
  public Optional<String> getCreateDateTime() {
    return createDateTime;
  }

  @JsonProperty("change")
  public Optional<Double> getChange() {
    return change;
  }

  @JsonProperty("operationTarget")
  public Optional<WalletHistoryOperationTarget> getOperationTarget() {
    return operationTarget;
  }

  @JsonProperty("requestId")
  public Optional<String> getRequestId() {
    return requestId;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof WalletHistory && equalTo((WalletHistory) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(WalletHistory other) {
    return walletId.equals(other.walletId) && pendingBalanceBefore.equals(other.pendingBalanceBefore) && totalBalanceBefore.equals(other.totalBalanceBefore) && lockedBalanceBefore.equals(other.lockedBalanceBefore) && createDateTime.equals(other.createDateTime) && change.equals(other.change) && operationTarget.equals(other.operationTarget) && requestId.equals(other.requestId);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.walletId, this.pendingBalanceBefore, this.totalBalanceBefore, this.lockedBalanceBefore, this.createDateTime, this.change, this.operationTarget, this.requestId);
  }

  @java.lang.Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static WalletIdStage builder() {
    return new Builder();
  }

  public interface WalletIdStage {
    _FinalStage walletId(@NotNull String walletId);

    Builder from(WalletHistory other);
  }

  public interface _FinalStage {
    WalletHistory build();

    _FinalStage pendingBalanceBefore(Optional<Double> pendingBalanceBefore);

    _FinalStage pendingBalanceBefore(Double pendingBalanceBefore);

    _FinalStage totalBalanceBefore(Optional<Double> totalBalanceBefore);

    _FinalStage totalBalanceBefore(Double totalBalanceBefore);

    _FinalStage lockedBalanceBefore(Optional<Double> lockedBalanceBefore);

    _FinalStage lockedBalanceBefore(Double lockedBalanceBefore);

    _FinalStage createDateTime(Optional<String> createDateTime);

    _FinalStage createDateTime(String createDateTime);

    _FinalStage change(Optional<Double> change);

    _FinalStage change(Double change);

    _FinalStage operationTarget(Optional<WalletHistoryOperationTarget> operationTarget);

    _FinalStage operationTarget(WalletHistoryOperationTarget operationTarget);

    _FinalStage requestId(Optional<String> requestId);

    _FinalStage requestId(String requestId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WalletIdStage, _FinalStage {
    private String walletId;

    private Optional<String> requestId = Optional.empty();

    private Optional<WalletHistoryOperationTarget> operationTarget = Optional.empty();

    private Optional<Double> change = Optional.empty();

    private Optional<String> createDateTime = Optional.empty();

    private Optional<Double> lockedBalanceBefore = Optional.empty();

    private Optional<Double> totalBalanceBefore = Optional.empty();

    private Optional<Double> pendingBalanceBefore = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @java.lang.Override
    public Builder from(WalletHistory other) {
      walletId(other.getWalletId());
      pendingBalanceBefore(other.getPendingBalanceBefore());
      totalBalanceBefore(other.getTotalBalanceBefore());
      lockedBalanceBefore(other.getLockedBalanceBefore());
      createDateTime(other.getCreateDateTime());
      change(other.getChange());
      operationTarget(other.getOperationTarget());
      requestId(other.getRequestId());
      return this;
    }

    @java.lang.Override
    @JsonSetter("walletId")
    public _FinalStage walletId(@NotNull String walletId) {
      this.walletId = Objects.requireNonNull(walletId, "walletId must not be null");
      return this;
    }

    @java.lang.Override
    public _FinalStage requestId(String requestId) {
      this.requestId = Optional.ofNullable(requestId);
      return this;
    }

    @java.lang.Override
    @JsonSetter(
        value = "requestId",
        nulls = Nulls.SKIP
    )
    public _FinalStage requestId(Optional<String> requestId) {
      this.requestId = requestId;
      return this;
    }

    @java.lang.Override
    public _FinalStage operationTarget(WalletHistoryOperationTarget operationTarget) {
      this.operationTarget = Optional.ofNullable(operationTarget);
      return this;
    }

    @java.lang.Override
    @JsonSetter(
        value = "operationTarget",
        nulls = Nulls.SKIP
    )
    public _FinalStage operationTarget(Optional<WalletHistoryOperationTarget> operationTarget) {
      this.operationTarget = operationTarget;
      return this;
    }

    @java.lang.Override
    public _FinalStage change(Double change) {
      this.change = Optional.ofNullable(change);
      return this;
    }

    @java.lang.Override
    @JsonSetter(
        value = "change",
        nulls = Nulls.SKIP
    )
    public _FinalStage change(Optional<Double> change) {
      this.change = change;
      return this;
    }

    @java.lang.Override
    public _FinalStage createDateTime(String createDateTime) {
      this.createDateTime = Optional.ofNullable(createDateTime);
      return this;
    }

    @java.lang.Override
    @JsonSetter(
        value = "createDateTime",
        nulls = Nulls.SKIP
    )
    public _FinalStage createDateTime(Optional<String> createDateTime) {
      this.createDateTime = createDateTime;
      return this;
    }

    @java.lang.Override
    public _FinalStage lockedBalanceBefore(Double lockedBalanceBefore) {
      this.lockedBalanceBefore = Optional.ofNullable(lockedBalanceBefore);
      return this;
    }

    @java.lang.Override
    @JsonSetter(
        value = "lockedBalanceBefore",
        nulls = Nulls.SKIP
    )
    public _FinalStage lockedBalanceBefore(Optional<Double> lockedBalanceBefore) {
      this.lockedBalanceBefore = lockedBalanceBefore;
      return this;
    }

    @java.lang.Override
    public _FinalStage totalBalanceBefore(Double totalBalanceBefore) {
      this.totalBalanceBefore = Optional.ofNullable(totalBalanceBefore);
      return this;
    }

    @java.lang.Override
    @JsonSetter(
        value = "totalBalanceBefore",
        nulls = Nulls.SKIP
    )
    public _FinalStage totalBalanceBefore(Optional<Double> totalBalanceBefore) {
      this.totalBalanceBefore = totalBalanceBefore;
      return this;
    }

    @java.lang.Override
    public _FinalStage pendingBalanceBefore(Double pendingBalanceBefore) {
      this.pendingBalanceBefore = Optional.ofNullable(pendingBalanceBefore);
      return this;
    }

    @java.lang.Override
    @JsonSetter(
        value = "pendingBalanceBefore",
        nulls = Nulls.SKIP
    )
    public _FinalStage pendingBalanceBefore(Optional<Double> pendingBalanceBefore) {
      this.pendingBalanceBefore = pendingBalanceBefore;
      return this;
    }

    @java.lang.Override
    public WalletHistory build() {
      return new WalletHistory(walletId, pendingBalanceBefore, totalBalanceBefore, lockedBalanceBefore, createDateTime, change, operationTarget, requestId, additionalProperties);
    }
  }
}
