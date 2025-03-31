/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export type OneOfPaymentMethod = PTI.OneOfPaymentMethod.Ach | PTI.OneOfPaymentMethod.CreditCard | PTI.OneOfPaymentMethod.Wire | PTI.OneOfPaymentMethod.Wallet | PTI.OneOfPaymentMethod.Crypto;
export declare namespace OneOfPaymentMethod {
    interface Ach extends PTI.AchPaymentMethod {
        paymentMethodType: "ACH";
    }
    interface CreditCard extends PTI.CreditCardPaymentMethod {
        paymentMethodType: "CREDIT_CARD";
    }
    interface Wire extends PTI.WirePaymentMethod {
        paymentMethodType: "WIRE";
    }
    interface Wallet extends PTI.WalletPaymentMethod {
        paymentMethodType: "WALLET";
    }
    interface Crypto extends PTI.CryptoPaymentMethod {
        paymentMethodType: "CRYPTO";
    }
}
