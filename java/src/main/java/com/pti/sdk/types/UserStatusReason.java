/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;

public enum UserStatusReason {
  FRAUD_SUSPICION("FRAUD_SUSPICION"),

  BUSINESS_CO_OWNER("BUSINESS_CO_OWNER"),

  COMPLIANCE_FLAG("COMPLIANCE_FLAG"),

  HIGH_RISK_IP("HIGH_RISK_IP,"),

  INFORMATION_MISMATCH("INFORMATION_MISMATCH,"),

  HIGH_RISK_EMAIL_DOMAIN("HIGH_RISK_EMAIL_DOMAIN,"),

  UNUSUAL_HIGH_VELOCITY("UNUSUAL_HIGH_VELOCITY,"),

  CHARGEBACK("CHARGEBACK");

  private final String value;

  UserStatusReason(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
