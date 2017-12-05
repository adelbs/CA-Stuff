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
var destiny_service_1 = require("./destiny/destiny.service");
var app_service_1 = require("./app.service");
var AdminComponent = (function () {
    function AdminComponent(_service, _appConfig) {
        this._service = _service;
        this._appConfig = _appConfig;
        this.activeTab = "endpoint";
    }
    AdminComponent.prototype.ngOnInit = function () {
        this.buildNumber = app_service_1.AppConfig.buildNumber;
        this.endpoint = app_service_1.AppConfig.endpoint;
        this.newImplementation = app_service_1.AppConfig.newImplementation;
        this.errorNewImplementation = app_service_1.AppConfig.errorNewImplementation;
    };
    AdminComponent.prototype.createDefaultData = function () {
        this._service.createDefaultData();
    };
    AdminComponent.prototype.createTestData = function () {
        this._service.createTestData();
    };
    AdminComponent.prototype.clearData = function () {
        this._service.clearData();
    };
    AdminComponent.prototype.saveConfig = function () {
        app_service_1.AppConfig.buildNumber = this.buildNumber;
        app_service_1.AppConfig.endpoint = this.endpoint;
        app_service_1.AppConfig.newImplementation = this.newImplementation;
        app_service_1.AppConfig.errorNewImplementation = this.errorNewImplementation;
        this._appConfig.saveConfig();
    };
    return AdminComponent;
}());
AdminComponent = __decorate([
    core_1.Component({
        templateUrl: "app/admin.template.html",
        providers: [destiny_service_1.DestinyService, app_service_1.AppConfig]
    }),
    __metadata("design:paramtypes", [destiny_service_1.DestinyService, app_service_1.AppConfig])
], AdminComponent);
exports.AdminComponent = AdminComponent;
//# sourceMappingURL=admin.component.js.map