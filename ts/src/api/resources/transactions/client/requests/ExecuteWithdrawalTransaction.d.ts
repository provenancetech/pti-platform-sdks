/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../../../../index";
/**
 * @example
 *     {
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
 *     }
 */
export interface ExecuteWithdrawalTransaction extends PTI.TransactionType {
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
    destinationMethod: PTI.OneOfExternalPaymentMethod;
    sourceMethod?: PTI.WalletPaymentMethodWrapper;
}
