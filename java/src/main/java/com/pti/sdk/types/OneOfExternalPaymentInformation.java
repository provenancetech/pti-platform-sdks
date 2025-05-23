/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.pti.sdk.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class OneOfExternalPaymentInformation {
  private final Value value;

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  private OneOfExternalPaymentInformation(Value value) {
    this.value = value;
  }

  public <T> T visit(Visitor<T> visitor) {
    return value.visit(visitor);
  }

  public static OneOfExternalPaymentInformation bankAccount(BankAccountPaymentInformation value) {
    return new OneOfExternalPaymentInformation(new BankAccountValue(value));
  }

  public static OneOfExternalPaymentInformation encryptedCreditCard(
      EncryptedCreditCardPaymentInformation value) {
    return new OneOfExternalPaymentInformation(new EncryptedCreditCardValue(value));
  }

  public static OneOfExternalPaymentInformation crypto(CryptoPaymentInformation value) {
    return new OneOfExternalPaymentInformation(new CryptoValue(value));
  }

  public boolean isBankAccount() {
    return value instanceof BankAccountValue;
  }

  public boolean isEncryptedCreditCard() {
    return value instanceof EncryptedCreditCardValue;
  }

  public boolean isCrypto() {
    return value instanceof CryptoValue;
  }

  public boolean _isUnknown() {
    return value instanceof _UnknownValue;
  }

  public Optional<BankAccountPaymentInformation> getBankAccount() {
    if (isBankAccount()) {
      return Optional.of(((BankAccountValue) value).value);
    }
    return Optional.empty();
  }

  public Optional<EncryptedCreditCardPaymentInformation> getEncryptedCreditCard() {
    if (isEncryptedCreditCard()) {
      return Optional.of(((EncryptedCreditCardValue) value).value);
    }
    return Optional.empty();
  }

  public Optional<CryptoPaymentInformation> getCrypto() {
    if (isCrypto()) {
      return Optional.of(((CryptoValue) value).value);
    }
    return Optional.empty();
  }

  public Optional<Object> _getUnknown() {
    if (_isUnknown()) {
      return Optional.of(((_UnknownValue) value).value);
    }
    return Optional.empty();
  }

  @JsonValue
  private Value getValue() {
    return this.value;
  }

  public interface Visitor<T> {
    T visitBankAccount(BankAccountPaymentInformation bankAccount);

    T visitEncryptedCreditCard(EncryptedCreditCardPaymentInformation encryptedCreditCard);

    T visitCrypto(CryptoPaymentInformation crypto);

    T _visitUnknown(Object unknownType);
  }

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      property = "type",
      visible = true,
      defaultImpl = _UnknownValue.class
  )
  @JsonSubTypes({
      @JsonSubTypes.Type(BankAccountValue.class),
      @JsonSubTypes.Type(EncryptedCreditCardValue.class),
      @JsonSubTypes.Type(CryptoValue.class)
  })
  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  private interface Value {
    <T> T visit(Visitor<T> visitor);
  }

  @JsonTypeName("BANK_ACCOUNT")
  private static final class BankAccountValue implements Value {
    @JsonUnwrapped
    private BankAccountPaymentInformation value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private BankAccountValue() {
    }

    private BankAccountValue(BankAccountPaymentInformation value) {
      this.value = value;
    }

    @java.lang.Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitBankAccount(value);
    }

    @java.lang.Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof BankAccountValue && equalTo((BankAccountValue) other);
    }

    private boolean equalTo(BankAccountValue other) {
      return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
      return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
      return "OneOfExternalPaymentInformation{" + "value: " + value + "}";
    }
  }

  @JsonTypeName("ENCRYPTED_CREDIT_CARD")
  private static final class EncryptedCreditCardValue implements Value {
    @JsonUnwrapped
    private EncryptedCreditCardPaymentInformation value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private EncryptedCreditCardValue() {
    }

    private EncryptedCreditCardValue(EncryptedCreditCardPaymentInformation value) {
      this.value = value;
    }

    @java.lang.Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitEncryptedCreditCard(value);
    }

    @java.lang.Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof EncryptedCreditCardValue && equalTo((EncryptedCreditCardValue) other);
    }

    private boolean equalTo(EncryptedCreditCardValue other) {
      return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
      return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
      return "OneOfExternalPaymentInformation{" + "value: " + value + "}";
    }
  }

  @JsonTypeName("CRYPTO")
  private static final class CryptoValue implements Value {
    @JsonUnwrapped
    private CryptoPaymentInformation value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private CryptoValue() {
    }

    private CryptoValue(CryptoPaymentInformation value) {
      this.value = value;
    }

    @java.lang.Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitCrypto(value);
    }

    @java.lang.Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof CryptoValue && equalTo((CryptoValue) other);
    }

    private boolean equalTo(CryptoValue other) {
      return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
      return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
      return "OneOfExternalPaymentInformation{" + "value: " + value + "}";
    }
  }

  private static final class _UnknownValue implements Value {
    private String type;

    @JsonValue
    private Object value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private _UnknownValue(@JsonProperty("value") Object value) {
    }

    @java.lang.Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor._visitUnknown(value);
    }

    @java.lang.Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
    }

    private boolean equalTo(_UnknownValue other) {
      return type.equals(other.type) && value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
      return Objects.hash(this.type, this.value);
    }

    @java.lang.Override
    public String toString() {
      return "OneOfExternalPaymentInformation{" + "type: " + type + ", value: " + value + "}";
    }
  }
}
