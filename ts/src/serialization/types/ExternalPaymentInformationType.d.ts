/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const ExternalPaymentInformationType: core.serialization.Schema<serializers.ExternalPaymentInformationType.Raw, PTI.ExternalPaymentInformationType>;
export declare namespace ExternalPaymentInformationType {
    type Raw = "BANK_ACCOUNT" | "ENCRYPTED_CREDIT_CARD" | "CRYPTO";
}
