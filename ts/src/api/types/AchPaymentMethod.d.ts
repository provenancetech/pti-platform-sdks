/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export interface AchPaymentMethod {
    currency?: string;
    billingEmail?: string;
    paymentInformation?: PTI.OneOfFiatPaymentInformation;
    /** Accepts any additional properties */
    [key: string]: any;
}
