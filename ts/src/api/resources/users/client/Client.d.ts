/**
 * This file was auto-generated by Fern from our API Definition.
 */
/// <reference types="node" />
import * as environments from "../../../../environments";
import * as core from "../../../../core";
import * as PTI from "../../../index";
import * as fs from "fs";
export declare namespace Users {
    interface Options {
        environment?: core.Supplier<environments.PTIEnvironment | string>;
        token: core.Supplier<core.BearerToken>;
        /** Override the x-pti-client-id header */
        ptiClientId?: core.Supplier<PTI.UuidLikeStr | undefined>;
    }
    interface RequestOptions {
        /** The maximum time to wait for a response in seconds. */
        timeoutInSeconds?: number;
        /** The number of times to retry the request. Defaults to 2. */
        maxRetries?: number;
        /** A hook to abort the request. */
        abortSignal?: AbortSignal;
        /** Override the x-pti-client-id header */
        ptiClientId?: PTI.UuidLikeStr | undefined;
    }
}
export declare class Users {
    protected readonly _options: Users.Options;
    constructor(_options: Users.Options);
    /**
     * @param {PTI.GetListOfUsersRequest} request
     * @param {Users.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.users.getListOfUsers()
     */
    getListOfUsers(request?: PTI.GetListOfUsersRequest, requestOptions?: Users.RequestOptions): Promise<PTI.UserPage>;
    /**
     * @param {PTI.OneOfUserSubTypes} request
     * @param {Users.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ConflictError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.users.addAUser({
     *         type: "PERSON",
     *         id: "id"
     *     })
     */
    addAUser(request: PTI.OneOfUserSubTypes, requestOptions?: Users.RequestOptions): Promise<PTI.OneOfUserSubTypes>;
    /**
     * @param {PTI.OneOfUserSubTypes} request
     * @param {Users.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.users.updateUser({
     *         type: "PERSON",
     *         id: "id"
     *     })
     */
    updateUser(request: PTI.OneOfUserSubTypes, requestOptions?: Users.RequestOptions): Promise<PTI.OneOfUserSubTypes>;
    /**
     * @param {PTI.OneOfUserSubTypes} request
     * @param {Users.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.users.mergeUserInfo({
     *         type: "PERSON",
     *         id: "id"
     *     })
     */
    mergeUserInfo(request: PTI.OneOfUserSubTypes, requestOptions?: Users.RequestOptions): Promise<PTI.OneOfUserSubTypes>;
    /**
     * This endpoint is used to get the information for a specific User. The information returned is the information that was collected for the User. PII information is not returned.
     *
     * @param {string} userId
     * @param {Users.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.users.getUser("userId")
     */
    getUser(userId: string, requestOptions?: Users.RequestOptions): Promise<PTI.OneOfUserSubTypes>;
    /**
     * This endpoint is used to assess a User. Depending on what information is available on the User,  a tier level will be assigned to the assessment, the higher the level is, the more permission he will get on your platform.  Please refer to PTI documentation for more information on the tier levels configuration and scenarios.
     *
     * @param {PTI.StartUserAssessmentRequest} request
     * @param {Users.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.ForbiddenError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.UnprocessableEntityError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.users.startUserAssessment({
     *         ptiRequestId: "x-pti-request-id",
     *         ptiScenarioId: "x-pti-scenario-id",
     *         body: {
     *             type: "PERSON",
     *             id: "id"
     *         }
     *     })
     */
    startUserAssessment(request: PTI.StartUserAssessmentRequest, requestOptions?: Users.RequestOptions): Promise<PTI.ObjectReference>;
    /**
     * @param {string} userId
     * @param {Users.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.users.getLastKyc("userId")
     */
    getLastKyc(userId: string, requestOptions?: Users.RequestOptions): Promise<PTI.UserAssessStatusObject>;
    /**
     * @param {File | fs.ReadStream | undefined} document
     * @param {string} userId
     * @param {PTI.UploadDocumentRequest} request
     * @param {Users.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @throws {@link PTI.BadRequestError}
     * @throws {@link PTI.UnauthorizedError}
     * @throws {@link PTI.NotFoundError}
     * @throws {@link PTI.TooManyRequestsError}
     *
     * @example
     *     await client.users.uploadDocument(fs.createReadStream("/path/to/your/file"), "userId", {})
     */
    uploadDocument(document: File | fs.ReadStream | undefined, userId: string, request: PTI.UploadDocumentRequest, requestOptions?: Users.RequestOptions): Promise<void>;
    protected _getAuthorizationHeader(): Promise<string>;
}
