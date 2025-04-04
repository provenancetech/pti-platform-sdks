/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const TransactionAssessStatus: core.serialization.Schema<serializers.TransactionAssessStatus.Raw, PTI.TransactionAssessStatus>;
export declare namespace TransactionAssessStatus {
    type Raw = "PENDING" | "ERROR" | "MANUAL_REVIEW" | "PROCEED" | "STOP";
}
