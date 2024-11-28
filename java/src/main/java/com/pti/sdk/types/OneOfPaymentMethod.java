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

public final class OneOfPaymentMethod {
  private final Value value;

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  private OneOfPaymentMethod(Value value) {
    this.value = value;
  }

  public <T> T visit(Visitor<T> visitor) {
    return value.visit(visitor);
  }

  public static OneOfPaymentMethod ach(FiatPaymentMethod value) {
    return new OneOfPaymentMethod(new AchValue(value));
  }

  public static OneOfPaymentMethod creditCard(CreditCardPaymentMethod value) {
    return new OneOfPaymentMethod(new CreditCardValue(value));
  }

  public static OneOfPaymentMethod wire(WirePaymentMethod value) {
    return new OneOfPaymentMethod(new WireValue(value));
  }

  public static OneOfPaymentMethod wallet(WalletPaymentMethod value) {
    return new OneOfPaymentMethod(new WalletValue(value));
  }

  public static OneOfPaymentMethod crypto(CryptoPaymentMethod value) {
    return new OneOfPaymentMethod(new CryptoValue(value));
  }

  public boolean isAch() {
    return value instanceof AchValue;
  }

  public boolean isCreditCard() {
    return value instanceof CreditCardValue;
  }

  public boolean isWire() {
    return value instanceof WireValue;
  }

  public boolean isWallet() {
    return value instanceof WalletValue;
  }

  public boolean isCrypto() {
    return value instanceof CryptoValue;
  }

  public boolean _isUnknown() {
    return value instanceof _UnknownValue;
  }

  public Optional<FiatPaymentMethod> getAch() {
    if (isAch()) {
      return Optional.of(((AchValue) value).value);
    }
    return Optional.empty();
  }

  public Optional<CreditCardPaymentMethod> getCreditCard() {
    if (isCreditCard()) {
      return Optional.of(((CreditCardValue) value).value);
    }
    return Optional.empty();
  }

  public Optional<WirePaymentMethod> getWire() {
    if (isWire()) {
      return Optional.of(((WireValue) value).value);
    }
    return Optional.empty();
  }

  public Optional<WalletPaymentMethod> getWallet() {
    if (isWallet()) {
      return Optional.of(((WalletValue) value).value);
    }
    return Optional.empty();
  }

  public Optional<CryptoPaymentMethod> getCrypto() {
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
    T visitAch(FiatPaymentMethod ach);

    T visitCreditCard(CreditCardPaymentMethod creditCard);

    T visitWire(WirePaymentMethod wire);

    T visitWallet(WalletPaymentMethod wallet);

    T visitCrypto(CryptoPaymentMethod crypto);

    T _visitUnknown(Object unknownType);
  }

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      property = "paymentMethodType",
      visible = true,
      defaultImpl = _UnknownValue.class
  )
  @JsonSubTypes({
      @JsonSubTypes.Type(AchValue.class),
      @JsonSubTypes.Type(CreditCardValue.class),
      @JsonSubTypes.Type(WireValue.class),
      @JsonSubTypes.Type(WalletValue.class),
      @JsonSubTypes.Type(CryptoValue.class)
  })
  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  private interface Value {
    <T> T visit(Visitor<T> visitor);
  }

  @JsonTypeName("ACH")
  private static final class AchValue implements Value {
    @JsonUnwrapped
    private FiatPaymentMethod value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private AchValue() {
    }

    private AchValue(FiatPaymentMethod value) {
      this.value = value;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitAch(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof AchValue && equalTo((AchValue) other);
    }

    private boolean equalTo(AchValue other) {
      return value.equals(other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.value);
    }

    @Override
    public String toString() {
      return "OneOfPaymentMethod{" + "value: " + value + "}";
    }
  }

  @JsonTypeName("CREDIT_CARD")
  private static final class CreditCardValue implements Value {
    @JsonUnwrapped
    private CreditCardPaymentMethod value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private CreditCardValue() {
    }

    private CreditCardValue(CreditCardPaymentMethod value) {
      this.value = value;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitCreditCard(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof CreditCardValue && equalTo((CreditCardValue) other);
    }

    private boolean equalTo(CreditCardValue other) {
      return value.equals(other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.value);
    }

    @Override
    public String toString() {
      return "OneOfPaymentMethod{" + "value: " + value + "}";
    }
  }

  @JsonTypeName("WIRE")
  private static final class WireValue implements Value {
    @JsonUnwrapped
    private WirePaymentMethod value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private WireValue() {
    }

    private WireValue(WirePaymentMethod value) {
      this.value = value;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitWire(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof WireValue && equalTo((WireValue) other);
    }

    private boolean equalTo(WireValue other) {
      return value.equals(other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.value);
    }

    @Override
    public String toString() {
      return "OneOfPaymentMethod{" + "value: " + value + "}";
    }
  }

  @JsonTypeName("WALLET")
  private static final class WalletValue implements Value {
    @JsonUnwrapped
    private WalletPaymentMethod value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private WalletValue() {
    }

    private WalletValue(WalletPaymentMethod value) {
      this.value = value;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitWallet(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof WalletValue && equalTo((WalletValue) other);
    }

    private boolean equalTo(WalletValue other) {
      return value.equals(other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.value);
    }

    @Override
    public String toString() {
      return "OneOfPaymentMethod{" + "value: " + value + "}";
    }
  }

  @JsonTypeName("CRYPTO")
  private static final class CryptoValue implements Value {
    @JsonUnwrapped
    private CryptoPaymentMethod value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private CryptoValue() {
    }

    private CryptoValue(CryptoPaymentMethod value) {
      this.value = value;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitCrypto(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof CryptoValue && equalTo((CryptoValue) other);
    }

    private boolean equalTo(CryptoValue other) {
      return value.equals(other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.value);
    }

    @Override
    public String toString() {
      return "OneOfPaymentMethod{" + "value: " + value + "}";
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

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor._visitUnknown(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
    }

    private boolean equalTo(_UnknownValue other) {
      return type.equals(other.type) && value.equals(other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.type, this.value);
    }

    @Override
    public String toString() {
      return "OneOfPaymentMethod{" + "type: " + type + ", value: " + value + "}";
    }
  }
}
