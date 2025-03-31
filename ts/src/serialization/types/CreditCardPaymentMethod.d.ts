/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { OneOfFiatPaymentInformation } from "./OneOfFiatPaymentInformation";
export declare const CreditCardPaymentMethod: core.serialization.ObjectSchema<serializers.CreditCardPaymentMethod.Raw, PTI.CreditCardPaymentMethod>;
export declare namespace CreditCardPaymentMethod {
    interface Raw {
        currency?: string | null;
        billingEmail?: string | null;
        transactionDescription?: string | null;
        statementMessage?: string | null;
        paymentInformation?: OneOfFiatPaymentInformation.Raw | null;
        [key: string]: any;
    }
}
