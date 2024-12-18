/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { OneOfPaymentMethod } from "./OneOfPaymentMethod";
import { DigitalItem } from "./DigitalItem";
import { OneOfUserSubTypes } from "./OneOfUserSubTypes";
import { TransactionType } from "./TransactionType";
export declare const SellTransaction: core.serialization.ObjectSchema<serializers.SellTransaction.Raw, PTI.SellTransaction>;
export declare namespace SellTransaction {
    interface Raw extends TransactionType.Raw {
        destinationMethod?: OneOfPaymentMethod.Raw | null;
        sourceMethod?: OneOfPaymentMethod.Raw | null;
        digitalItem?: DigitalItem.Raw | null;
        buyer?: OneOfUserSubTypes.Raw | null;
    }
}
