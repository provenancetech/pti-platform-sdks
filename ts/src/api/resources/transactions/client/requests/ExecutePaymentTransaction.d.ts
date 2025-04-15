/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../../../../index";
/**
 * @example
 *     {
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
 *     }
 */
export interface ExecutePaymentTransaction extends PTI.TransactionType {
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
    sourceMethod: PTI.OneOfPaymentMethod;
    destinationMethod?: PTI.WalletPaymentMethodWrapper;
}
