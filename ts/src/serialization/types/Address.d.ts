/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { StateCode } from "./StateCode";
import { CountryCode } from "./CountryCode";
export declare const Address: core.serialization.ObjectSchema<serializers.Address.Raw, PTI.Address>;
export declare namespace Address {
    interface Raw {
        streetAddress?: string | null;
        city?: string | null;
        postalCode?: string | null;
        stateCode?: StateCode.Raw | null;
        country?: CountryCode.Raw | null;
        default?: boolean | null;
    }
}
