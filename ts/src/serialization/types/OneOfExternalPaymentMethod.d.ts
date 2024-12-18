/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { AchPaymentMethod } from "./AchPaymentMethod";
import { CreditCardPaymentMethod } from "./CreditCardPaymentMethod";
import { WirePaymentMethod } from "./WirePaymentMethod";
import { CryptoPaymentMethod } from "./CryptoPaymentMethod";
export declare const OneOfExternalPaymentMethod: core.serialization.Schema<serializers.OneOfExternalPaymentMethod.Raw, PTI.OneOfExternalPaymentMethod>;
export declare namespace OneOfExternalPaymentMethod {
    type Raw = OneOfExternalPaymentMethod.Ach | OneOfExternalPaymentMethod.CreditCard | OneOfExternalPaymentMethod.Wire | OneOfExternalPaymentMethod.Crypto;
    interface Ach extends AchPaymentMethod.Raw {
        paymentMethodType: "ACH";
    }
    interface CreditCard extends CreditCardPaymentMethod.Raw {
        paymentMethodType: "CREDIT_CARD";
    }
    interface Wire extends WirePaymentMethod.Raw {
        paymentMethodType: "WIRE";
    }
    interface Crypto extends CryptoPaymentMethod.Raw {
        paymentMethodType: "CRYPTO";
    }
}