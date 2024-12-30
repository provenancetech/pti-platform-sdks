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
    builder = DigitalItem.Builder.class
)
public final class DigitalItem {
  private final String itemReference;

  private final String itemTitle;

  private final String itemDescription;

  private final Optional<Double> itemUsdValue;

  private final DigitalItemType digitalItemType;

  private final Map<String, Object> additionalProperties;

  private DigitalItem(String itemReference, String itemTitle, String itemDescription,
      Optional<Double> itemUsdValue, DigitalItemType digitalItemType,
      Map<String, Object> additionalProperties) {
    this.itemReference = itemReference;
    this.itemTitle = itemTitle;
    this.itemDescription = itemDescription;
    this.itemUsdValue = itemUsdValue;
    this.digitalItemType = digitalItemType;
    this.additionalProperties = additionalProperties;
  }

  /**
   * @return Reference information about the item, for example could be the contract address of an NFT item.
   */
  @JsonProperty("itemReference")
  public String getItemReference() {
    return itemReference;
  }

  /**
   * @return The name of the item, for example: ShaggyDog#2
   */
  @JsonProperty("itemTitle")
  public String getItemTitle() {
    return itemTitle;
  }

  /**
   * @return Description about the item, for example: Shaggy Dog Collection is an NFT for Dog lovers. It is a manually generated NFT created on the Ethereum network.
   */
  @JsonProperty("itemDescription")
  public String getItemDescription() {
    return itemDescription;
  }

  /**
   * @return Mandatory when more than one item is provided in the payload. The cost of the item being paid by the User, or the estimated value of the item in question.
   */
  @JsonProperty("itemUSDValue")
  public Optional<Double> getItemUsdValue() {
    return itemUsdValue;
  }

  @JsonProperty("digitalItemType")
  public DigitalItemType getDigitalItemType() {
    return digitalItemType;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof DigitalItem && equalTo((DigitalItem) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(DigitalItem other) {
    return itemReference.equals(other.itemReference) && itemTitle.equals(other.itemTitle) && itemDescription.equals(other.itemDescription) && itemUsdValue.equals(other.itemUsdValue) && digitalItemType.equals(other.digitalItemType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.itemReference, this.itemTitle, this.itemDescription, this.itemUsdValue, this.digitalItemType);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static ItemReferenceStage builder() {
    return new Builder();
  }

  public interface ItemReferenceStage {
    ItemTitleStage itemReference(@NotNull String itemReference);

    Builder from(DigitalItem other);
  }

  public interface ItemTitleStage {
    ItemDescriptionStage itemTitle(@NotNull String itemTitle);
  }

  public interface ItemDescriptionStage {
    DigitalItemTypeStage itemDescription(@NotNull String itemDescription);
  }

  public interface DigitalItemTypeStage {
    _FinalStage digitalItemType(@NotNull DigitalItemType digitalItemType);
  }

  public interface _FinalStage {
    DigitalItem build();

    _FinalStage itemUsdValue(Optional<Double> itemUsdValue);

    _FinalStage itemUsdValue(Double itemUsdValue);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ItemReferenceStage, ItemTitleStage, ItemDescriptionStage, DigitalItemTypeStage, _FinalStage {
    private String itemReference;

    private String itemTitle;

    private String itemDescription;

    private DigitalItemType digitalItemType;

    private Optional<Double> itemUsdValue = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(DigitalItem other) {
      itemReference(other.getItemReference());
      itemTitle(other.getItemTitle());
      itemDescription(other.getItemDescription());
      itemUsdValue(other.getItemUsdValue());
      digitalItemType(other.getDigitalItemType());
      return this;
    }

    /**
     * <p>Reference information about the item, for example could be the contract address of an NFT item.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("itemReference")
    public ItemTitleStage itemReference(@NotNull String itemReference) {
      this.itemReference = Objects.requireNonNull(itemReference, "itemReference must not be null");
      return this;
    }

    /**
     * <p>The name of the item, for example: ShaggyDog#2</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("itemTitle")
    public ItemDescriptionStage itemTitle(@NotNull String itemTitle) {
      this.itemTitle = Objects.requireNonNull(itemTitle, "itemTitle must not be null");
      return this;
    }

    /**
     * <p>Description about the item, for example: Shaggy Dog Collection is an NFT for Dog lovers. It is a manually generated NFT created on the Ethereum network.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("itemDescription")
    public DigitalItemTypeStage itemDescription(@NotNull String itemDescription) {
      this.itemDescription = Objects.requireNonNull(itemDescription, "itemDescription must not be null");
      return this;
    }

    @Override
    @JsonSetter("digitalItemType")
    public _FinalStage digitalItemType(@NotNull DigitalItemType digitalItemType) {
      this.digitalItemType = Objects.requireNonNull(digitalItemType, "digitalItemType must not be null");
      return this;
    }

    /**
     * <p>Mandatory when more than one item is provided in the payload. The cost of the item being paid by the User, or the estimated value of the item in question.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage itemUsdValue(Double itemUsdValue) {
      this.itemUsdValue = Optional.ofNullable(itemUsdValue);
      return this;
    }

    @Override
    @JsonSetter(
        value = "itemUSDValue",
        nulls = Nulls.SKIP
    )
    public _FinalStage itemUsdValue(Optional<Double> itemUsdValue) {
      this.itemUsdValue = itemUsdValue;
      return this;
    }

    @Override
    public DigitalItem build() {
      return new DigitalItem(itemReference, itemTitle, itemDescription, itemUsdValue, digitalItemType, additionalProperties);
    }
  }
}
