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
var __rest = (this && this.__rest) || function (s, e) {
    var t = {};
    for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p) && e.indexOf(p) < 0)
        t[p] = s[p];
    if (s != null && typeof Object.getOwnPropertySymbols === "function")
        for (var i = 0, p = Object.getOwnPropertySymbols(s); i < p.length; i++) {
            if (e.indexOf(p[i]) < 0 && Object.prototype.propertyIsEnumerable.call(s, p[i]))
                t[p[i]] = s[p[i]];
        }
    return t;
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.Marketplace = void 0;
const environments = __importStar(require("../../../../environments"));
const core = __importStar(require("../../../../core"));
const PTI = __importStar(require("../../../index"));
const serializers = __importStar(require("../../../../serialization/index"));
const url_join_1 = __importDefault(require("url-join"));
const errors = __importStar(require("../../../../errors/index"));
class Marketplace {
    constructor(_options) {
        this._options = _options;
    }
    /**
     * This endpoint is used to execute a digital item buy (token, nft, other) transaction for a user. The transaction assessment and user information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteBuyTransaction} request
     * @param {Marketplace.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.marketplace.digitalItemBuy({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 5,
     *         amount: 5,
     *         date: "2024-12-13T18:46:40.666+0000",
     *         initiator: {
     *             type: "BUSINESS",
     *             id: "c5c4b077-0c9a-4d5f-84fd-439a6123cdd2",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         },
     *         type: PTI.TransactionTypeEnum.Buy,
     *         digitalItem: {
     *             itemReference: "21d7c009-8469-41ae-83d7-393085fd6fef",
     *             itemTitle: "itemTitle",
     *             itemDescription: "itemDescription",
     *             digitalItemType: PTI.DigitalItemType.Nft
     *         },
     *         sourceMethod: {
     *             paymentMethodType: "CRYPTO",
     *             paymentInformation: {
     *                 walletAddress: "walletAddress",
     *                 currency: "currency",
     *                 network: "network"
     *             }
     *         },
     *         seller: {
     *             type: "BUSINESS",
     *             id: "f0714c92-d5bf-4ed2-9636-e9ab3743fcb6",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         }
     *     })
     */
    digitalItemBuy(request, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const { ptiRequestId, ptiScenarioId, ptiSessionId, ptiDisableWebhook, ptiProviderName } = request, _body = __rest(request, ["ptiRequestId", "ptiScenarioId", "ptiSessionId", "ptiDisableWebhook", "ptiProviderName"]);
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, "transactions/purchases"),
                method: "POST",
                headers: {
                    Authorization: yield this._getAuthorizationHeader(),
                    "x-pti-client-id": (yield core.Supplier.get(this._options.ptiClientId)) != null
                        ? yield core.Supplier.get(this._options.ptiClientId)
                        : undefined,
                    "X-Fern-Language": "JavaScript",
                    "X-Fern-Runtime": core.RUNTIME.type,
                    "X-Fern-Runtime-Version": core.RUNTIME.version,
                    "x-pti-request-id": ptiRequestId,
                    "x-pti-scenario-id": ptiScenarioId,
                    "x-pti-session-id": ptiSessionId != null ? ptiSessionId : undefined,
                    "x-pti-disable-webhook": ptiDisableWebhook != null ? ptiDisableWebhook.toString() : undefined,
                    "x-pti-provider-name": ptiProviderName != null ? ptiProviderName : undefined,
                },
                contentType: "application/json",
                body: serializers.ExecuteBuyTransaction.jsonOrThrow(_body, { unrecognizedObjectKeys: "strip" }),
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.ObjectReference.parseOrThrow(_response.body, {
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
                    case 422:
                        throw new PTI.UnprocessableEntityError(serializers.OneOfAssessmentValidationError.parseOrThrow(_response.error.body, {
                            unrecognizedObjectKeys: "passthrough",
                            allowUnrecognizedUnionMembers: true,
                            allowUnrecognizedEnumValues: true,
                            breadcrumbsPrefix: ["response"],
                        }));
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
    /**
     * This endpoint is used to execute a digital item sell (token, nft, other) transaction for a user. The transaction assessment and user information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteSellTransaction} request
     * @param {Marketplace.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.marketplace.digitalItemSell({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 5,
     *         amount: 5,
     *         date: "2024-12-13T18:46:40.666+0000",
     *         initiator: {
     *             type: "BUSINESS",
     *             id: "2903c06b-6291-4cc8-b568-fe93064a5a8c",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         },
     *         type: PTI.TransactionTypeEnum.Sell,
     *         digitalItem: {
     *             itemReference: "f5511285-9d0b-41fd-8ae7-0817bb7462ba",
     *             itemTitle: "itemTitle",
     *             itemDescription: "itemDescription",
     *             digitalItemType: PTI.DigitalItemType.Nft
     *         },
     *         destinationMethod: {
     *             paymentMethodType: "CRYPTO",
     *             paymentInformation: {
     *                 walletAddress: "walletAddress",
     *                 currency: "currency",
     *                 network: "network"
     *             }
     *         },
     *         buyer: {
     *             type: "BUSINESS",
     *             id: "be975fae-fb15-4b70-80ba-e59968ae48c3",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         }
     *     })
     */
    digitalItemSell(request, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const { ptiRequestId, ptiScenarioId, ptiSessionId, ptiDisableWebhook, ptiProviderName } = request, _body = __rest(request, ["ptiRequestId", "ptiScenarioId", "ptiSessionId", "ptiDisableWebhook", "ptiProviderName"]);
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, "transactions/sales"),
                method: "POST",
                headers: {
                    Authorization: yield this._getAuthorizationHeader(),
                    "x-pti-client-id": (yield core.Supplier.get(this._options.ptiClientId)) != null
                        ? yield core.Supplier.get(this._options.ptiClientId)
                        : undefined,
                    "X-Fern-Language": "JavaScript",
                    "X-Fern-Runtime": core.RUNTIME.type,
                    "X-Fern-Runtime-Version": core.RUNTIME.version,
                    "x-pti-request-id": ptiRequestId,
                    "x-pti-scenario-id": ptiScenarioId,
                    "x-pti-session-id": ptiSessionId != null ? ptiSessionId : undefined,
                    "x-pti-disable-webhook": ptiDisableWebhook != null ? ptiDisableWebhook.toString() : undefined,
                    "x-pti-provider-name": ptiProviderName != null ? ptiProviderName : undefined,
                },
                contentType: "application/json",
                body: serializers.ExecuteSellTransaction.jsonOrThrow(_body, { unrecognizedObjectKeys: "strip" }),
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.ObjectReference.parseOrThrow(_response.body, {
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
                    case 422:
                        throw new PTI.UnprocessableEntityError(serializers.OneOfAssessmentValidationError.parseOrThrow(_response.error.body, {
                            unrecognizedObjectKeys: "passthrough",
                            allowUnrecognizedUnionMembers: true,
                            allowUnrecognizedEnumValues: true,
                            breadcrumbsPrefix: ["response"],
                        }));
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
    /**
     * @param {string} digitalItemId
     * @param {Marketplace.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.marketplace.getDigitalItem("digitalItemId")
     */
    getDigitalItem(digitalItemId, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `digital-items/${encodeURIComponent(digitalItemId)}`),
                method: "GET",
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
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.DigitalItem.parseOrThrow(_response.body, {
                    unrecognizedObjectKeys: "passthrough",
                    allowUnrecognizedUnionMembers: true,
                    allowUnrecognizedEnumValues: true,
                    breadcrumbsPrefix: ["response"],
                });
            }
            if (_response.error.reason === "status-code") {
                switch (_response.error.statusCode) {
                    case 401:
                        throw new PTI.UnauthorizedError(serializers.UnmanagedError.parseOrThrow(_response.error.body, {
                            unrecognizedObjectKeys: "passthrough",
                            allowUnrecognizedUnionMembers: true,
                            allowUnrecognizedEnumValues: true,
                            breadcrumbsPrefix: ["response"],
                        }));
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
    /**
     * @param {string} digitalItemId
     * @param {Marketplace.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.marketplace.deleteDigitalItem("digitalItemId")
     */
    deleteDigitalItem(digitalItemId, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `digital-items/${encodeURIComponent(digitalItemId)}`),
                method: "DELETE",
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
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return;
            }
            if (_response.error.reason === "status-code") {
                switch (_response.error.statusCode) {
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
    /**
     * @param {string} userId
     * @param {PTI.GetDigitalItemsRequest} request
     * @param {Marketplace.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.marketplace.getDigitalItems("userId")
     */
    getDigitalItems(userId, request = {}, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const { page, size, sortBy } = request;
            const _queryParams = {};
            if (page != null) {
                _queryParams["page"] = page.toString();
            }
            if (size != null) {
                _queryParams["size"] = size.toString();
            }
            if (sortBy != null) {
                _queryParams["sortBy"] = sortBy;
            }
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/digital-items`),
                method: "GET",
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
                queryParameters: _queryParams,
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.ObjectReferencePage.parseOrThrow(_response.body, {
                    unrecognizedObjectKeys: "passthrough",
                    allowUnrecognizedUnionMembers: true,
                    allowUnrecognizedEnumValues: true,
                    breadcrumbsPrefix: ["response"],
                });
            }
            if (_response.error.reason === "status-code") {
                switch (_response.error.statusCode) {
                    case 401:
                        throw new PTI.UnauthorizedError(serializers.UnmanagedError.parseOrThrow(_response.error.body, {
                            unrecognizedObjectKeys: "passthrough",
                            allowUnrecognizedUnionMembers: true,
                            allowUnrecognizedEnumValues: true,
                            breadcrumbsPrefix: ["response"],
                        }));
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
    /**
     * @param {string} userId
     * @param {PTI.DigitalItem[]} request
     * @param {Marketplace.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.marketplace.createDigitalItems("userId", [{
     *             itemReference: "57d6467c-6ae0-434f-8197-e7e9f86f2209",
     *             itemTitle: "QB, Mint Condition, #467/500 From Founders Set ",
     *             itemDescription: "Ultra Rare Elite Russell Wilson Level 1",
     *             itemUsdValue: 10,
     *             digitalItemType: PTI.DigitalItemType.Nft
     *         }, {
     *             itemReference: "57d6467c-6ae0-434f-8197-e7e9f86f2210",
     *             itemTitle: "QB, Mint Condition, #468/500 From Founders Set",
     *             itemDescription: "Ultra Rare Elite Peyton Manning Level 10",
     *             itemUsdValue: 35,
     *             digitalItemType: PTI.DigitalItemType.Nft
     *         }])
     */
    createDigitalItems(userId, request, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/digital-items`),
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
                body: serializers.marketplace.createDigitalItems.Request.jsonOrThrow(request, {
                    unrecognizedObjectKeys: "strip",
                }),
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.marketplace.createDigitalItems.Response.parseOrThrow(_response.body, {
                    unrecognizedObjectKeys: "passthrough",
                    allowUnrecognizedUnionMembers: true,
                    allowUnrecognizedEnumValues: true,
                    breadcrumbsPrefix: ["response"],
                });
            }
            if (_response.error.reason === "status-code") {
                switch (_response.error.statusCode) {
                    case 401:
                        throw new PTI.UnauthorizedError(serializers.UnmanagedError.parseOrThrow(_response.error.body, {
                            unrecognizedObjectKeys: "passthrough",
                            allowUnrecognizedUnionMembers: true,
                            allowUnrecognizedEnumValues: true,
                            breadcrumbsPrefix: ["response"],
                        }));
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
exports.Marketplace = Marketplace;
