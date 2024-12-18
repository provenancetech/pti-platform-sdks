/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export interface CryptoPaymentInformation extends PTI.ExternalPaymentInformation {
    /** Blockchain address for the wallet */
    walletAddress: string;
    /** Token symbol that your user is trading */
    currency: string;
    /** Blockchain network name, example ethereum, bitcoin, solana */
    network: string;
    /** If blockchain is a private chain */
    privateBlockchain?: boolean;
    /** key/value map of extra meta data for this payment info, for example, it could be useful to add information to a transaction, like if a subtoken asset is involved */
    clientMeta?: Record<string, unknown>;
}
