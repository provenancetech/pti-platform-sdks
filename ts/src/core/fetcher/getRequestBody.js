var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
import { RUNTIME } from "../runtime";
export function getRequestBody(body, contentType) {
    return __awaiter(this, void 0, void 0, function* () {
        let requestBody;
        if (RUNTIME.type === "node") {
            if (body instanceof (yield import("formdata-node")).FormData) {
                // @ts-expect-error
                requestBody = body;
            }
            else if (body instanceof (yield import("stream")).Readable) {
                // @ts-expect-error
                requestBody = body;
            }
            else {
                requestBody = maybeStringifyBody(body, contentType !== null && contentType !== void 0 ? contentType : "");
            }
        }
        else {
            if (body instanceof (yield import("form-data")).default) {
                // @ts-expect-error
                requestBody = body;
            }
            else {
                requestBody = maybeStringifyBody(body, contentType !== null && contentType !== void 0 ? contentType : "");
            }
        }
        return requestBody;
    });
}
export const maybeStringifyBody = (requestBody, contentType) => {
    if (requestBody instanceof Uint8Array) {
        return requestBody;
    }
    else if (contentType === "application/x-www-form-urlencoded" && typeof requestBody === "string") {
        return requestBody;
    }
    else {
        return JSON.stringify(requestBody);
    }
};
