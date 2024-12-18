/**
 * This file was auto-generated by Fern from our API Definition.
 */
/**
 * Reason explaining why the status is BLOCKED or INACTIVE. Same rules as the `status` field apply.
 */
export declare type UserStatusReason = "FRAUD_SUSPICION" | "BUSINESS_CO_OWNER" | "COMPLIANCE_FLAG" | "HIGH_RISK_IP" | "INFORMATION_MISMATCH" | "HIGH_RISK_EMAIL_DOMAIN" | "UNUSUAL_HIGH_VELOCITY" | "CHARGEBACK";
export declare const UserStatusReason: {
    readonly FraudSuspicion: "FRAUD_SUSPICION";
    readonly BusinessCoOwner: "BUSINESS_CO_OWNER";
    readonly ComplianceFlag: "COMPLIANCE_FLAG";
    readonly HighRiskIp: "HIGH_RISK_IP";
    readonly InformationMismatch: "INFORMATION_MISMATCH";
    readonly HighRiskEmailDomain: "HIGH_RISK_EMAIL_DOMAIN";
    readonly UnusualHighVelocity: "UNUSUAL_HIGH_VELOCITY";
    readonly Chargeback: "CHARGEBACK";
};