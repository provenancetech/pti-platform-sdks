/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const InformationFields: core.serialization.Schema<serializers.InformationFields.Raw, PTI.InformationFields>;
export declare namespace InformationFields {
    type Raw = "FULL_NAME" | "EMAIL_ADDRESS" | "PHYSICAL_ADDRESS" | "BIRTH_DATE" | "PHONE_NUMBER" | "TOKEN_ADDRESS" | "US_CITIZENSHIP" | "ID_DOCUMENT" | "SOURCE_OF_FUNDS";
}
