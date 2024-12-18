/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const BlockChainEnum: core.serialization.Schema<serializers.BlockChainEnum.Raw, PTI.BlockChainEnum>;
export declare namespace BlockChainEnum {
    type Raw = "ETHEREUM" | "BITCOIN" | "SOLANA" | "POLYGON";
}