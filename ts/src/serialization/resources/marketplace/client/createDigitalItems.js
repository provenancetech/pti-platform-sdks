/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../../../core";
import { DigitalItem } from "../../../types/DigitalItem";
import { ObjectReference } from "../../../types/ObjectReference";
export const Request = core.serialization.list(DigitalItem);
export const Response = core.serialization.list(ObjectReference);
