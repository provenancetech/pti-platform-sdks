/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const UserAssessStatus: core.serialization.Schema<serializers.UserAssessStatus.Raw, PTI.UserAssessStatus>;
export declare namespace UserAssessStatus {
    type Raw = "PENDING" | "ERROR" | "UNDER_REVIEW" | "REQUESTED_MORE_INFORMATION" | "ACCEPTED" | "REFUSED";
}
