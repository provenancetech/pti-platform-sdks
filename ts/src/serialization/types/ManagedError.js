/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../core";
import { ErrorType } from "./ErrorType";
export const ManagedError = core.serialization
    .object({
    type: ErrorType,
    code: core.serialization.number(),
})
    .passthrough();
