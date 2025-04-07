/**
 * This file was auto-generated by Fern from our API Definition.
 */
export type ErrorType = "NO_ERROR" | "INVALID_REQUEST" | "MIN_INFO_MISSING" | "MIN_ASSESSMENT_MISSING" | "ALREADY_IN_PROGRESS" | "MISSING_WALLET" | "WALLETS_DIFFERENT_CURRENCY" | "WALLETS_SAME_CURRENCY" | "SOURCE_WALLET_DESTINATION_TOKEN_ONLY" | "ITEM_USD_VALUE_REQUIRED_WHEN_MULTIPLE_ITEMS" | "INVALID_USER_TAG" | "MISSING_TRANSACTION_GROUP_ID" | "DIFFERENT_BUY_SELL_AMOUNT" | "DIFFERENT_BUY_SELL_CURRENCIES" | "WALLET_MISSING_NETWORK" | "PAYMENT_METHOD_TYPE_REQUIRED" | "AMOUNT_REQUIRED" | "NO_INTER_CLIENTS_TRANSFERS" | "CLIENT_CONFIGURATION_ERROR" | "UNSUPPORTED_OPERATION" | "COUNTRY_NOT_SUPPORTED" | "UNSUPPORTED_CURRENCY" | "UNSUPPORTED_FIAT_CURRENCY" | "UNSUPPORTED_CRYPTO_CURRENCY" | "UNSUPPORTED_DEPOSIT_ADDRESS" | "INVALID_WALLET_PROVIDER" | "INVALID_WALLET_PROVIDER_CONFIGURATION" | "NOT_ENOUGH_FUNDS" | "INVALID_ASSET_OWNERSHIP" | "FEES_WALLET_NOT_FOUND" | "REVERT_ONLY_CHARGE_BACK" | "MISSING_CORRESPONDING_BUY_TRANSACTION" | "ALREADY_EXISTING_CORRESPONDING_TRANSACTION_PAIR" | "BUY_TRANSACTION_NOT_SETTLED" | "FIAT_ONLY" | "SOURCE_DESTINATION_WALLET" | "INVALID_SOURCE_CURRENCY" | "INVALID_DESTINATION_CURRENCY" | "USD_WALLET_ONLY" | "NON_CORRESPONDING_USERS_FOR_TRANSACTION" | "UNSUPPORTED_SOURCE_METHOD" | "WALLET_REFERENCE_ALREADY_EXISTS" | "UNABLE_TO_DELETE_WALLET_WITH_NONZERO_BALANCE" | "WALLET_DELETED" | "WALLET_LABEL_ALREADY_IN_USE" | "BANK_ONLY" | "MISSING_EMAIL_ADDRESS" | "MISSING_BANK_ACCOUNT_INFORMATION" | "MISSING_BANK_ACCOUNT_NUMBER_INFORMATION" | "MISSING_BANK_ACCOUNT_TYPE" | "FUNDING_FROM_ACH_ONLY" | "WITHDRAWING_FROM_WALLET_ONLY" | "WITHDRAWING_TO_ACH_WIRE_ONLY" | "FUNDING_TO_WALLET_ONLY" | "MANDATORY_IP_ADDRESS" | "MANDATORY_EMAIL_ADDRESS" | "MISSING_CC_INFO" | "CC_ONLY" | "UNABLE_TO_PROVIDE_ESTIMATES" | "FUNDING_FROM_CRYPTO_ONLY" | "WITHDRAWAL_FROM_WALLET_TO_CRYPTO" | "SOURCE_WALLET_CURRENCY_DIFFERENT_THAN_DESTINATION_TOKEN_CURRENCY";
export declare const ErrorType: {
    readonly NoError: "NO_ERROR";
    readonly InvalidRequest: "INVALID_REQUEST";
    readonly MinInfoMissing: "MIN_INFO_MISSING";
    readonly MinAssessmentMissing: "MIN_ASSESSMENT_MISSING";
    readonly AlreadyInProgress: "ALREADY_IN_PROGRESS";
    readonly MissingWallet: "MISSING_WALLET";
    readonly WalletsDifferentCurrency: "WALLETS_DIFFERENT_CURRENCY";
    readonly WalletsSameCurrency: "WALLETS_SAME_CURRENCY";
    readonly SourceWalletDestinationTokenOnly: "SOURCE_WALLET_DESTINATION_TOKEN_ONLY";
    readonly ItemUsdValueRequiredWhenMultipleItems: "ITEM_USD_VALUE_REQUIRED_WHEN_MULTIPLE_ITEMS";
    readonly InvalidUserTag: "INVALID_USER_TAG";
    readonly MissingTransactionGroupId: "MISSING_TRANSACTION_GROUP_ID";
    readonly DifferentBuySellAmount: "DIFFERENT_BUY_SELL_AMOUNT";
    readonly DifferentBuySellCurrencies: "DIFFERENT_BUY_SELL_CURRENCIES";
    readonly WalletMissingNetwork: "WALLET_MISSING_NETWORK";
    readonly PaymentMethodTypeRequired: "PAYMENT_METHOD_TYPE_REQUIRED";
    readonly AmountRequired: "AMOUNT_REQUIRED";
    readonly NoInterClientsTransfers: "NO_INTER_CLIENTS_TRANSFERS";
    readonly ClientConfigurationError: "CLIENT_CONFIGURATION_ERROR";
    readonly UnsupportedOperation: "UNSUPPORTED_OPERATION";
    readonly CountryNotSupported: "COUNTRY_NOT_SUPPORTED";
    readonly UnsupportedCurrency: "UNSUPPORTED_CURRENCY";
    readonly UnsupportedFiatCurrency: "UNSUPPORTED_FIAT_CURRENCY";
    readonly UnsupportedCryptoCurrency: "UNSUPPORTED_CRYPTO_CURRENCY";
    readonly UnsupportedDepositAddress: "UNSUPPORTED_DEPOSIT_ADDRESS";
    readonly InvalidWalletProvider: "INVALID_WALLET_PROVIDER";
    readonly InvalidWalletProviderConfiguration: "INVALID_WALLET_PROVIDER_CONFIGURATION";
    readonly NotEnoughFunds: "NOT_ENOUGH_FUNDS";
    readonly InvalidAssetOwnership: "INVALID_ASSET_OWNERSHIP";
    readonly FeesWalletNotFound: "FEES_WALLET_NOT_FOUND";
    readonly RevertOnlyChargeBack: "REVERT_ONLY_CHARGE_BACK";
    readonly MissingCorrespondingBuyTransaction: "MISSING_CORRESPONDING_BUY_TRANSACTION";
    readonly AlreadyExistingCorrespondingTransactionPair: "ALREADY_EXISTING_CORRESPONDING_TRANSACTION_PAIR";
    readonly BuyTransactionNotSettled: "BUY_TRANSACTION_NOT_SETTLED";
    readonly FiatOnly: "FIAT_ONLY";
    readonly SourceDestinationWallet: "SOURCE_DESTINATION_WALLET";
    readonly InvalidSourceCurrency: "INVALID_SOURCE_CURRENCY";
    readonly InvalidDestinationCurrency: "INVALID_DESTINATION_CURRENCY";
    readonly UsdWalletOnly: "USD_WALLET_ONLY";
    readonly NonCorrespondingUsersForTransaction: "NON_CORRESPONDING_USERS_FOR_TRANSACTION";
    readonly UnsupportedSourceMethod: "UNSUPPORTED_SOURCE_METHOD";
    readonly WalletReferenceAlreadyExists: "WALLET_REFERENCE_ALREADY_EXISTS";
    readonly UnableToDeleteWalletWithNonzeroBalance: "UNABLE_TO_DELETE_WALLET_WITH_NONZERO_BALANCE";
    readonly WalletDeleted: "WALLET_DELETED";
    readonly WalletLabelAlreadyInUse: "WALLET_LABEL_ALREADY_IN_USE";
    readonly BankOnly: "BANK_ONLY";
    readonly MissingEmailAddress: "MISSING_EMAIL_ADDRESS";
    readonly MissingBankAccountInformation: "MISSING_BANK_ACCOUNT_INFORMATION";
    readonly MissingBankAccountNumberInformation: "MISSING_BANK_ACCOUNT_NUMBER_INFORMATION";
    readonly MissingBankAccountType: "MISSING_BANK_ACCOUNT_TYPE";
    readonly FundingFromAchOnly: "FUNDING_FROM_ACH_ONLY";
    readonly WithdrawingFromWalletOnly: "WITHDRAWING_FROM_WALLET_ONLY";
    readonly WithdrawingToAchWireOnly: "WITHDRAWING_TO_ACH_WIRE_ONLY";
    readonly FundingToWalletOnly: "FUNDING_TO_WALLET_ONLY";
    readonly MandatoryIpAddress: "MANDATORY_IP_ADDRESS";
    readonly MandatoryEmailAddress: "MANDATORY_EMAIL_ADDRESS";
    readonly MissingCcInfo: "MISSING_CC_INFO";
    readonly CcOnly: "CC_ONLY";
    readonly UnableToProvideEstimates: "UNABLE_TO_PROVIDE_ESTIMATES";
    readonly FundingFromCryptoOnly: "FUNDING_FROM_CRYPTO_ONLY";
    readonly WithdrawalFromWalletToCrypto: "WITHDRAWAL_FROM_WALLET_TO_CRYPTO";
    readonly SourceWalletCurrencyDifferentThanDestinationTokenCurrency: "SOURCE_WALLET_CURRENCY_DIFFERENT_THAN_DESTINATION_TOKEN_CURRENCY";
};
