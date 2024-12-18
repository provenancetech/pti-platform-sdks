/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { OneOfPaymentMethod } from "./OneOfPaymentMethod";
import { TransactionType } from "./TransactionType";
export declare const PaymentTransaction: core.serialization.ObjectSchema<serializers.PaymentTransaction.Raw, PTI.PaymentTransaction>;
export declare namespace PaymentTransaction {
    interface Raw extends TransactionType.Raw {
        sourceMethod?: OneOfPaymentMethod.Raw | null;
    }
}
