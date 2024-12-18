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
exports.EncryptedCreditCardPaymentInformation = void 0;
const core = __importStar(require("../../core"));
const Address_1 = require("./Address");
const ExternalPaymentInformation_1 = require("./ExternalPaymentInformation");
exports.EncryptedCreditCardPaymentInformation = core.serialization
    .object({
    encryptedInformation: core.serialization
        .record(core.serialization.string(), core.serialization.string())
        .optional(),
    creditCardLast4: core.serialization.string().optional(),
    cvv: core.serialization.string().optional(),
    creditCardType: core.serialization.string().optional(),
    creditCardFirst6: core.serialization.string().optional(),
    expirationYear: core.serialization.string().optional(),
    expirationMonth: core.serialization.string().optional(),
    creditCardBin: core.serialization.string().optional(),
    creditCardReference: core.serialization.string().optional(),
    cardHolderFirstName: core.serialization.string().optional(),
    cardHolderLastName: core.serialization.string().optional(),
    creditCardAddress: Address_1.Address.optional(),
    meta: core.serialization.record(core.serialization.string(), core.serialization.unknown()).optional(),
})
    .extend(ExternalPaymentInformation_1.ExternalPaymentInformation);
