/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as environments from "../../../../environments";
import * as core from "../../../../core";
import * as PTI from "../../../index";
export declare namespace TransactionAssessment {
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
export declare class TransactionAssessment {
    protected readonly _options: TransactionAssessment.Options;
    constructor(_options: TransactionAssessment.Options);
    /**
     * @param {PTI.TransactionInformationAssessmentRequest} request
     * @param {TransactionAssessment.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactionAssessment.transactionInformationAssessment({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         body: {
     *             transactionGroupId: "c8d8ed2a-33df-463b-95af-e59ff6e16414",
     *             transactionTotal: {
     *                 fee: {
     *                     amount: 10,
     *                     currency: "USD"
     *                 },
     *                 total: {
     *                     amount: 100,
     *                     currency: "USD"
     *                 },
     *                 subtotal: {
     *                     amount: 90,
     *                     currency: "USD"
     *                 }
     *             },
     *             usdValue: 100,
     *             amount: 100,
     *             date: "2024-12-13T18:46:40.666+0000",
     *             initiator: {
     *                 type: "BUSINESS",
     *                 id: "36dbe68f-2747-41c6-8748-559588fd3248",
     *                 sourceOfFunds: "Creator earnings",
     *                 addresses: [{
     *                         streetAddress: "1, main street",
     *                         city: "New Hampshire",
     *                         postalCode: "10005",
     *                         stateCode: "US-NH",
     *                         country: "US",
     *                         default: true
     *                     }],
     *                 emails: [{
     *                         default: true,
     *                         address: "johnsmith@test.com"
     *                     }],
     *                 mainRepresentative: {
     *                     ownershipPercent: 1,
     *                     person: {
     *                         id: "id"
     *                     }
     *                 },
     *                 phones: [{
     *                         default: true,
     *                         number: "12345678901",
     *                         type: "WORK"
     *                     }]
     *             },
     *             type: PTI.TransactionTypeEnum.Deposit,
     *             sourceMethod: {
     *                 paymentMethodType: "CRYPTO",
     *                 billingEmail: "user@example.com",
     *                 paymentInformation: {
     *                     id: "4b573a86-fd3f-475d-a90b-3658f2e79719",
     *                     walletAddress: "walletAddress",
     *                     currency: "currency",
     *                     network: "network"
     *                 }
     *             },
     *             destinationMethod: {
     *                 paymentMethodType: "CRYPTO",
     *                 billingEmail: "user@example.com",
     *                 paymentInformation: {
     *                     id: "3f8d7e96-5d63-49b4-b4a8-42c70ef0cc82",
     *                     walletAddress: "walletAddress",
     *                     currency: "currency",
     *                     network: "network"
     *                 }
     *             }
     *         }
     *     })
     */
    transactionInformationAssessment(request: PTI.TransactionInformationAssessmentRequest, requestOptions?: TransactionAssessment.RequestOptions): Promise<PTI.OneOfAssessmentValidationError>;
    /**
     * This endpoint is used to assess a transaction. The transaction assessment and user information requirement are evaluated. This step is also done when executing a transaction, but it can be called as a standalone.
     *
     * @param {PTI.AssessTransactionRequest} request
     * @param {TransactionAssessment.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactionAssessment.assessTransaction({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         body: {
     *             transactionGroupId: "c8d8ed2a-33df-463b-95af-e59ff6e16414",
     *             transactionTotal: {
     *                 fee: {
     *                     amount: 10,
     *                     currency: "USD"
     *                 },
     *                 total: {
     *                     amount: 100,
     *                     currency: "USD"
     *                 },
     *                 subtotal: {
     *                     amount: 90,
     *                     currency: "USD"
     *                 }
     *             },
     *             usdValue: 100,
     *             amount: 100,
     *             date: "2024-12-13T18:46:40.666+0000",
     *             initiator: {
     *                 type: "BUSINESS",
     *                 id: "36dbe68f-2747-41c6-8748-559588fd3248",
     *                 sourceOfFunds: "Creator earnings",
     *                 addresses: [{
     *                         streetAddress: "1, main street",
     *                         city: "New Hampshire",
     *                         postalCode: "10005",
     *                         stateCode: "US-NH",
     *                         country: "US",
     *                         default: true
     *                     }],
     *                 emails: [{
     *                         default: true,
     *                         address: "johnsmith@test.com"
     *                     }],
     *                 mainRepresentative: {
     *                     ownershipPercent: 1,
     *                     person: {
     *                         id: "id"
     *                     }
     *                 },
     *                 phones: [{
     *                         default: true,
     *                         number: "12345678901",
     *                         type: "WORK"
     *                     }]
     *             },
     *             type: PTI.TransactionTypeEnum.Deposit,
     *             sourceMethod: {
     *                 paymentMethodType: "CRYPTO",
     *                 billingEmail: "user@example.com",
     *                 paymentInformation: {
     *                     id: "4b573a86-fd3f-475d-a90b-3658f2e79719",
     *                     walletAddress: "walletAddress",
     *                     currency: "currency",
     *                     network: "network"
     *                 }
     *             },
     *             destinationMethod: {
     *                 paymentMethodType: "CRYPTO",
     *                 billingEmail: "user@example.com",
     *                 paymentInformation: {
     *                     id: "3f8d7e96-5d63-49b4-b4a8-42c70ef0cc82",
     *                     walletAddress: "walletAddress",
     *                     currency: "currency",
     *                     network: "network"
     *                 }
     *             }
     *         }
     *     })
     */
    assessTransaction(request: PTI.AssessTransactionRequest, requestOptions?: TransactionAssessment.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * @param {PTI.UuidLikeStr} requestId
     * @param {TransactionAssessment.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.transactionAssessment.getTransactionAssess("requestId")
     */
    getTransactionAssess(requestId: PTI.UuidLikeStr, requestOptions?: TransactionAssessment.RequestOptions): Promise<PTI.TransactionAssessStatusObject>;
    protected _getAuthorizationHeader(): Promise<string>;
}