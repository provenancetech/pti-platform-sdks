/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../../../../index";
import * as PTI from "../../../../../api/index";
import * as core from "../../../../../core";
import { OneOfExternalPaymentMethod } from "../../../../types/OneOfExternalPaymentMethod";
import { WalletPaymentMethodWrapper } from "../../../../types/WalletPaymentMethodWrapper";
import { TransactionType } from "../../../../types/TransactionType";
export declare const ExecuteDepositTransaction: core.serialization.Schema<serializers.ExecuteDepositTransaction.Raw, Omit<PTI.ExecuteDepositTransaction, "ptiRequestId" | "ptiScenarioId" | "ptiSessionId" | "ptiDisableWebhook" | "ptiProviderName">>;
export declare namespace ExecuteDepositTransaction {
    interface Raw extends TransactionType.Raw {
        sourceMethod: OneOfExternalPaymentMethod.Raw;
        destinationMethod?: WalletPaymentMethodWrapper.Raw | null;
    }
}
