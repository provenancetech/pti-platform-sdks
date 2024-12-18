/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { CryptoPaymentInformation } from "./CryptoPaymentInformation";
export declare const CryptoPaymentMethodDestination: core.serialization.ObjectSchema<serializers.CryptoPaymentMethodDestination.Raw, PTI.CryptoPaymentMethodDestination>;
export declare namespace CryptoPaymentMethodDestination {
    interface Raw {
        paymentInformation?: CryptoPaymentInformation.Raw | null;
    }
}