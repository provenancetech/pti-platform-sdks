/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { ExternalPaymentInformation } from "./ExternalPaymentInformation";
export declare const CryptoPaymentInformation: core.serialization.ObjectSchema<serializers.CryptoPaymentInformation.Raw, PTI.CryptoPaymentInformation>;
export declare namespace CryptoPaymentInformation {
    interface Raw extends ExternalPaymentInformation.Raw {
        walletAddress: string;
        currency: string;
        network: string;
        privateBlockchain?: boolean | null;
        clientMeta?: Record<string, unknown> | null;
    }
}
