/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../../../../index";
import * as PTI from "../../../../../api/index";
import * as core from "../../../../../core";
import { WalletPaymentMethod } from "../../../../types/WalletPaymentMethod";
import { TransactionType } from "../../../../types/TransactionType";
export declare const ExecuteTradeTransaction: core.serialization.Schema<serializers.ExecuteTradeTransaction.Raw, Omit<PTI.ExecuteTradeTransaction, "ptiRequestId" | "ptiScenarioId" | "ptiSessionId" | "ptiDisableWebhook" | "ptiProviderName">>;
export declare namespace ExecuteTradeTransaction {
    interface Raw extends TransactionType.Raw {
        sourceMethod: WalletPaymentMethod.Raw;
        destinationMethod: WalletPaymentMethod.Raw;
    }
}