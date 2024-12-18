/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;

public enum WalletHistoryOperationTarget {
  BALANCE("BALANCE"),

  IN_FLIGHT_BALANCE("IN_FLIGHT_BALANCE");

  private final String value;

  WalletHistoryOperationTarget(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}