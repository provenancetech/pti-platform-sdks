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
function isNamedValue(value) {
    return typeof value === "object" && value != null && "name" in value;
}
export function newFormData() {
    return __awaiter(this, void 0, void 0, function* () {
        let formdata;
        if (RUNTIME.type === "node" && RUNTIME.parsedVersion != null && RUNTIME.parsedVersion >= 18) {
            formdata = new Node18FormData();
        }
        else if (RUNTIME.type === "node") {
            formdata = new Node16FormData();
        }
        else {
            formdata = new WebFormData();
        }
        yield formdata.setup();
        return formdata;
    });
}
/**
 * Form Data Implementation for Node.js 18+
 */
export class Node18FormData {
    setup() {
        return __awaiter(this, void 0, void 0, function* () {
            this.fd = new (yield import("formdata-node")).FormData();
        });
    }
    append(key, value) {
        var _a;
        (_a = this.fd) === null || _a === void 0 ? void 0 : _a.append(key, value);
    }
    appendFile(key, value, fileName) {
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b;
            if (fileName == null && isNamedValue(value)) {
                fileName = value.name;
            }
            if (value instanceof Blob) {
                (_a = this.fd) === null || _a === void 0 ? void 0 : _a.append(key, value, fileName);
            }
            else {
                (_b = this.fd) === null || _b === void 0 ? void 0 : _b.append(key, {
                    type: undefined,
                    name: fileName,
                    [Symbol.toStringTag]: "File",
                    stream() {
                        return value;
                    },
                });
            }
        });
    }
    getRequest() {
        return __awaiter(this, void 0, void 0, function* () {
            const encoder = new (yield import("form-data-encoder")).FormDataEncoder(this.fd);
            return {
                body: (yield import("readable-stream")).Readable.from(encoder),
                headers: encoder.headers,
                duplex: "half",
            };
        });
    }
}
/**
 * Form Data Implementation for Node.js 16-18
 */
export class Node16FormData {
    setup() {
        return __awaiter(this, void 0, void 0, function* () {
            this.fd = new (yield import("form-data")).default();
        });
    }
    append(key, value) {
        var _a;
        (_a = this.fd) === null || _a === void 0 ? void 0 : _a.append(key, value);
    }
    appendFile(key, value, fileName) {
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b;
            if (fileName == null && isNamedValue(value)) {
                fileName = value.name;
            }
            let bufferedValue;
            if (value instanceof Blob) {
                bufferedValue = Buffer.from(yield value.arrayBuffer());
            }
            else {
                bufferedValue = value;
            }
            if (fileName == null) {
                (_a = this.fd) === null || _a === void 0 ? void 0 : _a.append(key, bufferedValue);
            }
            else {
                (_b = this.fd) === null || _b === void 0 ? void 0 : _b.append(key, bufferedValue, { filename: fileName });
            }
        });
    }
    getRequest() {
        return {
            body: this.fd,
            headers: this.fd ? this.fd.getHeaders() : {},
        };
    }
}
/**
 * Form Data Implementation for Web
 */
export class WebFormData {
    setup() {
        return __awaiter(this, void 0, void 0, function* () {
            this.fd = new FormData();
        });
    }
    append(key, value) {
        var _a;
        (_a = this.fd) === null || _a === void 0 ? void 0 : _a.append(key, value);
    }
    appendFile(key, value, fileName) {
        return __awaiter(this, void 0, void 0, function* () {
            var _a, _b;
            if (fileName == null && isNamedValue(value)) {
                fileName = value.name;
            }
            if (value instanceof Blob) {
                (_a = this.fd) === null || _a === void 0 ? void 0 : _a.append(key, value, fileName);
                return;
            }
            (_b = this.fd) === null || _b === void 0 ? void 0 : _b.append(key, new Blob([value]), fileName);
        });
    }
    getRequest() {
        return {
            body: this.fd,
            headers: {},
        };
    }
}
