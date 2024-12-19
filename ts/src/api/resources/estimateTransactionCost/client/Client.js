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
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.EstimateTransactionCost = void 0;
const environments = __importStar(require("../../../../environments"));
const core = __importStar(require("../../../../core"));
const PTI = __importStar(require("../../../index"));
const serializers = __importStar(require("../../../../serialization/index"));
const url_join_1 = __importDefault(require("url-join"));
const errors = __importStar(require("../../../../errors/index"));
class EstimateTransactionCost {
    constructor(_options) {
        this._options = _options;
    }
    /**
     * @param {PTI.TradeTransaction} request
     * @param {EstimateTransactionCost.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.estimateTransactionCost.estimationTransactionCost({
     *         transactionGroupId: "c8d8ed2a-33df-463b-95af-e59ff6e16414",
     *         transactionTotal: {
     *             fee: {
     *                 amount: 10,
     *                 currency: "USD"
     *             },
     *             total: {
     *                 amount: 100,
     *                 currency: "USD"
     *             },
     *             subtotal: {
     *                 amount: 90,
     *                 currency: "USD"
     *             }
     *         },
     *         usdValue: 100,
     *         amount: 100,
     *         date: "2024-12-13T18:46:40.666+0000",
     *         initiator: {
     *             type: "BUSINESS",
     *             id: "36dbe68f-2747-41c6-8748-559588fd3248",
     *             sourceOfFunds: "Creator earnings",
     *             addresses: [{
     *                     streetAddress: "1, main street",
     *                     city: "New Hampshire",
     *                     postalCode: "10005",
     *                     stateCode: "US-NH",
     *                     country: "US",
     *                     default: true
     *                 }],
     *             emails: [{
     *                     default: true,
     *                     address: "johnsmith@test.com"
     *                 }],
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             },
     *             phones: [{
     *                     default: true,
     *                     number: "12345678901",
     *                     type: "WORK"
     *                 }]
     *         },
     *         type: PTI.TransactionTypeEnum.Deposit,
     *         destinationMethod: {
     *             paymentInformation: {
     *                 id: "3f8d7e96-5d63-49b4-b4a8-42c70ef0cc82",
     *                 walletAddress: "walletAddress",
     *                 currency: "currency",
     *                 network: "network"
     *             }
     *         },
     *         sourceMethod: {
     *             paymentInformation: {
     *                 id: "4b573a86-fd3f-475d-a90b-3658f2e79719",
     *                 walletAddress: "walletAddress",
     *                 currency: "currency",
     *                 network: "network"
     *             }
     *         }
     *     })
     */
    estimationTransactionCost(request, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, "transactions/trades/price-estimation"),
                method: "POST",
                headers: {
                    Authorization: yield this._getAuthorizationHeader(),
                    "x-pti-client-id": (yield core.Supplier.get(this._options.ptiClientId)) != null
                        ? yield core.Supplier.get(this._options.ptiClientId)
                        : undefined,
                    "X-Fern-Language": "JavaScript",
                    "X-Fern-Runtime": core.RUNTIME.type,
                    "X-Fern-Runtime-Version": core.RUNTIME.version,
                },
                contentType: "application/json",
                body: serializers.TradeTransaction.jsonOrThrow(request, { unrecognizedObjectKeys: "strip" }),
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.TradeQuote.parseOrThrow(_response.body, {
                    unrecognizedObjectKeys: "passthrough",
                    allowUnrecognizedUnionMembers: true,
                    allowUnrecognizedEnumValues: true,
                    breadcrumbsPrefix: ["response"],
                });
            }
            if (_response.error.reason === "status-code") {
                switch (_response.error.statusCode) {
                    case 400:
                        throw new PTI.BadRequestError(serializers.InvalidRequestError.parseOrThrow(_response.error.body, {
                            unrecognizedObjectKeys: "passthrough",
                            allowUnrecognizedUnionMembers: true,
                            allowUnrecognizedEnumValues: true,
                            breadcrumbsPrefix: ["response"],
                        }));
                    case 401:
                        throw new PTI.UnauthorizedError(serializers.UnmanagedError.parseOrThrow(_response.error.body, {
                            unrecognizedObjectKeys: "passthrough",
                            allowUnrecognizedUnionMembers: true,
                            allowUnrecognizedEnumValues: true,
                            breadcrumbsPrefix: ["response"],
                        }));
                    case 403:
                        throw new PTI.ForbiddenError(_response.error.body);
                    case 404:
                        throw new PTI.NotFoundError(_response.error.body);
                    case 429:
                        throw new PTI.TooManyRequestsError(_response.error.body);
                    default:
                        throw new errors.PTIError({
                            statusCode: _response.error.statusCode,
                            body: _response.error.body,
                        });
                }
            }
            switch (_response.error.reason) {
                case "non-json":
                    throw new errors.PTIError({
                        statusCode: _response.error.statusCode,
                        body: _response.error.rawBody,
                    });
                case "timeout":
                    throw new errors.PTITimeoutError();
                case "unknown":
                    throw new errors.PTIError({
                        message: _response.error.errorMessage,
                    });
            }
        });
    }
    _getAuthorizationHeader() {
        return __awaiter(this, void 0, void 0, function* () {
            return `Bearer ${yield core.Supplier.get(this._options.token)}`;
        });
    }
}
exports.EstimateTransactionCost = EstimateTransactionCost;
