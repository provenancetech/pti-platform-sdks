/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export type OneOfUserSubTypes = PTI.OneOfUserSubTypes.Person | PTI.OneOfUserSubTypes.Business;
export declare namespace OneOfUserSubTypes {
    interface Person extends PTI.Person {
        type: "PERSON";
    }
    interface Business extends PTI.Business {
        type: "BUSINESS";
    }
}
