/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../../../../core";
import { WalletPaymentMethod } from "../../../../types/WalletPaymentMethod";
import { OneOfUserSubTypes } from "../../../../types/OneOfUserSubTypes";
import { TransactionType } from "../../../../types/TransactionType";
export const ExecuteTransferTransaction = core.serialization
    .object({
    sourceTransferMethod: WalletPaymentMethod,
    destinationTransferMethod: WalletPaymentMethod,
    destination: OneOfUserSubTypes,
    destinationClientId: core.serialization.string().optional(),
})
    .extend(TransactionType);
