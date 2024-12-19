/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { UserAssessStatus } from "./UserAssessStatus";
import { KycProviderResponseCode } from "./KycProviderResponseCode";
import { ActionStatus } from "./ActionStatus";
export declare const UserAssessStatusObject: core.serialization.ObjectSchema<serializers.UserAssessStatusObject.Raw, PTI.UserAssessStatusObject>;
export declare namespace UserAssessStatusObject {
    interface Raw extends ActionStatus.Raw {
        assessment?: UserAssessStatus.Raw | null;
        meta?: Record<string, unknown> | null;
        tier?: number | null;
        refusalReason?: KycProviderResponseCode.Raw | null;
    }
}
