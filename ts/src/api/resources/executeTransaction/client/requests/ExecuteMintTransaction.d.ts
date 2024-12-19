/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../../../../index";
/**
 * @example
 *     {
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
 *     }
 */
export interface ExecuteMintTransaction extends PTI.TransactionType {
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
    destination: PTI.OneOfUserSubTypes;
    destinationMethod: PTI.WalletPaymentMethod;
}
