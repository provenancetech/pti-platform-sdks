/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../../../index";
import * as PTI from "../../../../api/index";
import * as core from "../../../../core";
export declare const TransactionUpdateFeedback: core.serialization.Schema<serializers.TransactionUpdateFeedback.Raw, PTI.TransactionUpdateFeedback>;
export declare namespace TransactionUpdateFeedback {
    type Raw = "SETTLED" | "ACCEPTED" | "CANCELLED" | "REJECTED" | "REFUNDED" | "CHARGED_BACK" | "ERROR";
}
