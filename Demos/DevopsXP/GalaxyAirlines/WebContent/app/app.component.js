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
var router_1 = require("@angular/router");
var app_service_1 = require("./app.service");
var AppComponent = (function () {
    function AppComponent(_router, _appConfig) {
        this._router = _router;
        this._appConfig = _appConfig;
        this.activeMenu = "";
        this.buildNumber = "";
        this.totalBuildNumberClicks = 5;
    }
    AppComponent.prototype.clickMenu = function (url) {
        this.activeMenu = url;
        this._router.navigate([url]);
    };
    AppComponent.prototype.isActive = function (url) {
        return this.activeMenu == url;
    };
    AppComponent.prototype.adminPage = function () {
        if (this.totalBuildNumberClicks > 0)
            this.totalBuildNumberClicks--;
        else
            this._router.navigate(["admin"]);
    };
    AppComponent.prototype.ngOnInit = function () {
        var _this = this;
        this._appConfig.loadConfig().subscribe(function (data) {
            console.log(data);
            _this.buildNumber = data.version;
            app_service_1.AppConfig.endpoint = data.endpoint;
            app_service_1.AppConfig.buildNumber = data.version;
            app_service_1.AppConfig.newImplementation = data.newImplementation;
            app_service_1.AppConfig.errorNewImplementation = data.errorNewImplementation;
        });
        resizeWindow();
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'my-app',
        templateUrl: 'app/app.template.html',
        providers: [app_service_1.AppConfig]
    }),
    __metadata("design:paramtypes", [router_1.Router, app_service_1.AppConfig])
], AppComponent);
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map