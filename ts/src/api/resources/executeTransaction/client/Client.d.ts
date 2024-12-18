/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as environments from "../../../../environments";
import * as core from "../../../../core";
import * as PTI from "../../../index";
export declare namespace ExecuteTransaction {
    interface Options {
        environment?: core.Supplier<environments.PTIEnvironment | string>;
        token: core.Supplier<core.BearerToken>;
        /** Override the x-pti-client-id header */
        ptiClientId?: core.Supplier<PTI.UuidLikeStr | undefined>;
    }
    interface RequestOptions {
        /** The maximum time to wait for a response in seconds. */
        timeoutInSeconds?: number;
        /** The number of times to retry the request. Defaults to 2. */
        maxRetries?: number;
        /** A hook to abort the request. */
        abortSignal?: AbortSignal;
        /** Override the x-pti-client-id header */
        ptiClientId?: PTI.UuidLikeStr | undefined;
    }
}
export declare class ExecuteTransaction {
    protected readonly _options: ExecuteTransaction.Options;
    constructor(_options: ExecuteTransaction.Options);
    /**
     * This endpoint is used to execute a deposit (crypto/fiat -in) transaction for a user. The transaction assessment and user information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteDepositTransaction} request
     * @param {ExecuteTransaction.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.executeTransaction.deposit({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         transactionGroupId: "c8d8ed2a-33df-463b-95af-e59ff6e16414",
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
     *         sourceMethod: {
     *             paymentMethodType: "CRYPTO",
     *             billingEmail: "user@example.com",
     *             paymentInformation: {
     *                 id: "4b573a86-fd3f-475d-a90b-3658f2e79719",
     *                 walletAddress: "walletAddress",
     *                 currency: "currency",
     *                 network: "network"
     *             }
     *         },
     *         destinationMethod: {
     *             billingEmail: "user@example.com"
     *         }
     *     })
     */
    deposit(request: PTI.ExecuteDepositTransaction, requestOptions?: ExecuteTransaction.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a withdrawal of fiat or crypto transaction for a user. The transaction assessment and user information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteWithdrawalTransaction} request
     * @param {ExecuteTransaction.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.executeTransaction.withdrawal({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 3999.54,
     *         amount: 1,
     *         date: "date",
     *         initiator: {
     *             type: "BUSINESS",
     *             id: "initiator",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         },
     *         type: PTI.TransactionTypeEnum.Withdrawal,
     *         destinationMethod: {
     *             paymentMethodType: "CRYPTO",
     *             paymentInformation: {
     *                 walletAddress: "walletAddress",
     *                 currency: "currency",
     *                 network: "network"
     *             }
     *         },
     *         sourceMethod: {
     *             paymentInformation: {
     *                 walletId: "a8e99100-f562-4e5b-b86f-9142dc2bc9f0",
     *                 type: "WALLET"
     *             }
     *         }
     *     })
     */
    withdrawal(request: PTI.ExecuteWithdrawalTransaction, requestOptions?: ExecuteTransaction.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a generic payment of fiat or crypto transaction for a user. The transaction assessment and user information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecutePaymentTransaction} request
     * @param {ExecuteTransaction.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.executeTransaction.payment({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         transactionTotal: {
     *             fee: {
     *                 amount: 0,
     *                 currency: "USD"
     *             },
     *             total: {
     *                 amount: 6.99,
     *                 currency: "USD"
     *             },
     *             subtotal: {
     *                 amount: 6.99,
     *                 currency: "USD"
     *             }
     *         },
     *         usdValue: 6.99,
     *         amount: 6.99,
     *         date: "date",
     *         initiator: {
     *             type: "BUSINESS",
     *             id: "initiator",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         },
     *         clientMeta: {
     *             "paymentMetadata": "collection 1 publication fees"
     *         },
     *         type: PTI.TransactionTypeEnum.Payment,
     *         sourceMethod: {
     *             paymentMethodType: "CRYPTO",
     *             paymentInformation: {
     *                 id: "79a0da5f-d24b-4ed8-a194-f8e0db32cf05",
     *                 walletAddress: "walletAddress",
     *                 currency: "currency",
     *                 network: "network"
     *             }
     *         },
     *         destinationMethod: {
     *             paymentInformation: {
     *                 walletId: "e13c3242-57d3-473f-b98c-eb2768e4549c",
     *                 type: "WALLET"
     *             }
     *         }
     *     })
     */
    payment(request: PTI.ExecutePaymentTransaction, requestOptions?: ExecuteTransaction.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a transfer between users. The transaction assessment and user information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteTransferTransaction} request
     * @param {ExecuteTransaction.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.executeTransaction.transfer({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 200,
     *         amount: 200,
     *         date: "date",
     *         initiator: {
     *             type: "BUSINESS",
     *             id: "initiator",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         },
     *         type: PTI.TransactionTypeEnum.Transfer,
     *         sourceTransferMethod: {
     *             paymentInformation: {
     *                 walletId: "dd2473b7-1afd-4f9c-a359-b4294587fef6",
     *                 type: "WALLET"
     *             }
     *         },
     *         destinationTransferMethod: {
     *             paymentInformation: {
     *                 walletId: "70cd9757-f288-41e5-8506-5c38b7c819e1",
     *                 type: "WALLET"
     *             }
     *         },
     *         destination: {
     *             type: "BUSINESS",
     *             id: "destination",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         }
     *     })
     */
    transfer(request: PTI.ExecuteTransferTransaction, requestOptions?: ExecuteTransaction.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a trade between currencies and crypto. The transaction assessment and user information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteTradeTransaction} request
     * @param {ExecuteTransaction.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.executeTransaction.trade({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 113,
     *         amount: 0.5,
     *         date: "date",
     *         initiator: {
     *             type: "BUSINESS",
     *             id: "initiator",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         },
     *         type: PTI.TransactionTypeEnum.Trade,
     *         sourceMethod: {
     *             paymentInformation: {
     *                 walletId: "MySOLWallet",
     *                 type: "WALLET"
     *             }
     *         },
     *         destinationMethod: {
     *             paymentInformation: {
     *                 walletId: "MyUSDWallet",
     *                 type: "WALLET"
     *             }
     *         }
     *     })
     */
    trade(request: PTI.ExecuteTradeTransaction, requestOptions?: ExecuteTransaction.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a mint transaction for a user. The transaction assessment and user information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteMintTransaction} request
     * @param {ExecuteTransaction.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.executeTransaction.mint({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 200,
     *         amount: 0.55,
     *         date: "date",
     *         initiator: {
     *             type: "BUSINESS",
     *             id: "initiator",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         },
     *         type: PTI.TransactionTypeEnum.Mint,
     *         destination: {
     *             type: "BUSINESS",
     *             id: "36dbe68f-2747-41c6-8748-559588fd3248",
     *             mainRepresentative: {
     *                 ownershipPercent: 1,
     *                 person: {
     *                     id: "id"
     *                 }
     *             }
     *         },
     *         destinationMethod: {
     *             paymentInformation: {
     *                 walletId: "MyBTCWallet",
     *                 type: "WALLET"
     *             }
     *         }
     *     })
     */
    mint(request: PTI.ExecuteMintTransaction, requestOptions?: ExecuteTransaction.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * @param {PTI.UuidLikeStr} requestId
     * @param {ExecuteTransaction.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.executeTransaction.getTransaction("requestId")
     */
    getTransaction(requestId: PTI.UuidLikeStr, requestOptions?: ExecuteTransaction.RequestOptions): Promise<PTI.TransactionStatusObject>;
    /**
     * @param {PTI.UuidLikeStr} requestId
     * @param {ExecuteTransaction.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.executeTransaction.deleteTransaction("requestId")
     */
    deleteTransaction(requestId: PTI.UuidLikeStr, requestOptions?: ExecuteTransaction.RequestOptions): Promise<void>;
    /**
     * This endpoint allows adding feedback information to an existing transaction. Here are the possible feedback values with their meaning:
     *
     * | Feedback           | Meaning                                                                                                                                                                                                            |
     * | ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
     * | `ACCEPTED`         | The transaction was accepted by the processor and is deemed to be in a pending state. This feedback is not a final state and should be followed by antoher feedback such as `SETTLED` or `CANCELLED`               |
     * | `SETTLED`          | The transaction was accepted and fully finalized by the processor. The transfer of value has occured.                                                                                                              |
     * | `CANCELLED`        | The transaction was accepted but cancelled prior to being settled                                                                                                                                                  |
     * | `AWAITING_PAYMENT` | A deposit transaction is being processed and is in a state where it is waiting for the user to complete the payment by funding the target address provided or making a deposit using the specified payment method. |
     * | `REJECTED`         | The transaction was declined by the processor                                                                                                                                                                      |
     * | `REFUNDED`         | An intentional, settled transaction was refunded                                                                                                                                                                   |
     * | `CHARGED_BACK`     | A settled transaction was disputed and refunded                                                                                                                                                                    |
     * | `ERROR`            | The processor returned an error, the transaction is assumed to be non existent from the processor standpoint                                                                                                       |
     *
     * @param {PTI.UuidLikeStr} requestId - Request ID used when the transaction was initially logged
     * @param {PTI.TransactionUpdate} request
     * @param {ExecuteTransaction.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.executeTransaction.provideFeedback("requestId", {
     *         payload: "{}",
     *         providerName: PTI.TransactionUpdateProviderName.Unknown,
     *         feedback: PTI.TransactionUpdateFeedback.Settled,
     *         transactionId: "UUID",
     *         date: "2024-12-13T18:46:40.666+0000"
     *     })
     */
    provideFeedback(requestId: PTI.UuidLikeStr, request: PTI.TransactionUpdate, requestOptions?: ExecuteTransaction.RequestOptions): Promise<PTI.ObjectReference>;
    protected _getAuthorizationHeader(): Promise<string>;
}