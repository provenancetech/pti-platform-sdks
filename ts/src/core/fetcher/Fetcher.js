import crypto from "crypto";
import { JWK, JWS, util } from "node-jose";

var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};

import { toJson } from "../json";
import { createRequestUrl } from "./createRequestUrl";
import { getFetchFn } from "./getFetchFn";
import { getRequestBody } from "./getRequestBody";
import { getResponseBody } from "./getResponseBody";
import { makeRequest } from "./makeRequest";
import { requestWithRetries } from "./requestWithRetries";

/** Custom code section **/

function getContentSha256(dataBuffer) {
    const hash = crypto.createHash("sha256");
    hash.update(dataBuffer);
    return hash.digest("hex").toUpperCase();
}

function* signPayload(clientId, key, payload) {
    const publicJWK = yield JWK.asKey(key.toJSON());
    const jwkThumbprintBuffer = yield publicJWK.thumbprint("SHA-256");
    const thumbprint = util.base64url.encode(jwkThumbprintBuffer, "utf8");
    return yield JWS.createSign({ format: "compact", fields: { alg: "RS512", kid: thumbprint, cid: clientId } }, key)
      .update(payload, "utf8")
      .final()
      .then((signature) => signature.toString());
}

function* buildSignature(clientId, key, url, method, data, date) {
    let payload = `${method}\n`;
    if (["POST", "PUT", "PATCH"].includes(method)) {
        payload += `${getContentSha256(Buffer.from(data ? JSON.stringify(data) : ""))}\n`;
        payload += "content-type:application/json; charset=utf-8\n";
    } else {
        payload += "\n\n";
    }
    payload += `date:${date}\n`;
    payload += `x-pti-client-id:${clientId}\n`;
    payload += new URL(url).pathname;
    return yield* signPayload(clientId, key, payload);
}

function* buildCustomHeaders(args, url, headers) {
    const date = new Date().toUTCString();
    try {
        const jwkKey = yield JWK.asKey(JSON.parse(args.headers["Authorization"].substring(7)));
        headers["Date"] = date;
        headers["x-pti-role"] = "CLIENT"
        headers["x-pti-signature"] = yield* buildSignature(args.headers["x-pti-client-id"], jwkKey, url, args.method, args.body, date)
        delete headers["Authorization"]
    } catch (e) {
        throw new Error(`Error building signature: ${e.message}`);
    }
}

/** End of custom code section **/

export function fetcherImpl(args) {
    return __awaiter(this, void 0, void 0, function* () {
        const headers = {};
        if (args.body !== undefined && args.contentType != null) {
            headers["Content-Type"] = args.contentType;
        }
        if (args.headers != null) {
            for (const [key, value] of Object.entries(args.headers)) {
                if (value != null) {
                    headers[key] = value;
                }
            }
        }
        const url = createRequestUrl(args.url, args.queryParameters);
        const requestBody = yield getRequestBody({
            body: args.body,
            type: args.requestType === "json" ? "json" : "other",
        });

        // Build our custom auth headers
        yield* buildCustomHeaders(args, url, headers);

        const fetchFn = yield getFetchFn();
        try {
            const response = yield requestWithRetries(() => __awaiter(this, void 0, void 0, function* () {
                return makeRequest(fetchFn, url, args.method, headers, requestBody, args.timeoutMs, args.abortSignal, args.withCredentials, args.duplex);
            }), args.maxRetries);
            const responseBody = yield getResponseBody(response, args.responseType);
            if (response.status >= 200 && response.status < 400) {
                return {
                    ok: true,
                    body: responseBody,
                    headers: response.headers,
                };
            }
            else {
                return {
                    ok: false,
                    error: {
                        reason: "status-code",
                        statusCode: response.status,
                        body: responseBody,
                    },
                };
            }
        }
        catch (error) {
            if (args.abortSignal != null && args.abortSignal.aborted) {
                return {
                    ok: false,
                    error: {
                        reason: "unknown",
                        errorMessage: "The user aborted a request",
                    },
                };
            }
            else if (error instanceof Error && error.name === "AbortError") {
                return {
                    ok: false,
                    error: {
                        reason: "timeout",
                    },
                };
            }
            else if (error instanceof Error) {
                return {
                    ok: false,
                    error: {
                        reason: "unknown",
                        errorMessage: error.message,
                    },
                };
            }
            return {
                ok: false,
                error: {
                    reason: "unknown",
                    errorMessage: toJson(error),
                },
            };
        }
    });
}
export const fetcher = fetcherImpl;
