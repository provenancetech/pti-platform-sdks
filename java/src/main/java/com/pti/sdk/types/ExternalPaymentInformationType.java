/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;

public enum ExternalPaymentInformationType {
  BANK_ACCOUNT("BANK_ACCOUNT"),

  ENCRYPTED_CREDIT_CARD("ENCRYPTED_CREDIT_CARD"),

  CRYPTO("CRYPTO");

  private final String value;

  ExternalPaymentInformationType(String value) {
    this.value = value;
  }

  @JsonValue
  @java.lang.Override
  public String toString() {
    return this.value;
  }
}
