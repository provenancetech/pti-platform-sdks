/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
/**
 * Status of a transaction request. The date property is the date that the transaction has been initiated.
 */
export interface TransactionStatusObject extends PTI.ActionStatus {
    status?: PTI.TransactionStatus;
    transactionType?: PTI.TransactionTypeEnum;
    paymentMethod?: PTI.PaymentInformationType;
    paymentStatusDetail?: PTI.PaymentStatusDetail;
    amount?: number;
    transactionGroupId?: PTI.UuidLikeStrTransactionGroup;
    billingEmail?: string;
    transactionTotal?: PTI.Total;
    currency?: string;
    /** key/value map of extra information */
    additionalInfos?: Record<string, unknown>;
}
