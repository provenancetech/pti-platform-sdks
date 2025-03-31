/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../core";
import { OneOfFiatPaymentInformation } from "./OneOfFiatPaymentInformation";
export const WirePaymentMethod = core.serialization.object({
    currency: core.serialization.string().optional(),
    purposeOfPayment: core.serialization.string().optional(),
    memo: core.serialization.string().optional(),
    billingEmail: core.serialization.string().optional(),
    paymentInformation: OneOfFiatPaymentInformation.optional(),
});
