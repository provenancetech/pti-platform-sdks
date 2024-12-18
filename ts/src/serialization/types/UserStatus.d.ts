/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const UserStatus: core.serialization.Schema<serializers.UserStatus.Raw, PTI.UserStatus>;
export declare namespace UserStatus {
    type Raw = "ACTIVE" | "INACTIVE" | "BLOCKED";
}