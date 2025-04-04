"use strict";
/**
 * This file was auto-generated by Fern from our API Definition.
 */
Object.defineProperty(exports, "__esModule", { value: true });
exports.PTIError = void 0;
const json_1 = require("../core/json");
class PTIError extends Error {
    constructor({ message, statusCode, body }) {
        super(buildMessage({ message, statusCode, body }));
        Object.setPrototypeOf(this, PTIError.prototype);
        if (statusCode != null) {
            this.statusCode = statusCode;
        }
        if (body !== undefined) {
            this.body = body;
        }
    }
}
exports.PTIError = PTIError;
function buildMessage({ message, statusCode, body, }) {
    let lines = [];
    if (message != null) {
        lines.push(message);
    }
    if (statusCode != null) {
        lines.push(`Status code: ${statusCode.toString()}`);
    }
    if (body != null) {
        lines.push(`Body: ${(0, json_1.toJson)(body, undefined, 2)}`);
    }
    return lines.join("\n");
}
