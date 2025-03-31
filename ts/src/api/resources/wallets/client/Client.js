/**
 * This file was auto-generated by Fern from our API Definition.
 */
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
import * as environments from "../../../../environments";
import * as core from "../../../../core";
import * as PTI from "../../../index";
import urlJoin from "url-join";
import * as serializers from "../../../../serialization/index";
import * as errors from "../../../../errors/index";
export class Wallets {
    constructor(_options) {
        this._options = _options;
    }
    /**
     * @param {Wallets.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.wallets.getListOfAssets()
     */
    getListOfAssets(requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: urlJoin((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, "assets"),
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
                return serializers.wallets.getListOfAssets.Response.parseOrThrow(_response.body, {
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
     * @param {Wallets.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.wallets.getWallets("userId")
     */
    getWallets(userId, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: urlJoin((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/wallets`),
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
                return serializers.wallets.getWallets.Response.parseOrThrow(_response.body, {
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
     * @param {PTI.WalletCreation} request
     * @param {Wallets.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.wallets.createWallet("userId", {
     *         id: "c8768405-6129-4bda-8a10-8ef234dff30e",
     *         currency: PTI.CurrencyEnum.Eth,
     *         network: PTI.BlockChainEnum.Ethereum
     *     })
     */
    createWallet(userId, request, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: urlJoin((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/wallets`),
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
                body: Object.assign(Object.assign({}, serializers.WalletCreation.jsonOrThrow(request, { unrecognizedObjectKeys: "strip" })), { type: "WALLET" }),
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.Wallet.parseOrThrow(_response.body, {
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
     * @param {string} walletId
     * @param {Wallets.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.wallets.getWallet("userId", "walletId")
     */
    getWallet(userId, walletId, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: urlJoin((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/wallets/${encodeURIComponent(walletId)}`),
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
                return serializers.Wallet.parseOrThrow(_response.body, {
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
     * @param {string} walletId
     * @param {Wallets.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.wallets.deleteWallet("userId", "walletId")
     */
    deleteWallet(userId, walletId, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: urlJoin((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/wallets/${encodeURIComponent(walletId)}`),
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
     * @param {string} walletId
     * @param {PTI.SimulatePaymentRequest} request
     * @param {Wallets.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.wallets.simulateWalletPayment("userId", "walletId", {
     *         amount: 100,
     *         paymentMethodType: PTI.PaymentMethodType.Ach
     *     })
     */
    simulateWalletPayment(userId, walletId, request = {}, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: urlJoin((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/wallets/${encodeURIComponent(walletId)}/simulate-payment`),
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
                body: serializers.SimulatePaymentRequest.jsonOrThrow(request, { unrecognizedObjectKeys: "strip" }),
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
     * @param {string} walletId
     * @param {PTI.DepositAddressRequest} request
     * @param {Wallets.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.wallets.createWalletDepositAddress("userId", "walletId")
     */
    createWalletDepositAddress(userId, walletId, request = {}, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: urlJoin((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/wallets/${encodeURIComponent(walletId)}/deposit-address`),
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
                body: serializers.DepositAddressRequest.jsonOrThrow(request, { unrecognizedObjectKeys: "strip" }),
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.Wallet.parseOrThrow(_response.body, {
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
     * @param {string} walletId
     * @param {Record<string, unknown>} request
     * @param {Wallets.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.wallets.createWalletVirtualBankAccount("userId", "walletId", {
     *         "key": "value"
     *     })
     */
    createWalletVirtualBankAccount(userId, walletId, request, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const _response = yield core.fetcher({
                url: urlJoin((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/wallets/${encodeURIComponent(walletId)}/virtual-bank-account`),
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
                body: serializers.wallets.createWalletVirtualBankAccount.Request.jsonOrThrow(request, {
                    unrecognizedObjectKeys: "strip",
                }),
                timeoutMs: (requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.timeoutInSeconds) != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
                maxRetries: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.maxRetries,
                abortSignal: requestOptions === null || requestOptions === void 0 ? void 0 : requestOptions.abortSignal,
            });
            if (_response.ok) {
                return serializers.Wallet.parseOrThrow(_response.body, {
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
     * @param {string} walletId
     * @param {PTI.GetWalletHistoryRequest} request
     * @param {Wallets.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.wallets.getWalletHistory("userId", "walletId")
     */
    getWalletHistory(userId, walletId, request = {}, requestOptions) {
        var _a;
        return __awaiter(this, void 0, void 0, function* () {
            const { page, size } = request;
            const _queryParams = {};
            if (page != null) {
                _queryParams["page"] = page.toString();
            }
            if (size != null) {
                _queryParams["size"] = size.toString();
            }
            const _response = yield core.fetcher({
                url: urlJoin((_a = (yield core.Supplier.get(this._options.environment))) !== null && _a !== void 0 ? _a : environments.PTIEnvironment.Default, `users/${encodeURIComponent(userId)}/wallets/${encodeURIComponent(walletId)}/history`),
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
                return serializers.WalletHistoryPage.parseOrThrow(_response.body, {
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
