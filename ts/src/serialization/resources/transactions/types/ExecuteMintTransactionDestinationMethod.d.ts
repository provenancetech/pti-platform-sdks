/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../../../index";
import * as PTI from "../../../../api/index";
import * as core from "../../../../core";
import { WalletPaymentMethod } from "../../../types/WalletPaymentMethod";
export declare const ExecuteMintTransactionDestinationMethod: core.serialization.ObjectSchema<serializers.ExecuteMintTransactionDestinationMethod.Raw, PTI.ExecuteMintTransactionDestinationMethod>;
export declare namespace ExecuteMintTransactionDestinationMethod {
    interface Raw extends WalletPaymentMethod.Raw {
        paymentMethodType?: "WALLET" | null;
    }
}
