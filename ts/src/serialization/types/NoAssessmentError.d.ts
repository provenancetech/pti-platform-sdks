/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { ManagedError } from "./ManagedError";
export declare const NoAssessmentError: core.serialization.ObjectSchema<serializers.NoAssessmentError.Raw, PTI.NoAssessmentError>;
export declare namespace NoAssessmentError {
    interface Raw extends ManagedError.Raw {
        assessment?: Record<string, unknown> | null;
    }
}
