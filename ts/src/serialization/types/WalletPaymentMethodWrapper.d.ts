/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { WalletPaymentMethod } from "./WalletPaymentMethod";
export declare const WalletPaymentMethodWrapper: core.serialization.ObjectSchema<serializers.WalletPaymentMethodWrapper.Raw, PTI.WalletPaymentMethodWrapper>;
export declare namespace WalletPaymentMethodWrapper {
    interface Raw extends WalletPaymentMethod.Raw {
        paymentMethodType?: "WALLET" | null;
    }
}
