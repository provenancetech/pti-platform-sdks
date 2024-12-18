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
exports.ExecuteSellTransaction = void 0;
const core = __importStar(require("../../../../../core"));
const DigitalItem_1 = require("../../../../types/DigitalItem");
const OneOfPaymentMethod_1 = require("../../../../types/OneOfPaymentMethod");
const OneOfUserSubTypes_1 = require("../../../../types/OneOfUserSubTypes");
const FeeRecipient_1 = require("../../../../types/FeeRecipient");
const TransactionType_1 = require("../../../../types/TransactionType");
exports.ExecuteSellTransaction = core.serialization
    .object({
    digitalItem: DigitalItem_1.DigitalItem.optional(),
    digitalItems: core.serialization.list(DigitalItem_1.DigitalItem).optional(),
    destinationMethod: OneOfPaymentMethod_1.OneOfPaymentMethod,
    buyer: OneOfUserSubTypes_1.OneOfUserSubTypes.optional(),
    feeRecipients: core.serialization.list(FeeRecipient_1.FeeRecipient).optional(),
})
    .extend(TransactionType_1.TransactionType);