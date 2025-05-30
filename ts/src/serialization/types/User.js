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
exports.User = void 0;
const core = __importStar(require("../../core"));
const UserStatus_1 = require("./UserStatus");
const UserStatusReason_1 = require("./UserStatusReason");
const TagsType_1 = require("./TagsType");
const OneOfExternalPaymentInformation_1 = require("./OneOfExternalPaymentInformation");
exports.User = core.serialization.object({
    id: core.serialization.string(),
    status: UserStatus_1.UserStatus.optional(),
    statusReason: UserStatusReason_1.UserStatusReason.optional(),
    tags: core.serialization.list(TagsType_1.TagsType).optional(),
    paymentInformation: core.serialization.list(OneOfExternalPaymentInformation_1.OneOfExternalPaymentInformation).optional(),
    sourceOfFunds: core.serialization.string().optional(),
    userCreationDate: core.serialization.string().optional(),
    userPtiMeta: core.serialization.record(core.serialization.string(), core.serialization.unknown()).optional(),
    userClientMeta: core.serialization.record(core.serialization.string(), core.serialization.unknown()).optional(),
});
