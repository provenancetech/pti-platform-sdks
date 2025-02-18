/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { DeviceProviderName } from "./DeviceProviderName";
export declare const Device: core.serialization.ObjectSchema<serializers.Device.Raw, PTI.Device>;
export declare namespace Device {
    interface Raw {
        fingerPrint: string;
        providerName: DeviceProviderName.Raw;
        deviceData?: string | null;
    }
}
