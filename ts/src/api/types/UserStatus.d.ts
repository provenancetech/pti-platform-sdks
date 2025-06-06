/**
 * This file was auto-generated by Fern from our API Definition.
 */
/**
 * Status of the User. Only ACTIVE Users can appear in API calls.  Calls containing INACTIVE or BLOCKED Users will result in an error.  The status cannot be set via API calls that create or update Users.  If it is passed in User creation or modification calls, it will be silently ignored.
 */
export type UserStatus = "ACTIVE" | "INACTIVE" | "BLOCKED";
export declare const UserStatus: {
    readonly Active: "ACTIVE";
    readonly Inactive: "INACTIVE";
    readonly Blocked: "BLOCKED";
};
