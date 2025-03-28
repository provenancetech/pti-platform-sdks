/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export interface SellTransaction extends PTI.TransactionType {
    destinationMethod?: PTI.OneOfPaymentMethod;
    sourceMethod?: PTI.OneOfPaymentMethod;
    digitalItem?: PTI.DigitalItem;
    buyer?: PTI.OneOfUserSubTypes;
}
