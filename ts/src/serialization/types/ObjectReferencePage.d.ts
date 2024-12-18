/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { ObjectReference } from "./ObjectReference";
export declare const ObjectReferencePage: core.serialization.ObjectSchema<serializers.ObjectReferencePage.Raw, PTI.ObjectReferencePage>;
export declare namespace ObjectReferencePage {
    interface Raw {
        page?: number | null;
        pageSize?: number | null;
        total?: number | null;
        items?: ObjectReference.Raw[] | null;
    }
}
