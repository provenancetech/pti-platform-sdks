/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const TransactionRiskAssessment: core.serialization.Schema<serializers.TransactionRiskAssessment.Raw, PTI.TransactionRiskAssessment>;
export declare namespace TransactionRiskAssessment {
    type Raw = "LOW" | "MEDIUM" | "HIGH";
}
