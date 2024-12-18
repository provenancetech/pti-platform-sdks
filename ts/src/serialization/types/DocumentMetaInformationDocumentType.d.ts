/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const DocumentMetaInformationDocumentType: core.serialization.Schema<serializers.DocumentMetaInformationDocumentType.Raw, PTI.DocumentMetaInformationDocumentType>;
export declare namespace DocumentMetaInformationDocumentType {
    type Raw = "PASSPORT" | "PASSPORT_BACK" | "ID_CARD" | "ID_CARD_BACK" | "DRIVER_LICENCE" | "DRIVER_LICENCE_BACK" | "RESIDENCE_PERMIT" | "RESIDENCE_PERMIT_BACK" | "SELFIE" | "FOUNDING_DOCUMENT";
}