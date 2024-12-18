/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../../../../index";
/**
 * @example
 *     {
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
 *     }
 */
export interface ExecuteSellTransaction extends PTI.TransactionType {
    /**
     * Unique identifier of the request. This ID must be provided and stored by the client of this API at the creation of a transaction. This ID is attached to all PTI internal operations as well as the webhook calls. This ID is required to post feedback about a transaction and get support from PTI for a problem on a transaction. Creating two transactions having the same requestId is not allowed.
     */
    ptiRequestId: PTI.UuidLikeStr;
    /**
     * Represents a user action under which transaction amounts will accumulated and will control the User assessment requirements. The values this header can take must be agreed upon and communicated to PTI. Setting unknown values here will generate an error.
     */
    ptiScenarioId: PTI.UuidLikeStr;
    /**
     * Session ID associated to a UI session for a specific user. Should match the value passed to the PTI SDK at initialization.
     */
    ptiSessionId?: PTI.UuidLikeStr;
    /**
     * Set to true to disable webhook calls for this request.
     */
    ptiDisableWebhook?: boolean;
    /**
     * Used to specify which provider is responsible for handling the given operation. Ignored if the client configuration is not set for passive mode.
     */
    ptiProviderName?: PTI.ProviderName;
    digitalItem?: PTI.DigitalItem;
    /** One of digitalItem or digitalItems is required */
    digitalItems?: PTI.DigitalItem[];
    destinationMethod: PTI.OneOfPaymentMethod;
    buyer?: PTI.OneOfUserSubTypes;
    feeRecipients?: PTI.FeeRecipient[];
}