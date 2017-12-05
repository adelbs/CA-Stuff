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
var destiny_service_1 = require("./destiny.service");
var app_service_1 = require("../app.service");
var DestinyComponent = (function () {
    function DestinyComponent(_router, _route, _service) {
        this._router = _router;
        this._route = _route;
        this._service = _service;
        this.newImplementation = false;
    }
    DestinyComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.routeSubscription = this._route.params.subscribe(function (params) {
            _this.type = params["type"];
            if (_this.type == undefined) {
                _this.loadDestiny({ key: "destiny", value: params["query"] });
            }
            else {
                _this.loadDestiny({ key: "type", value: _this.type });
            }
        });
        this.newImplementation = app_service_1.AppConfig.newImplementation;
    };
    DestinyComponent.prototype.loadDestiny = function (filter) {
        var _this = this;
        this.destinySubscription = this._service.getDestiny(filter).subscribe(function (data) {
            console.log(data);
            _this.dests = data;
        });
    };
    DestinyComponent.prototype.buyTicket = function () {
        $("#defModal").modal("hide");
        if (app_service_1.AppConfig.errorNewImplementation) {
            this._service.error();
            this._router.navigate(["error"]);
        }
        else {
            setTimeout(function () {
                $("#defModalConfirm").modal("show");
            }, 500);
        }
    };
    DestinyComponent.prototype.ngOnDestroy = function () {
        this.routeSubscription.unsubscribe();
    };
    return DestinyComponent;
}());
DestinyComponent = __decorate([
    core_1.Component({
        templateUrl: 'app/destiny/destiny.template.html',
        providers: [destiny_service_1.DestinyService]
    }),
    __metadata("design:paramtypes", [router_1.Router, router_1.ActivatedRoute, destiny_service_1.DestinyService])
], DestinyComponent);
exports.DestinyComponent = DestinyComponent;
//# sourceMappingURL=destiny.component.js.map