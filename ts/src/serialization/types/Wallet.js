"use strict";
/**
 * This file was auto-generated by Fern from our API Definition.
 */
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.Wallet = void 0;
const core = __importStar(require("../../core"));
const CurrencyEnum_1 = require("./CurrencyEnum");
const BlockChainEnum_1 = require("./BlockChainEnum");
exports.Wallet = core.serialization.object({
    walletId: core.serialization.string().optional(),
    label: core.serialization.string().optional(),
    currency: CurrencyEnum_1.CurrencyEnum.optional(),
    network: BlockChainEnum_1.BlockChainEnum.optional(),
    balance: core.serialization.number().optional(),
    inflightBalance: core.serialization.number().optional(),
    availableBalance: core.serialization.number().optional(),
    depositInstruction: core.serialization.record(core.serialization.string(), core.serialization.unknown()).optional(),
    createDateTime: core.serialization.string().optional(),
    multiWalletAddress: core.serialization.boolean().optional(),
    type: core.serialization.stringLiteral("WALLET").optional(),
});
