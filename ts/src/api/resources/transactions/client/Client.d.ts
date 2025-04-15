/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as environments from "../../../../environments";
import * as core from "../../../../core";
import * as PTI from "../../../index";
export declare namespace Transactions {
    interface Options {
        environment?: core.Supplier<environments.PTIEnvironment | string>;
        /** Specify a custom URL to connect the client to. */
        baseUrl?: core.Supplier<string>;
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
        /** Additional headers to include in the request. */
        headers?: Record<string, string>;
    }
}
export declare class Transactions {
    protected readonly _options: Transactions.Options;
    constructor(_options: Transactions.Options);
    /**
     * @param {PTI.TradeTransaction} request
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.estimationTransactionCost({
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
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         type: "DEPOSIT",
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
    estimationTransactionCost(request: PTI.TradeTransaction, requestOptions?: Transactions.RequestOptions): Promise<PTI.TradeQuote>;
    /**
     * This endpoint is used to execute a deposit (crypto/fiat -in) transaction for a User. The transaction assessment and User information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteDepositTransaction} request
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.deposit({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         transactionGroupId: "c8d8ed2a-33df-463b-95af-e59ff6e16414",
     *         usdValue: 100,
     *         amount: 100,
     *         date: "2024-12-13T18:46:40.666+0000",
     *         initiator: {
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         type: "DEPOSIT",
     *         sourceMethod: {
     *             paymentMethodType: "CREDIT_CARD"
     *         },
     *         destinationMethod: {
     *             billingEmail: "user@example.com",
     *             paymentInformation: {
     *                 id: "3f8d7e96-5d63-49b4-b4a8-42c70ef0cc82"
     *             },
     *             paymentMethodType: "WALLET"
     *         }
     *     })
     */
    deposit(request: PTI.ExecuteDepositTransaction, requestOptions?: Transactions.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a withdrawal of fiat or crypto transaction for a User. The Transaction Assessment and User information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteWithdrawalTransaction} request
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.withdrawal({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 3999.54,
     *         amount: 1,
     *         date: "date",
     *         initiator: {
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         type: "WITHDRAWAL",
     *         destinationMethod: {
     *             paymentMethodType: "ACH"
     *         },
     *         sourceMethod: {
     *             paymentInformation: {
     *                 id: "a8e99100-f562-4e5b-b86f-9142dc2bc9f0",
     *                 type: "WALLET"
     *             },
     *             paymentMethodType: "WALLET"
     *         }
     *     })
     */
    withdrawal(request: PTI.ExecuteWithdrawalTransaction, requestOptions?: Transactions.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a generic payment of fiat or crypto transaction for a User. The Transaction Assessment and User information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecutePaymentTransaction} request
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.payment({
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
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         clientMeta: {
     *             "paymentMetadata": "collection 1 publication fees"
     *         },
     *         type: "PAYMENT",
     *         sourceMethod: {
     *             paymentMethodType: "CREDIT_CARD"
     *         },
     *         destinationMethod: {
     *             paymentInformation: {
     *                 id: "e13c3242-57d3-473f-b98c-eb2768e4549c",
     *                 type: "WALLET"
     *             },
     *             paymentMethodType: "WALLET"
     *         }
     *     })
     */
    payment(request: PTI.ExecutePaymentTransaction, requestOptions?: Transactions.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a transfer between Users. The Transaction Assessment and User information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteTransferTransaction} request
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.transfer({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 200,
     *         amount: 200,
     *         date: "date",
     *         initiator: {
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         type: "TRANSFER",
     *         sourceTransferMethod: {
     *             paymentInformation: {
     *                 id: "dd2473b7-1afd-4f9c-a359-b4294587fef6",
     *                 type: "WALLET"
     *             },
     *             paymentMethodType: "WALLET"
     *         },
     *         destinationTransferMethod: {
     *             paymentInformation: {
     *                 id: "70cd9757-f288-41e5-8506-5c38b7c819e1",
     *                 type: "WALLET"
     *             },
     *             paymentMethodType: "WALLET"
     *         },
     *         destination: {
     *             type: "PERSON",
     *             id: "id"
     *         }
     *     })
     */
    transfer(request: PTI.ExecuteTransferTransaction, requestOptions?: Transactions.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a Trade between currencies and crypto. The Transaction Assessment and User Information requirement are evaluated before the Transaction is executed.
     *
     * @param {PTI.ExecuteTradeTransaction} request
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.trade({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 113,
     *         amount: 0.5,
     *         date: "date",
     *         initiator: {
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         type: "TRADE",
     *         sourceMethod: {
     *             paymentInformation: {
     *                 id: "MySOLWallet",
     *                 type: "WALLET"
     *             },
     *             paymentMethodType: "WALLET"
     *         },
     *         destinationMethod: {
     *             paymentInformation: {
     *                 id: "MyUSDWallet",
     *                 type: "WALLET"
     *             },
     *             paymentMethodType: "WALLET"
     *         }
     *     })
     */
    trade(request: PTI.ExecuteTradeTransaction, requestOptions?: Transactions.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * This endpoint is used to execute a mint transaction for a User. The Transaction Assessment and User information requirement are evaluated before the transaction is executed.
     *
     * @param {PTI.ExecuteMintTransaction} request
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.mint({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         usdValue: 200,
     *         amount: 0.55,
     *         date: "date",
     *         initiator: {
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         type: "MINT",
     *         destination: {
     *             type: "PERSON",
     *             id: "id"
     *         },
     *         destinationMethod: {
     *             paymentInformation: {
     *                 id: "MyBTCWallet",
     *                 type: "WALLET"
     *             },
     *             paymentMethodType: "WALLET"
     *         }
     *     })
     */
    mint(request: PTI.ExecuteMintTransaction, requestOptions?: Transactions.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * @param {PTI.UuidLikeStr} requestId
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.getTransaction("requestId")
     */
    getTransaction(requestId: PTI.UuidLikeStr, requestOptions?: Transactions.RequestOptions): Promise<PTI.TransactionStatusObject>;
    /**
     * @param {PTI.UuidLikeStr} requestId
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.deleteTransaction("requestId")
     */
    deleteTransaction(requestId: PTI.UuidLikeStr, requestOptions?: Transactions.RequestOptions): Promise<void>;
    /**
     * This endpoint allows adding feedback information to an existing transaction. Here are the possible feedback values with their meaning:
     *
     * | Feedback | Meaning |
     * |----------|---------|
     * | `ACCEPTED` | The transaction was accepted by the processor and is deemed to be in a pending state. This feedback is not a final state and should be followed by antoher feedback such as `SETTLED` or `CANCELLED` |
     * | `SETTLED`  | The transaction was accepted and fully finalized by the processor. The transfer of value has occured. |
     * | `CANCELLED`  | The transaction was accepted but cancelled prior to being settled |
     * | `AWAITING_PAYMENT` | A deposit transaction is being processed and is in a state where it is waiting for the user to complete the payment by funding the target address provided or making a deposit using the specified payment method. |
     * | `REJECTED` | The transaction was declined by the processor |
     * | `REFUNDED` | An intentional, settled transaction was refunded |
     * | `CHARGED_BACK` | A settled transaction was disputed and refunded |
     * | `ERROR` | The processor returned an error, the transaction is assumed to be non existent from the processor standpoint |
     *
     * @param {PTI.UuidLikeStr} requestId - Request ID used when the transaction was initially logged
     * @param {PTI.TransactionUpdate} request
     * @param {Transactions.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactions.provideFeedback("requestId", {
     *         payload: "{}",
     *         providerName: "UNKNOWN",
     *         feedback: "SETTLED",
     *         transactionId: "UUID",
     *         date: "2024-12-13T18:46:40.666+0000"
     *     })
     */
    provideFeedback(requestId: PTI.UuidLikeStr, request: PTI.TransactionUpdate, requestOptions?: Transactions.RequestOptions): Promise<PTI.ObjectReference>;
    protected _getAuthorizationHeader(): Promise<string>;
}
