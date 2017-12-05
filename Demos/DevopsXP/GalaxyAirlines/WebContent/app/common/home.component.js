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
var HomeComponent = (function () {
    function HomeComponent(_router) {
        this._router = _router;
        this.destiny = "";
    }
    HomeComponent.prototype.find = function () {
        this._router.navigate(["destiny/find/" + this.destiny]);
    };
    return HomeComponent;
}());
HomeComponent = __decorate([
    core_1.Component({
        template: "\n        <div class=\"pageContentHome\">\n            <div class=\"panel panel-default\" style=\"background-color: transparent;\">\n                <div class=\"panel-body\" style=\"padding: 10px;\">\n                    <div class=\"panel panel-default\">\n                        <div class=\"panel-body\">\n                            Origem: <input type=\"text\" class=\"form-control\" />\n                        </div>\n                    </div>\n                    <div class=\"panel panel-default\">\n                        <div class=\"panel-body\">\n                            Destino: <input type=\"text\" class=\"form-control\" [(ngModel)]=\"destiny\" />\n                        </div>\n                    </div>\n                    <div class=\"panel-default\">\n                        <button type=\"button\" class=\"btn btn-default\" style=\"font-size: 12px;\" (click)=\"find();\">\n                            <img src=\"img/tickets.png\" width=\"55px\"><br/>Encontrar\n                        </button>\n                    </div>\n                </div>\n            </div>\n        </div>\n    "
    }),
    __metadata("design:paramtypes", [router_1.Router])
], HomeComponent);
exports.HomeComponent = HomeComponent;
//# sourceMappingURL=home.component.js.map