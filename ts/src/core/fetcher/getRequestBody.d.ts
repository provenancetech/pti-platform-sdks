export declare function getRequestBody(body: any, contentType: string): Promise<BodyInit | undefined>;
export declare const maybeStringifyBody: (requestBody: any, contentType: string) => Uint8Array | string;
