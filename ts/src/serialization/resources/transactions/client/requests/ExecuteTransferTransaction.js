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
var __importStar = (this && this.__importStar) || (function () {
    var ownKeys = function(o) {
        ownKeys = Object.getOwnPropertyNames || function (o) {
            var ar = [];
            for (var k in o) if (Object.prototype.hasOwnProperty.call(o, k)) ar[ar.length] = k;
            return ar;
        };
        return ownKeys(o);
    };
    return function (mod) {
        if (mod && mod.__esModule) return mod;
        var result = {};
        if (mod != null) for (var k = ownKeys(mod), i = 0; i < k.length; i++) if (k[i] !== "default") __createBinding(result, mod, k[i]);
        __setModuleDefault(result, mod);
        return result;
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.ExecuteTransferTransaction = void 0;
const core = __importStar(require("../../../../../core"));
const ExecuteTransferTransactionSourceTransferMethod_1 = require("../../types/ExecuteTransferTransactionSourceTransferMethod");
const ExecuteTransferTransactionDestinationTransferMethod_1 = require("../../types/ExecuteTransferTransactionDestinationTransferMethod");
const OneOfUserSubTypes_1 = require("../../../../types/OneOfUserSubTypes");
const TransactionType_1 = require("../../../../types/TransactionType");
exports.ExecuteTransferTransaction = core.serialization
    .object({
    sourceTransferMethod: ExecuteTransferTransactionSourceTransferMethod_1.ExecuteTransferTransactionSourceTransferMethod,
    destinationTransferMethod: ExecuteTransferTransactionDestinationTransferMethod_1.ExecuteTransferTransactionDestinationTransferMethod,
    destination: OneOfUserSubTypes_1.OneOfUserSubTypes,
    destinationClientId: core.serialization.string().optional(),
})
    .extend(TransactionType_1.TransactionType);
