/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { DocumentMetaInformationDocumentType } from "./DocumentMetaInformationDocumentType";
import { UuidLikeStr } from "./UuidLikeStr";
export declare const DocumentMetaInformation: core.serialization.ObjectSchema<serializers.DocumentMetaInformation.Raw, PTI.DocumentMetaInformation>;
export declare namespace DocumentMetaInformation {
    interface Raw {
        documentType: DocumentMetaInformationDocumentType.Raw;
        contentType: string;
        originalFileName?: string | null;
        fileSize?: number | null;
        tags?: Record<string, string> | null;
        fileId?: UuidLikeStr.Raw | null;
    }
}
