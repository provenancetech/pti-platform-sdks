/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { OneOfUserSubTypes } from "./OneOfUserSubTypes";
import { Page } from "./Page";
export declare const UserPage: core.serialization.ObjectSchema<serializers.UserPage.Raw, PTI.UserPage>;
export declare namespace UserPage {
    interface Raw extends Page.Raw {
        content?: OneOfUserSubTypes.Raw[] | null;
    }
}