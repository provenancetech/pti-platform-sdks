/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../../../index";
import * as PTI from "../../../../api/index";
import * as core from "../../../../core";
import { Wallet } from "../../../types/Wallet";
export declare const Response: core.serialization.Schema<serializers.wallets.getWallets.Response.Raw, PTI.Wallet[]>;
export declare namespace Response {
    type Raw = Wallet.Raw[];
}
