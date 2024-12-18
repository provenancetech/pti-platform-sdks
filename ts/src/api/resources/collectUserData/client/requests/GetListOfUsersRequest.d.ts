/**
 * This file was auto-generated by Fern from our API Definition.
 */
/**
 * @example
 *     {}
 */
export interface GetListOfUsersRequest {
    /**
     * Offset for pagination. If not specified, the default value is 0.
     */
    page?: number;
    /**
     * Page size for pagination. If not specified, the default value is 20.
     */
    size?: number;
    /**
     * Sort by field. If not specified, the default value is creation date.
     */
    sortBy?: string;
}
