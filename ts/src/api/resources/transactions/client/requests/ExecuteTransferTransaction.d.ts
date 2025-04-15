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
 *     }
 */
export interface ExecuteTransferTransaction extends PTI.TransactionType {
    /**
     * Unique identifier of the request. This ID must be provided and stored by the client of this API at the creation of a transaction. This ID is attached to all PTI internal operations as well as the webhook calls. This ID is required to post feedback about a transaction and get support from PTI for a problem on a transaction. Creating two transactions having the same requestId is not allowed.
     */
    ptiRequestId: PTI.UuidLikeStr;
    /**
     * Represents a User action under which transaction amounts will accumulated and will control the User Assessment requirements. The values this header can take must be agreed upon and communicated to PTI. Setting unknown values here will generate an error.
     */
    ptiScenarioId: PTI.UuidLikeStr;
    /**
     * Session ID associated to a UI session for a specific User. Should match the value passed to the PTI SDK at initialization.
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
    sourceTransferMethod: PTI.WalletPaymentMethodWrapper;
    destinationTransferMethod: PTI.WalletPaymentMethodWrapper;
    destination: PTI.OneOfUserSubTypes;
    /** Only used for transfers between two different clients. Must be configured before using. */
    destinationClientId?: string;
}
