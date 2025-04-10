/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const UnmanagedError: core.serialization.ObjectSchema<serializers.UnmanagedError.Raw, PTI.UnmanagedError>;
export declare namespace UnmanagedError {
    interface Raw {
        error?: string | null;
        code?: number | null;
        [key: string]: any;
    }
}
