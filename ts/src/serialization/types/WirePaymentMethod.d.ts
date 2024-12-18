/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { OneOfFiatPaymentInformation } from "./OneOfFiatPaymentInformation";
export declare const WirePaymentMethod: core.serialization.ObjectSchema<serializers.WirePaymentMethod.Raw, PTI.WirePaymentMethod>;
export declare namespace WirePaymentMethod {
    interface Raw {
        currency?: string | null;
        purposeOfPayment?: string | null;
        memo?: string | null;
        billingEmail?: string | null;
        paymentInformation?: OneOfFiatPaymentInformation.Raw | null;
    }
}
