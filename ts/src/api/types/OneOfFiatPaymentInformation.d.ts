/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export type OneOfFiatPaymentInformation = PTI.OneOfFiatPaymentInformation.EncryptedCreditCard | PTI.OneOfFiatPaymentInformation.BankAccount;
export declare namespace OneOfFiatPaymentInformation {
    interface EncryptedCreditCard extends PTI.EncryptedCreditCardPaymentInformation {
        type: "ENCRYPTED_CREDIT_CARD";
    }
    interface BankAccount extends PTI.BankAccountPaymentInformation {
        type: "BANK_ACCOUNT";
    }
}
