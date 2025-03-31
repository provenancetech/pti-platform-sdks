/**
 * This file was auto-generated by Fern from our API Definition.
 */
export type ProviderResponseCode = "PTI_TECHNICAL_ERROR" | "PAYMENT_PROVIDER_TECHNICAL_ERROR" | "FRAUD_SUSPICION" | "BLOCKED_COUNTRY" | "AVS_CHECK_FAILED" | "CVV_CHECK_FAILED" | "PAYMENT_INSTRUMENT_PROBLEM" | "PAYMENT_PROVIDER_DECLINED";
export declare const ProviderResponseCode: {
    readonly PtiTechnicalError: "PTI_TECHNICAL_ERROR";
    readonly PaymentProviderTechnicalError: "PAYMENT_PROVIDER_TECHNICAL_ERROR";
    readonly FraudSuspicion: "FRAUD_SUSPICION";
    readonly BlockedCountry: "BLOCKED_COUNTRY";
    readonly AvsCheckFailed: "AVS_CHECK_FAILED";
    readonly CvvCheckFailed: "CVV_CHECK_FAILED";
    readonly PaymentInstrumentProblem: "PAYMENT_INSTRUMENT_PROBLEM";
    readonly PaymentProviderDeclined: "PAYMENT_PROVIDER_DECLINED";
};
