/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export interface WithdrawalTransaction extends PTI.TransactionType {
    destinationMethod?: PTI.OneOfPaymentMethod;
    sourceMethod?: PTI.OneOfPaymentMethod;
}
