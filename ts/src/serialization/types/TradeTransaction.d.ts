/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { CryptoPaymentMethodDestination } from "./CryptoPaymentMethodDestination";
import { CryptoPaymentMethodSource } from "./CryptoPaymentMethodSource";
import { TransactionType } from "./TransactionType";
export declare const TradeTransaction: core.serialization.ObjectSchema<serializers.TradeTransaction.Raw, PTI.TradeTransaction>;
export declare namespace TradeTransaction {
    interface Raw extends TransactionType.Raw {
        destinationMethod?: CryptoPaymentMethodDestination.Raw | null;
        sourceMethod?: CryptoPaymentMethodSource.Raw | null;
    }
}
