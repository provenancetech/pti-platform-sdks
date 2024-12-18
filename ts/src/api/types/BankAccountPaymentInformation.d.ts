/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
export interface BankAccountPaymentInformation extends PTI.ExternalPaymentInformation {
    /** Valid bank account number, Required for ACH and WIRE */
    bankAccountNumber?: string;
    /** Type of bank account, Required for ACH and WIRE */
    bankAccountType?: PTI.BankAccountPaymentInformationBankAccountType;
    /** Valid bank swift code, Required for International WIRE */
    bankSwiftCode?: string;
    /** Valid bank routing number, between 7 and 12 digits, Required for ACH and WIRE */
    bankRoutingNumber?: string;
    /** Valid bank routing check digit, 1 digit, Required for ACH and WIRE */
    bankRoutingCheckDigit?: string;
    /** Name of the bank of the account, Required for OUTGOING WIRE transactions, persisted as part of the payment information */
    accountBankName?: string;
}
