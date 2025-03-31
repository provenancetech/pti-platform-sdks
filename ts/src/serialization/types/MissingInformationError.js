/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../core";
import { InformationFields } from "./InformationFields";
import { ManagedError } from "./ManagedError";
export const MissingInformationError = core.serialization
    .object({
    fields: core.serialization.list(InformationFields),
})
    .extend(ManagedError);
