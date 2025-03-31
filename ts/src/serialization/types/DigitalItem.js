/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as core from "../../core";
import { UuidLikeStr } from "./UuidLikeStr";
import { DigitalItemType } from "./DigitalItemType";
export const DigitalItem = core.serialization.object({
    id: UuidLikeStr.optional(),
    itemReference: core.serialization.string(),
    itemTitle: core.serialization.string(),
    itemDescription: core.serialization.string(),
    itemUsdValue: core.serialization.property("itemUSDValue", core.serialization.number().optional()),
    digitalItemType: DigitalItemType,
});
