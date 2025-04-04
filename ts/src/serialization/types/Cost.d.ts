/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const Cost: core.serialization.ObjectSchema<serializers.Cost.Raw, PTI.Cost>;
export declare namespace Cost {
    interface Raw {
        amount?: number | null;
        currency?: string | null;
    }
}
