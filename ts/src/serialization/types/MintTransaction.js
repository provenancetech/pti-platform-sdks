/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../core";
import { OneOfUserSubTypes } from "./OneOfUserSubTypes";
import { CryptoPaymentMethod } from "./CryptoPaymentMethod";
import { TransactionType } from "./TransactionType";
export const MintTransaction = core.serialization
    .object({
    destination: OneOfUserSubTypes.optional(),
    destinationMethod: CryptoPaymentMethod.optional(),
})
    .extend(TransactionType);
