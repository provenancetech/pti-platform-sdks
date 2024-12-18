/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { Person } from "./Person";
import { Business } from "./Business";
export declare const OneOfUserSubTypes: core.serialization.Schema<serializers.OneOfUserSubTypes.Raw, PTI.OneOfUserSubTypes>;
export declare namespace OneOfUserSubTypes {
    type Raw = OneOfUserSubTypes.Person | OneOfUserSubTypes.Business;
    interface Person extends Person.Raw {
        type: "PERSON";
    }
    interface Business extends Business.Raw {
        type: "BUSINESS";
    }
}
