/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { CryptoPaymentInformation } from "./CryptoPaymentInformation";
export declare const CryptoPaymentMethodSource: core.serialization.ObjectSchema<serializers.CryptoPaymentMethodSource.Raw, PTI.CryptoPaymentMethodSource>;
export declare namespace CryptoPaymentMethodSource {
    interface Raw {
        paymentInformation?: CryptoPaymentInformation.Raw | null;
    }
}