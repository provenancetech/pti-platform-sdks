/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../../../../index";
import * as PTI from "../../../../../api/index";
import * as core from "../../../../../core";
import { OneOfUserSubTypes } from "../../../../types/OneOfUserSubTypes";
import { ExecuteMintTransactionDestinationMethod } from "../../types/ExecuteMintTransactionDestinationMethod";
import { TransactionType } from "../../../../types/TransactionType";
export declare const ExecuteMintTransaction: core.serialization.Schema<serializers.ExecuteMintTransaction.Raw, Omit<PTI.ExecuteMintTransaction, "ptiRequestId" | "ptiScenarioId" | "ptiSessionId" | "ptiDisableWebhook" | "ptiProviderName">>;
export declare namespace ExecuteMintTransaction {
    interface Raw extends TransactionType.Raw {
        destination: OneOfUserSubTypes.Raw;
        destinationMethod: ExecuteMintTransactionDestinationMethod.Raw;
    }
}
