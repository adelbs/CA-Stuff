"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
require("rxjs/add/operator/map");
var AppConfig = AppConfig_1 = (function () {
    function AppConfig(_http) {
        this._http = _http;
        this._configEndpoint = "http://localhost:8082/DX3/fi/api-config/config";
        if (window.location.origin.indexOf("3000") == -1)
            this._configEndpoint = window.location.origin + "/DX3/fi/api-config/config";
    }
    AppConfig.prototype.loadConfig = function () {
        return this._http.get(this._configEndpoint).map(function (data) { return data.json(); });
    };
    AppConfig.prototype.saveConfig = function () {
        this._http.post(this._configEndpoint, '{"version": "' + AppConfig_1.buildNumber
            + '", "endpoint": "' + AppConfig_1.endpoint
            + '", "newImplementation": "' + AppConfig_1.newImplementation
            + '", "errorNewImplementation": "' + AppConfig_1.errorNewImplementation + '"}')
            .subscribe(function (data) { return console.log(data); });
    };
    return AppConfig;
}());
AppConfig.buildNumber = "";
AppConfig.endpoint = "";
AppConfig.newImplementation = false;
AppConfig.errorNewImplementation = false;
AppConfig = AppConfig_1 = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], AppConfig);
exports.AppConfig = AppConfig;
var AppConfig_1;
//# sourceMappingURL=app.service.js.map