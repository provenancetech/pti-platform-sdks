"use strict";

const fs = require("fs");
const os = require("os");
const path = require("path");

Object.defineProperty(exports, "__esModule", { value: true });
exports.PTIClient = void 0;
const Client_1 = require("./api/resources/authentication/client/Client");
const Client_2 = require("./api/resources/users/client/Client");
const Client_3 = require("./api/resources/wallets/client/Client");
const Client_4 = require("./api/resources/paymentInformation/client/Client");
const Client_5 = require("./api/resources/transactionAssessment/client/Client");
const Client_6 = require("./api/resources/transactions/client/Client");
const Client_7 = require("./api/resources/marketplace/client/Client");
class PTIClient {
    constructor(_options) {
        if (!_options.ptiClientId) {
            throw new Error("PTI client ID is required.")
        }
        if (_options.privateKeyPath) {
            try {
                const realPrivateKeyPath = path.resolve(__dirname, _options.privateKeyPath
                  .replace(/^~\//, os.homedir() + "/")
                  .replace(/^\.\//, process.cwd() + "/"));
                _options.privateKey = fs.readFileSync(realPrivateKeyPath, "utf-8");
            } catch (e) {
                throw new Error("Error reading your private key file. Verify file path is correct and content matches a JWK key.");
            }
        }
        if (!_options.privateKey) {
            throw new Error("Your client private key is required.")
        }
        this._options = _options;
    }
    get getClientOptions() {
        return {
            environment: this._options.environment,
            ptiClientId: this._options.ptiClientId,
            token: this._options.privateKey
        };
    }
    get authentication() {
        var _a;
        return ((_a = this._authentication) !== null && _a !== void 0 ? _a : (this._authentication = new Client_1.Authentication(this.getClientOptions)));
    }
    get users() {
        var _a;
        return ((_a = this._users) !== null && _a !== void 0 ? _a : (this._users = new Client_2.Users(this.getClientOptions)));
    }
    get wallets() {
        var _a;
        return ((_a = this._wallets) !== null && _a !== void 0 ? _a : (this._wallets = new Client_3.Wallets(this.getClientOptions)));
    }
    get paymentInformation() {
        var _a;
        return ((_a = this._paymentInformation) !== null && _a !== void 0 ? _a : (this._paymentInformation = new Client_4.PaymentInformation(this.getClientOptions)));
    }
    get transactionAssessment() {
        var _a;
        return ((_a = this._transactionAssessment) !== null && _a !== void 0 ? _a : (this._transactionAssessment = new Client_5.TransactionAssessment(this.getClientOptions)));
    }
    get transactions() {
        var _a;
        return ((_a = this._transactions) !== null && _a !== void 0 ? _a : (this._transactions = new Client_6.Transactions(this.getClientOptions)));
    }
    get marketplace() {
        var _a;
        return ((_a = this._marketplace) !== null && _a !== void 0 ? _a : (this._marketplace = new Client_7.Marketplace(this.getClientOptions)));
    }
}
exports.PTIClient = PTIClient;
