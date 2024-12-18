/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export interface FeeRecipient {
    /** User ID of the Commission Recipient */
    feeRecipientId: string;
    walletId: string;
    currency: string;
    amount: number;
    feeRecipientType: PTI.FeeRecipientFeeRecipientType;
}
