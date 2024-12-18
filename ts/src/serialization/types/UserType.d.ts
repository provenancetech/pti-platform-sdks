/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const UserType: core.serialization.Schema<serializers.UserType.Raw, PTI.UserType>;
export declare namespace UserType {
    type Raw = "PERSON" | "BUSINESS";
}