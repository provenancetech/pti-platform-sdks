/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export type KycRequest = PTI.KycRequest.Person | PTI.KycRequest.Business;
export declare namespace KycRequest {
    interface Person extends PTI.Person, _Base {
        type: "PERSON";
    }
    interface Business extends PTI.Business, _Base {
        type: "BUSINESS";
    }
    interface _Base {
        /** The value of the transaction that the User is intending to perform in USD */
        intendedTransactionUsdValue?: number;
        /** key/value map of extra meta data for this request (used by PTI) */
        ptiMeta?: Record<string, unknown>;
        /** key/value map of extra meta data for this request (used by Client) */
        clientMeta?: Record<string, unknown>;
    }
}
