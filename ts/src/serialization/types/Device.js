/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../core";
import { DeviceProviderName } from "./DeviceProviderName";
export const Device = core.serialization.object({
    fingerPrint: core.serialization.string(),
    providerName: DeviceProviderName,
    deviceData: core.serialization.string().optional(),
});
