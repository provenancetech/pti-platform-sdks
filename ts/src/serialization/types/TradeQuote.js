/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../core";
export const TradeQuote = core.serialization.object({
    estimatedFillPricePerUnit: core.serialization.number().optional(),
    sourceCurrency: core.serialization.string().optional(),
    destinationCurrency: core.serialization.string().optional(),
    amount: core.serialization.number().optional(),
});
