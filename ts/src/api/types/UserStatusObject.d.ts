/**
 * This file was auto-generated by Fern from our API Definition.
 */
import * as PTI from "../index";
/**
 * Update in the status of a User. You will receive this when the User status changes from the value initially recorded in the system.
 */
export interface UserStatusObject {
    resourceType?: PTI.ResourceType;
    clientId?: PTI.UuidLikeStr;
    userId?: PTI.UuidLikeStr;
    statusReason?: PTI.UserStatusReason;
    status?: PTI.UserStatus;
}
