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
exports.OneOfPaymentMethod = void 0;
const core = __importStar(require("../../core"));
const AchPaymentMethod_1 = require("./AchPaymentMethod");
const CreditCardPaymentMethod_1 = require("./CreditCardPaymentMethod");
const WirePaymentMethod_1 = require("./WirePaymentMethod");
const WalletPaymentMethod_1 = require("./WalletPaymentMethod");
const CryptoPaymentMethod_1 = require("./CryptoPaymentMethod");
exports.OneOfPaymentMethod = core.serialization
    .union("paymentMethodType", {
    ACH: AchPaymentMethod_1.AchPaymentMethod,
    CREDIT_CARD: CreditCardPaymentMethod_1.CreditCardPaymentMethod,
    WIRE: WirePaymentMethod_1.WirePaymentMethod,
    WALLET: WalletPaymentMethod_1.WalletPaymentMethod,
    CRYPTO: CryptoPaymentMethod_1.CryptoPaymentMethod,
})
    .transform({
    transform: (value) => value,
    untransform: (value) => value,
});
