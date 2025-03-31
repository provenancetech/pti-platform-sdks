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
     * This endpoint is used to execute a Digital Item buy (token, nft, other) transaction for a User. The Transaction Assessment and User information requirement are evaluated before the Transaction is executed.
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
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         type: "BUY",
     *         digitalItem: {
     *             itemReference: "21d7c009-8469-41ae-83d7-393085fd6fef",
     *             itemTitle: "itemTitle",
     *             itemDescription: "itemDescription",
     *             digitalItemType: "NFT"
     *         },
     *         sourceMethod: {
     *             paymentMethodType: "WALLET"
     *         },
     *         seller: {
     *             type: "PERSON",
     *             id: "id"
     *         }
     *     })
     */
    digitalItemBuy(request, requestOptions) {
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b;
            const { ptiRequestId, ptiScenarioId, ptiSessionId, ptiDisableWebhook, ptiProviderName } = request, _body = __rest(request, ["ptiRequestId", "ptiScenarioId", "ptiSessionId", "ptiDisableWebhook", "ptiProviderName"]);
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_b = (_a = (yield core.Supplier.get(this._options.baseUrl))) !== null && _a !== void 0 ? _a : (yield core.Supplier.get(this._options.environment))) !== null && _b !== void 0 ? _b : environments.PTIEnvironment.Default, "transactions/purchases"),
                method: "POST",
                headers: Object.assign({ Authorization: yield this._getAuthorizationHeader(), "x-pti-client-id": (yield core.Supplier.get(this._options.ptiClientId)) != null
                        ? serializers.UuidLikeStr.jsonOrThrow(yield core.Supplier.get(this._options.ptiClientId), {
                            unrecognizedObjectKeys: "strip",
                        })
                        : undefined, "X-Fern-Language": "JavaScript", "X-Fern-Runtime": core.RUNTIME.type, "X-Fern-Runtime-Version": core.RUNTIME.version, "x-pti-request-id": serializers.UuidLikeStr.jsonOrThrow(ptiRequestId, {
                        unrecognizedObjectKeys: "strip",
                    }), "x-pti-scenario-id": serializers.UuidLikeStr.jsonOrThrow(ptiScenarioId, {
                        unrecognizedObjectKeys: "strip",
                    }), "x-pti-session-id": ptiSessionId != null
                        ? serializers.UuidLikeStr.jsonOrThrow(ptiSessionId, { unrecognizedObjectKeys: "strip" })
                        : undefined, "x-pti-disable-webhook": ptiDisableWebhook != null ? ptiDisableWebhook.toString() : undefined, "x-pti-provider-name": ptiProviderName != null
                        ? serializers.ProviderName.jsonOrThrow(ptiProviderName, { unrecognizedObjectKeys: "strip" })
                        : undefined }, requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.headers),
                contentType: "application/json",
                requestType: "json",
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
                    throw new errors.PTITimeoutError("Timeout exceeded when calling POST /transactions/purchases.");
                case "unknown":
                    throw new errors.PTIError({
                        message: _response.error.errorMessage,
                    });
            }
        });
    }
    /**
     * This endpoint is used to execute a Digital Item sell (token, nft, other) transaction for a User. The Transaction Assessment and User information requirement are evaluated before the transaction is executed.
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
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         type: "SELL",
     *         digitalItem: {
     *             itemReference: "f5511285-9d0b-41fd-8ae7-0817bb7462ba",
     *             itemTitle: "itemTitle",
     *             itemDescription: "itemDescription",
     *             digitalItemType: "NFT"
     *         },
     *         destinationMethod: {
     *             paymentMethodType: "WALLET"
     *         },
     *         buyer: {
     *             type: "PERSON",
     *             id: "id"
     *         }
     *     })
     */
    digitalItemSell(request, requestOptions) {
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b;
            const { ptiRequestId, ptiScenarioId, ptiSessionId, ptiDisableWebhook, ptiProviderName } = request, _body = __rest(request, ["ptiRequestId", "ptiScenarioId", "ptiSessionId", "ptiDisableWebhook", "ptiProviderName"]);
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_b = (_a = (yield core.Supplier.get(this._options.baseUrl))) !== null && _a !== void 0 ? _a : (yield core.Supplier.get(this._options.environment))) !== null && _b !== void 0 ? _b : environments.PTIEnvironment.Default, "transactions/sales"),
                method: "POST",
                headers: Object.assign({ Authorization: yield this._getAuthorizationHeader(), "x-pti-client-id": (yield core.Supplier.get(this._options.ptiClientId)) != null
                        ? serializers.UuidLikeStr.jsonOrThrow(yield core.Supplier.get(this._options.ptiClientId), {
                            unrecognizedObjectKeys: "strip",
                        })
                        : undefined, "X-Fern-Language": "JavaScript", "X-Fern-Runtime": core.RUNTIME.type, "X-Fern-Runtime-Version": core.RUNTIME.version, "x-pti-request-id": serializers.UuidLikeStr.jsonOrThrow(ptiRequestId, {
                        unrecognizedObjectKeys: "strip",
                    }), "x-pti-scenario-id": serializers.UuidLikeStr.jsonOrThrow(ptiScenarioId, {
                        unrecognizedObjectKeys: "strip",
                    }), "x-pti-session-id": ptiSessionId != null
                        ? serializers.UuidLikeStr.jsonOrThrow(ptiSessionId, { unrecognizedObjectKeys: "strip" })
                        : undefined, "x-pti-disable-webhook": ptiDisableWebhook != null ? ptiDisableWebhook.toString() : undefined, "x-pti-provider-name": ptiProviderName != null
                        ? serializers.ProviderName.jsonOrThrow(ptiProviderName, { unrecognizedObjectKeys: "strip" })
                        : undefined }, requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.headers),
                contentType: "application/json",
                requestType: "json",
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
                    throw new errors.PTITimeoutError("Timeout exceeded when calling POST /transactions/sales.");
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
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b;
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_b = (_a = (yield core.Supplier.get(this._options.baseUrl))) !== null && _a !== void 0 ? _a : (yield core.Supplier.get(this._options.environment))) !== null && _b !== void 0 ? _b : environments.PTIEnvironment.Default, `digital-items/${encodeURIComponent(digitalItemId)}`),
                method: "GET",
                headers: Object.assign({ Authorization: yield this._getAuthorizationHeader(), "x-pti-client-id": (yield core.Supplier.get(this._options.ptiClientId)) != null
                        ? serializers.UuidLikeStr.jsonOrThrow(yield core.Supplier.get(this._options.ptiClientId), {
                            unrecognizedObjectKeys: "strip",
                        })
                        : undefined, "X-Fern-Language": "JavaScript", "X-Fern-Runtime": core.RUNTIME.type, "X-Fern-Runtime-Version": core.RUNTIME.version }, requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.headers),
                contentType: "application/json",
                requestType: "json",
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
                    throw new errors.PTITimeoutError("Timeout exceeded when calling GET /digital-items/{digitalItemId}.");
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
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b;
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_b = (_a = (yield core.Supplier.get(this._options.baseUrl))) !== null && _a !== void 0 ? _a : (yield core.Supplier.get(this._options.environment))) !== null && _b !== void 0 ? _b : environments.PTIEnvironment.Default, `digital-items/${encodeURIComponent(digitalItemId)}`),
                method: "DELETE",
                headers: Object.assign({ Authorization: yield this._getAuthorizationHeader(), "x-pti-client-id": (yield core.Supplier.get(this._options.ptiClientId)) != null
                        ? serializers.UuidLikeStr.jsonOrThrow(yield core.Supplier.get(this._options.ptiClientId), {
                            unrecognizedObjectKeys: "strip",
                        })
                        : undefined, "X-Fern-Language": "JavaScript", "X-Fern-Runtime": core.RUNTIME.type, "X-Fern-Runtime-Version": core.RUNTIME.version }, requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.headers),
                contentType: "application/json",
                requestType: "json",
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
                    throw new errors.PTITimeoutError("Timeout exceeded when calling DELETE /digital-items/{digitalItemId}.");
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
    getDigitalItems(userId_1) {
        return __awaiter(this, arguments, void 0, function* (userId, request = {}, requestOptions) {
            var _a, _b;
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
                url: (0, url_join_1.default)((_b = (_a = (yield core.Supplier.get(this._options.baseUrl))) !== null && _a !== void 0 ? _a : (yield core.Supplier.get(this._options.environment))) !== null && _b !== void 0 ? _b : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/digital-items`),
                method: "GET",
                headers: Object.assign({ Authorization: yield this._getAuthorizationHeader(), "x-pti-client-id": (yield core.Supplier.get(this._options.ptiClientId)) != null
                        ? serializers.UuidLikeStr.jsonOrThrow(yield core.Supplier.get(this._options.ptiClientId), {
                            unrecognizedObjectKeys: "strip",
                        })
                        : undefined, "X-Fern-Language": "JavaScript", "X-Fern-Runtime": core.RUNTIME.type, "X-Fern-Runtime-Version": core.RUNTIME.version }, requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.headers),
                contentType: "application/json",
                queryParameters: _queryParams,
                requestType: "json",
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
                    throw new errors.PTITimeoutError("Timeout exceeded when calling GET /users/{userId}/digital-items.");
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
     *             digitalItemType: "NFT"
     *         }, {
     *             itemReference: "57d6467c-6ae0-434f-8197-e7e9f86f2210",
     *             itemTitle: "QB, Mint Condition, #468/500 From Founders Set",
     *             itemDescription: "Ultra Rare Elite Peyton Manning Level 10",
     *             itemUsdValue: 35,
     *             digitalItemType: "NFT"
     *         }])
     */
    createDigitalItems(userId, request, requestOptions) {
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b;
            const _response = yield core.fetcher({
                url: (0, url_join_1.default)((_b = (_a = (yield core.Supplier.get(this._options.baseUrl))) !== null && _a !== void 0 ? _a : (yield core.Supplier.get(this._options.environment))) !== null && _b !== void 0 ? _b : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/digital-items`),
                method: "POST",
                headers: Object.assign({ Authorization: yield this._getAuthorizationHeader(), "x-pti-client-id": (yield core.Supplier.get(this._options.ptiClientId)) != null
                        ? serializers.UuidLikeStr.jsonOrThrow(yield core.Supplier.get(this._options.ptiClientId), {
                            unrecognizedObjectKeys: "strip",
                        })
                        : undefined, "X-Fern-Language": "JavaScript", "X-Fern-Runtime": core.RUNTIME.type, "X-Fern-Runtime-Version": core.RUNTIME.version }, requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.headers),
                contentType: "application/json",
                requestType: "json",
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
                    throw new errors.PTITimeoutError("Timeout exceeded when calling POST /users/{userId}/digital-items.");
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
