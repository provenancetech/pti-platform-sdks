/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../../../../index";
import * as PTI from "../../../../../api/index";
import * as core from "../../../../../core";
import { DigitalItem } from "../../../../types/DigitalItem";
import { OneOfPaymentMethod } from "../../../../types/OneOfPaymentMethod";
import { OneOfUserSubTypes } from "../../../../types/OneOfUserSubTypes";
import { FeeRecipient } from "../../../../types/FeeRecipient";
import { TransactionType } from "../../../../types/TransactionType";
export declare const ExecuteBuyTransaction: core.serialization.Schema<serializers.ExecuteBuyTransaction.Raw, Omit<PTI.ExecuteBuyTransaction, "ptiRequestId" | "ptiScenarioId" | "ptiSessionId" | "ptiDisableWebhook" | "ptiProviderName">>;
export declare namespace ExecuteBuyTransaction {
    interface Raw extends TransactionType.Raw {
        digitalItem?: DigitalItem.Raw | null;
        digitalItems?: DigitalItem.Raw[] | null;
        sourceMethod: OneOfPaymentMethod.Raw;
        seller?: OneOfUserSubTypes.Raw | null;
        feeRecipients?: FeeRecipient.Raw[] | null;
    }
}