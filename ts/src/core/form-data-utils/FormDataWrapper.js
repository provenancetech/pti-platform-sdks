var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
import { Readable } from "stream";
import { RUNTIME } from "../runtime";
class FormDataRequestBody {
    constructor(fd) {
        this.fd = fd;
    }
    setup() {
        return __awaiter(this, void 0, void 0, function* () {
            if (this.encoder == null && RUNTIME.type === "node") {
                this.encoder = new (yield import("form-data-encoder")).FormDataEncoder(this.fd);
            }
        });
    }
    /**
     * @returns the multipart form data request
     */
    getBody() {
        return __awaiter(this, void 0, void 0, function* () {
            if (RUNTIME.type !== "node") {
                return this.fd;
            }
            else {
                if (this.encoder == null) {
                    yield this.setup();
                }
                return Readable.from(this.encoder);
            }
        });
    }
    /**
     * @returns headers that need to be added to the multipart form data request
     */
    getHeaders() {
        return __awaiter(this, void 0, void 0, function* () {
            if (RUNTIME.type !== "node") {
                return {};
            }
            else {
                if (this.encoder == null) {
                    yield this.setup();
                }
                return this.encoder.headers;
            }
        });
    }
}
/**
 * FormDataWrapper is a utility to make form data
 * requests across both Browser and Node.js runtimes.
 */
export class FormDataWrapper {
    append(name, value) {
        return __awaiter(this, void 0, void 0, function* () {
            if (this.fd == null) {
                if (RUNTIME.type === "node") {
                    this.fd = new (yield import("formdata-node")).FormData();
                }
                else {
                    this.fd = new (yield import("form-data")).default();
                }
            }
            this.fd.append(name, value);
        });
    }
    getRequest() {
        return new FormDataRequestBody(this.fd);
    }
}
