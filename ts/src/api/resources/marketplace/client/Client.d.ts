/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as environments from "../../../../environments";
import * as core from "../../../../core";
import * as PTI from "../../../index";
export declare namespace Marketplace {
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
export declare class Marketplace {
    protected readonly _options: Marketplace.Options;
    constructor(_options: Marketplace.Options);
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
     *                 id: "1de3e77b-e673-4e44-8b69-4931364c4e76",
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
    digitalItemBuy(request: PTI.ExecuteBuyTransaction, requestOptions?: Marketplace.RequestOptions): Promise<PTI.ObjectReference>;
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
     *                 id: "c5b2cca7-a1ac-4aad-a461-be8903c695d9",
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
    digitalItemSell(request: PTI.ExecuteSellTransaction, requestOptions?: Marketplace.RequestOptions): Promise<PTI.ObjectReference>;
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
    getDigitalItem(digitalItemId: string, requestOptions?: Marketplace.RequestOptions): Promise<PTI.DigitalItem>;
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
    deleteDigitalItem(digitalItemId: string, requestOptions?: Marketplace.RequestOptions): Promise<void>;
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
    getDigitalItems(userId: string, request?: PTI.GetDigitalItemsRequest, requestOptions?: Marketplace.RequestOptions): Promise<PTI.ObjectReferencePage>;
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
    createDigitalItems(userId: string, request: PTI.DigitalItem[], requestOptions?: Marketplace.RequestOptions): Promise<PTI.ObjectReference[]>;
    protected _getAuthorizationHeader(): Promise<string>;
}
