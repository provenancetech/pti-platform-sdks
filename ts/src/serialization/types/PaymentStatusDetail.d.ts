/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { ProviderResponseCode } from "./ProviderResponseCode";
import { ProviderResponseCategory } from "./ProviderResponseCategory";
export declare const PaymentStatusDetail: core.serialization.ObjectSchema<serializers.PaymentStatusDetail.Raw, PTI.PaymentStatusDetail>;
export declare namespace PaymentStatusDetail {
    interface Raw {
        providerResponseCode?: ProviderResponseCode.Raw | null;
        providerResponseCategory?: ProviderResponseCategory.Raw | null;
    }
}
