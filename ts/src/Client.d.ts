import * as environments from "./environments";
import * as core from "./core";
import * as PTI from "./api/index";
import { Authentication } from "./api/resources/authentication/client/Client";
import { Wallets } from "./api/resources/wallets/client/Client";
import { Users } from "./api/resources/users/client/Client";
import { PaymentInformation } from "./api/resources/paymentInformation/client/Client";
import { TransactionAssessment } from "./api/resources/transactionAssessment/client/Client";
import { Transactions } from "./api/resources/transactions/client/Client";
import { Marketplace } from "./api/resources/marketplace/client/Client";
export declare namespace PTIClient {
    interface Options {
        environment?: core.Supplier<environments.PTIEnvironment | string>;
        privateKeyPath: core.Supplier<string>;
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
export declare class PTIClient {
    protected readonly _options: PTIClient.Options;
    constructor(_options: PTIClient.Options);
    protected _authentication: Authentication | undefined;
    get authentication(): Authentication;
    protected _wallets: Wallets | undefined;
    get wallets(): Wallets;
    protected _users: Users | undefined;
    get users(): Users;
    protected _paymentInformation: PaymentInformation | undefined;
    get paymentInformation(): PaymentInformation;
    protected _transactionAssessment: TransactionAssessment | undefined;
    get transactionAssessment(): TransactionAssessment;
    protected _transactions: Transactions | undefined;
    get transactions(): Transactions;
    protected _marketplace: Marketplace | undefined;
    get marketplace(): Marketplace;
}
