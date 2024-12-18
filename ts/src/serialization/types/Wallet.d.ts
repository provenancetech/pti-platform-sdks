/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { CurrencyEnum } from "./CurrencyEnum";
import { BlockChainEnum } from "./BlockChainEnum";
export declare const Wallet: core.serialization.ObjectSchema<serializers.Wallet.Raw, PTI.Wallet>;
export declare namespace Wallet {
    interface Raw {
        walletId?: string | null;
        label?: string | null;
        currency?: CurrencyEnum.Raw | null;
        network?: BlockChainEnum.Raw | null;
        balance?: number | null;
        inflightBalance?: number | null;
        availableBalance?: number | null;
        depositInstruction?: Record<string, unknown> | null;
        createDateTime?: string | null;
        multiWalletAddress?: boolean | null;
        type?: "WALLET" | null;
    }
}
