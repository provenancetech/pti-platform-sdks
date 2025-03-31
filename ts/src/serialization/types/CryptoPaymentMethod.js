/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../core";
import { CryptoPaymentInformation } from "./CryptoPaymentInformation";
export const CryptoPaymentMethod = core.serialization
    .object({
    billingEmail: core.serialization.string().optional(),
    paymentInformation: CryptoPaymentInformation.optional(),
})
    .passthrough();
