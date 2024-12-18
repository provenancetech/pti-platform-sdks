/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export interface ManagedError {
    type: PTI.ErrorType;
    /**
     * # Error codes descriptions
     *
     * NO_ERROR(0)
     * INVALID_REQUEST(1000)
     * MIN_INFO_MISSING(1001)
     * MIN_ASSESSMENT_MISSING(1002)
     * ALREADY_IN_PROGRESS(1003)
     * MISSING_WALLET(1004)
     * WALLETS_DIFFERENT_CURRENCY(1005)
     * WALLETS_SAME_CURRENCY(1006)
     * SOURCE_WALLET_DESTINATION_TOKEN_ONLY(1007)
     * ITEM_USD_VALUE_REQUIRED_WHEN_MULTIPLE_ITEMS(1008)
     * INVALID_USER_TAG(1009)
     * MISSING_TRANSACTION_GROUP_ID(1010)
     * DIFFERENT_BUY_SELL_AMOUNT(1011)
     * DIFFERENT_BUY_SELL_CURRENCIES(1012)
     * NO_INTER_CLIENTS_TRANSFERS(2000)
     * CLIENT_CONFIGURATION_ERROR(2001)
     * UNSUPPORTED_OPERATION(2002)
     * COUNTRY_NOT_SUPPORTED(2003)
     * NOT_ENOUGH_FUNDS(3000)
     * INVALID_ASSET_OWNERSHIP(3001)
     * FEES_WALLET_NOT_FOUND(3002)
     * REVERT_ONLY_CHARGE_BACK(3003)
     * MISSING_CORRESPONDING_BUY_TRANSACTION(3004)
     * ALREADY_EXISTING_CORRESPONDING_TRANSACTION_PAIR(3005)
     * BUY_TRANSACTION_NOT_SETTLED(3006)
     * FIAT_ONLY(3007)
     * SOURCE_DESTINATION_WALLET(3008)
     * INVALID_SOURCE_CURRENCY(3009)
     * INVALID_DESTINATION_CURRENCY(3010)
     * USD_WALLET_ONLY(3011)
     * BANK_ONLY(4000)
     * MISSING_EMAIL_ADDRESS(4001)
     * MISSING_BANK_ACCOUNT_INFORMATION(4002)
     * MISSING_BANK_ACCOUNT_NUMBER_INFORMATION(4003)
     * MISSING_BANK_ACCOUNT_TYPE(4004)
     * MANDATORY_IP_ADDRESS(5000)
     * MANDATORY_EMAIL_ADDRESS(5001)
     * MISSING_CC_INFO(5002)
     * CC_ONLY(5003)
     * UNABLE_TO_PROVIDE_ESTIMATES(6000)
     * FUNDING_FROM_CRYPTO_ONLY(6001)
     * WITHDRAWAL_FROM_WALLET_TO_CRYPTO(6002)
     * SOURCE_WALLET_CURRENCY_DIFFERENT_THAN_DESTINATION_TOKEN_CURRENCY(6003)
     */
    code: number;
}
