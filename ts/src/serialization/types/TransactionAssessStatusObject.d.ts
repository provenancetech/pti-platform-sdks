/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as serializers from "../index";
import * as PTI from "../../api/index";
import * as core from "../../core";
import { TransactionAssessStatus } from "./TransactionAssessStatus";
import { TransactionRiskAssessment } from "./TransactionRiskAssessment";
import { TransactionTypeEnum } from "./TransactionTypeEnum";
import { UuidLikeStrTransactionGroup } from "./UuidLikeStrTransactionGroup";
import { TransactionAssessStatusObjectTransactionMonitoringResultDetail } from "./TransactionAssessStatusObjectTransactionMonitoringResultDetail";
import { ActionStatus } from "./ActionStatus";
export declare const TransactionAssessStatusObject: core.serialization.ObjectSchema<serializers.TransactionAssessStatusObject.Raw, PTI.TransactionAssessStatusObject>;
export declare namespace TransactionAssessStatusObject {
    interface Raw extends ActionStatus.Raw {
        assessment?: TransactionAssessStatus.Raw | null;
        risk?: TransactionRiskAssessment.Raw | null;
        amount?: number | null;
        transactionType?: TransactionTypeEnum.Raw | null;
        transactionGroupId?: UuidLikeStrTransactionGroup.Raw | null;
        meta?: Record<string, unknown> | null;
        transactionMonitoringResultDetail?: TransactionAssessStatusObjectTransactionMonitoringResultDetail.Raw | null;
    }
}
