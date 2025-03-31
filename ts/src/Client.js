import fs from "fs";
import os from "os";
import path from "path";
import { Authentication } from "./api/resources/authentication/client/Client";
import { Users } from "./api/resources/users/client/Client";
import { Wallets } from "./api/resources/wallets/client/Client";
import { PaymentInformation } from "./api/resources/paymentInformation/client/Client";
import { TransactionAssessment } from "./api/resources/transactionAssessment/client/Client";
import { Transactions } from "./api/resources/transactions/client/Client";
import { Marketplace } from "./api/resources/marketplace/client/Client";

export class PTIClient {
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
        return ((_a = this._authentication) !== null && _a !== void 0 ? _a : (this._authentication = new Authentication(this.getClientOptions)));
    }
    get users() {
        var _a;
        return ((_a = this._users) !== null && _a !== void 0 ? _a : (this._users = new Users(this.getClientOptions)));
    }
    get wallets() {
        var _a;
        return ((_a = this._wallets) !== null && _a !== void 0 ? _a : (this._wallets = new Wallets(this.getClientOptions)));
    }
    get paymentInformation() {
        var _a;
        return ((_a = this._paymentInformation) !== null && _a !== void 0 ? _a : (this._paymentInformation = new PaymentInformation(this.getClientOptions)));
    }
    get transactionAssessment() {
        var _a;
        return ((_a = this._transactionAssessment) !== null && _a !== void 0 ? _a : (this._transactionAssessment = new TransactionAssessment(this.getClientOptions)));
    }
    get transactions() {
        var _a;
        return ((_a = this._transactions) !== null && _a !== void 0 ? _a : (this._transactions = new Transactions(this.getClientOptions)));
    }
    get marketplace() {
        var _a;
        return ((_a = this._marketplace) !== null && _a !== void 0 ? _a : (this._marketplace = new Marketplace(this.getClientOptions)));
    }
}
