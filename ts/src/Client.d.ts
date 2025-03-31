import * as environments from "./environments";
import * as core from "./core";
import * as PTI from "./api/index";
import { Authentication } from "./api/resources/authentication/client/Client";
import { Users } from "./api/resources/users/client/Client";
import { Wallets } from "./api/resources/wallets/client/Client";
import { PaymentInformation } from "./api/resources/paymentInformation/client/Client";
import { TransactionAssessment } from "./api/resources/transactionAssessment/client/Client";
import { Transactions } from "./api/resources/transactions/client/Client";
import { Marketplace } from "./api/resources/marketplace/client/Client";
export declare namespace PTIClient {
    interface Options {
        environment?: core.Supplier<environments.PTIEnvironment | string>;
        privateKeyPath?: core.Supplier<string>;
        privateKey?: core.Supplier<string>;
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
export declare class PTIClient {
    protected readonly _options: PTIClient.Options;
    protected _authentication: Authentication | undefined;
    protected _users: Users | undefined;
    protected _wallets: Wallets | undefined;
    protected _paymentInformation: PaymentInformation | undefined;
    protected _transactionAssessment: TransactionAssessment | undefined;
    protected _transactions: Transactions | undefined;
    protected _marketplace: Marketplace | undefined;
    constructor(_options: PTIClient.Options);
    get authentication(): Authentication;
    get users(): Users;
    get wallets(): Wallets;
    get paymentInformation(): PaymentInformation;
    get transactionAssessment(): TransactionAssessment;
    get transactions(): Transactions;
    get marketplace(): Marketplace;
}
