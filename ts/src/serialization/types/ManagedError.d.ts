/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { ErrorType } from "./ErrorType";
export declare const ManagedError: core.serialization.ObjectSchema<serializers.ManagedError.Raw, PTI.ManagedError>;
export declare namespace ManagedError {
    interface Raw {
        type: ErrorType.Raw;
        code: number;
        [key: string]: any;
    }
}
