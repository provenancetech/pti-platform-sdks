/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export interface DigitalItem {
    /** Reference information about the item, for example could be the contract address of an NFT item. */
    itemReference: string;
    /** The name of the item, for example: ShaggyDog#2 */
    itemTitle: string;
    /** Description about the item, for example: Shaggy Dog Collection is an NFT for Dog lovers. It is a manually generated NFT created on the Ethereum network. */
    itemDescription: string;
    /** Mandatory when more than one item is provided in the payload. The cost of the item being paid by the user, or the estimated value of the item in question. */
    itemUsdValue?: number;
    digitalItemType: PTI.DigitalItemType;
}
