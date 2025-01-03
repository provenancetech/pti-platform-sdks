/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const IdDocumentMetadata: core.serialization.ObjectSchema<serializers.IdDocumentMetadata.Raw, PTI.IdDocumentMetadata>;
export declare namespace IdDocumentMetadata {
    interface Raw {
        PERSON_NAME?: string | null;
        DATE_OF_BIRTH?: string | null;
        DOCUMENT_NUMBER?: string | null;
        NATIONALITY?: string | null;
        EXPIRY_DATE?: string | null;
    }
}
