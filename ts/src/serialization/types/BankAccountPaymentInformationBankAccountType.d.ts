/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
export declare const BankAccountPaymentInformationBankAccountType: core.serialization.Schema<serializers.BankAccountPaymentInformationBankAccountType.Raw, PTI.BankAccountPaymentInformationBankAccountType>;
export declare namespace BankAccountPaymentInformationBankAccountType {
    type Raw = "CHECKING" | "SAVINGS";
}