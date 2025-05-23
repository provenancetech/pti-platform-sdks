/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../../../../index";
import * as PTI from "../../../../../api/index";
import * as core from "../../../../../core";
import { WalletPaymentMethodWrapper } from "../../../../types/WalletPaymentMethodWrapper";
import { OneOfUserSubTypes } from "../../../../types/OneOfUserSubTypes";
import { TransactionType } from "../../../../types/TransactionType";
export declare const ExecuteTransferTransaction: core.serialization.Schema<serializers.ExecuteTransferTransaction.Raw, Omit<PTI.ExecuteTransferTransaction, "ptiRequestId" | "ptiScenarioId" | "ptiSessionId" | "ptiDisableWebhook" | "ptiProviderName">>;
export declare namespace ExecuteTransferTransaction {
    interface Raw extends TransactionType.Raw {
        sourceTransferMethod: WalletPaymentMethodWrapper.Raw;
        destinationTransferMethod: WalletPaymentMethodWrapper.Raw;
        destination: OneOfUserSubTypes.Raw;
        destinationClientId?: string | null;
    }
}
