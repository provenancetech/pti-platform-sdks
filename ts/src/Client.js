"use strict";
const fs = require("fs");
const os = require("os");
const path = require("path");
Object.defineProperty(exports, "__esModule", { value: true });
exports.PTIClient = void 0;
const Client_1 = require("./api/resources/authorization/client/Client");
const Client_2 = require("./api/resources/wallets/client/Client");
const Client_3 = require("./api/resources/collectUserData/client/Client");
const Client_4 = require("./api/resources/transactionAssessment/client/Client");
const Client_5 = require("./api/resources/userAssessment/client/Client");
const Client_6 = require("./api/resources/estimateTransactionCost/client/Client");
const Client_7 = require("./api/resources/executeTransaction/client/Client");
const Client_8 = require("./api/resources/marketplace/client/Client");
class PTIClient {
  constructor(_options) {
    if (!_options.ptiClientId) {
      throw new Error("PTI client ID is required.")
    }
    if (!_options.privateKeyPath) {
      throw new Error("Your client private key path is required.")
    }
    try {
      const realPrivateKeyPath = path.resolve(__dirname, _options.privateKeyPath
        .replace(/^~\//, os.homedir() + "/")
        .replace(/^\.\//, process.cwd() + "/"));
      _options.privateKeyPath = fs.readFileSync(realPrivateKeyPath, "utf-8");
    } catch (e) {
      throw new Error("Error reading your private key file. Verify file path is correct and content matches a JWK key.");
    }
    this._options = _options;
  }
  get authorization() {
    var _a;
    return ((_a = this._authorization) !== null && _a !== void 0 ? _a : (this._authorization = new Client_1
      .Authorization({ environment: this._options.environment, ptiClientId: this._options.ptiClientId, token: this._options.privateKeyPath })));
  }
  get wallets() {
    var _a;
    return ((_a = this._wallets) !== null && _a !== void 0 ? _a : (this._wallets = new Client_2
      .Wallets({ environment: this._options.environment, ptiClientId: this._options.ptiClientId, token: this._options.privateKeyPath })));
  }
  get collectUserData() {
    var _a;
    return ((_a = this._collectUserData) !== null && _a !== void 0 ? _a : (this._collectUserData = new Client_3
      .CollectUserData({ environment: this._options.environment, ptiClientId: this._options.ptiClientId, token: this._options.privateKeyPath })));
  }
  get transactionAssessment() {
    var _a;
    return ((_a = this._transactionAssessment) !== null && _a !== void 0 ? _a : (this._transactionAssessment = new Client_4
      .TransactionAssessment({ environment: this._options.environment, ptiClientId: this._options.ptiClientId, token: this._options.privateKeyPath })));
  }
  get userAssessment() {
    var _a;
    return ((_a = this._userAssessment) !== null && _a !== void 0 ? _a : (this._userAssessment = new Client_5
      .UserAssessment({ environment: this._options.environment, ptiClientId: this._options.ptiClientId, token: this._options.privateKeyPath })));
  }
  get estimateTransactionCost() {
    var _a;
    return ((_a = this._estimateTransactionCost) !== null && _a !== void 0 ? _a : (this._estimateTransactionCost = new Client_6
      .EstimateTransactionCost({ environment: this._options.environment, ptiClientId: this._options.ptiClientId, token: this._options.privateKeyPath })));
  }
  get executeTransaction() {
    var _a;
    return ((_a = this._executeTransaction) !== null && _a !== void 0 ? _a : (this._executeTransaction = new Client_7
      .ExecuteTransaction({ environment: this._options.environment, ptiClientId: this._options.ptiClientId, token: this._options.privateKeyPath })));
  }
  get marketplace() {
    var _a;
    return ((_a = this._marketplace) !== null && _a !== void 0 ? _a : (this._marketplace = new Client_8
      .Marketplace({ environment: this._options.environment, ptiClientId: this._options.ptiClientId, token: this._options.privateKeyPath })));
  }
}
exports.PTIClient = PTIClient;
