/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export type Pii = PTI.Pii.Ssn | PTI.Pii.Itin;
export declare namespace Pii {
    interface Ssn extends PTI.Ssn {
        type: "SSN";
    }
    interface Itin extends PTI.Itin {
        type: "ITIN";
    }
}
