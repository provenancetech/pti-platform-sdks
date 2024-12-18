/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const PaymentInformationType: core.serialization.Schema<serializers.PaymentInformationType.Raw, PTI.PaymentInformationType>;
export declare namespace PaymentInformationType {
    type Raw = "BANK_ACCOUNT" | "ENCRYPTED_CREDIT_CARD" | "CRYPTO" | "WALLET";
}
