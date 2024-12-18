import * as environments from "./environments";
import * as core from "./core";
import * as PTI from "./api/index";
import { Authorization } from "./api/resources/authorization/client/Client";
import { Wallets } from "./api/resources/wallets/client/Client";
import { CollectUserData } from "./api/resources/collectUserData/client/Client";
import { TransactionAssessment } from "./api/resources/transactionAssessment/client/Client";
import { UserAssessment } from "./api/resources/userAssessment/client/Client";
import { EstimateTransactionCost } from "./api/resources/estimateTransactionCost/client/Client";
import { ExecuteTransaction } from "./api/resources/executeTransaction/client/Client";
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
    protected _authorization: Authorization | undefined;
    get authorization(): Authorization;
    protected _wallets: Wallets | undefined;
    get wallets(): Wallets;
    protected _collectUserData: CollectUserData | undefined;
    get collectUserData(): CollectUserData;
    protected _transactionAssessment: TransactionAssessment | undefined;
    get transactionAssessment(): TransactionAssessment;
    protected _userAssessment: UserAssessment | undefined;
    get userAssessment(): UserAssessment;
    protected _estimateTransactionCost: EstimateTransactionCost | undefined;
    get estimateTransactionCost(): EstimateTransactionCost;
    protected _executeTransaction: ExecuteTransaction | undefined;
    get executeTransaction(): ExecuteTransaction;
    protected _marketplace: Marketplace | undefined;
    get marketplace(): Marketplace;
}
