/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const Ssn: core.serialization.ObjectSchema<serializers.Ssn.Raw, PTI.Ssn>;
export declare namespace Ssn {
    interface Raw {
        value?: string | null;
    }
}
