/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
/**
 * The `transactionTotal` field will be assumed to be all zeroes if not provided. If no currency has been provided `USD` will be used. If no amount has been provided `0` will be used
 */
export interface Transaction {
    transactionGroupId?: PTI.UuidLikeStrTransactionGroup;
    subClientId?: PTI.UuidLikeStrSubClient;
    transactionTotal?: PTI.Total;
    usdValue: number;
    amount: number;
    /** ISO-8601 */
    date: string;
    initiator: PTI.OneOfUserSubTypes;
    /** key/value map of extra meta data for this request (used by PTI) */
    ptiMeta?: Record<string, unknown>;
    /** key/value map of extra meta data for this request (used by Client) */
    clientMeta?: Record<string, unknown>;
}