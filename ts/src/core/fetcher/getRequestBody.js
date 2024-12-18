"use strict";
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
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.maybeStringifyBody = exports.getRequestBody = void 0;
const runtime_1 = require("../runtime");
function getRequestBody(body, contentType) {
    return __awaiter(this, void 0, void 0, function* () {
        let requestBody;
        if (runtime_1.RUNTIME.type === "node") {
            if (body instanceof (yield Promise.resolve().then(() => __importStar(require("formdata-node")))).FormData) {
                // @ts-expect-error
                requestBody = body;
            }
            else if (body instanceof (yield Promise.resolve().then(() => __importStar(require("stream")))).Readable) {
                // @ts-expect-error
                requestBody = body;
            }
            else {
                requestBody = (0, exports.maybeStringifyBody)(body, contentType !== null && contentType !== void 0 ? contentType : "");
            }
        }
        else {
            if (body instanceof (yield Promise.resolve().then(() => __importStar(require("form-data")))).default) {
                // @ts-expect-error
                requestBody = body;
            }
            else {
                requestBody = (0, exports.maybeStringifyBody)(body, contentType !== null && contentType !== void 0 ? contentType : "");
            }
        }
        return requestBody;
    });
}
exports.getRequestBody = getRequestBody;
const maybeStringifyBody = (requestBody, contentType) => {
    if (requestBody instanceof Uint8Array) {
        return requestBody;
    }
    else if (contentType === "application/x-www-form-urlencoded" && typeof requestBody === "string") {
        return requestBody;
    }
    else {
        return JSON.stringify(requestBody);
    }
};
exports.maybeStringifyBody = maybeStringifyBody;
