/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;

public enum DigitalItemType {
  NFT("NFT"),

  OTHER("OTHER");

  private final String value;

  DigitalItemType(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
