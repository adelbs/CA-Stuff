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
var app_service_1 = require("../app.service");
require("rxjs/add/operator/map");
var DestinyService = (function () {
    function DestinyService(_http) {
        this._http = _http;
        this._errorEndpoint = "http://localhost:8082/DX3/fi/api/error";
    }
    DestinyService.prototype.getDestiny = function (filter) {
        return this._http.post(app_service_1.AppConfig.endpoint + "/DX3/fi/api/get", JSON.stringify(filter))
            .map(function (data) { return data.json(); });
    };
    DestinyService.prototype.createDefaultData = function () {
        var dests = [
            new Destiny(0, "1-national", "RioDeJaneiro.jpg", "Rio de Janeiro", "desc desc desc", 222, 111),
            new Destiny(0, "1-national", "Manaus.jpg", "Manaus", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "NewYork.jpg", "New York", "desc desc desc", 333, 222)
        ];
        for (var i = 0; i < dests.length; i++)
            this._http.post(app_service_1.AppConfig.endpoint + "/DX3/fi/api/put", JSON.stringify(dests[i])).subscribe(function (data) { return console.log(data); });
    };
    DestinyService.prototype.createTestData = function () {
        var dests = [
            new Destiny(0, "1-national", "AlterDoChao.jpg", "Alter do Chao", "desc desc desc", 222, 111),
            new Destiny(0, "2-international", "Bangkok.jpg", "Bangkok", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "Beirut.jpg", "Beirut", "desc desc desc", 333, 222),
            new Destiny(0, "1-national", "Belem.jpg", "Belem", "desc desc desc", 333, 222),
            new Destiny(0, "1-national", "Brasilia.jpg", "Brasilia", "desc desc desc", 333, 222),
            new Destiny(0, "1-national", "Curitiba.jpg", "Curitiba", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "Dubai.jpg", "Dubai", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "FaroeIsland.jpg", "Ilhas Faroe", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "Lisboa.jpg", "Lisboa", "desc desc desc", 333, 222),
            new Destiny(0, "1-national", "Maceio.jpg", "Maceio", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "Miami.jpg", "Miami", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "Paris.jpg", "Paris", "desc desc desc", 333, 222),
            new Destiny(0, "1-national", "PortoAlegre.jpg", "Porto Alegre", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "Rome.jpg", "Roma", "desc desc desc", 333, 222),
            new Destiny(0, "1-national", "Salvador.jpg", "Salvador", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "Singapura.jpg", "Singapura", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "Tokio.jpg", "Tokio", "desc desc desc", 333, 222)
        ];
        for (var i = 0; i < dests.length; i++)
            this._http.post(app_service_1.AppConfig.endpoint + "/DX3/fi/api/put", JSON.stringify(dests[i])).subscribe(function (data) { return console.log(data); });
    };
    DestinyService.prototype.clearData = function () {
        this._http.get(app_service_1.AppConfig.endpoint + "/DX3/fi/api/clear").subscribe(function (data) { return console.log(data); });
    };
    DestinyService.prototype.error = function () {
        this._http.get(this._errorEndpoint).map(function (data) { return data.json(); }).subscribe(function (data) { return console.log(data); });
    };
    return DestinyService;
}());
DestinyService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [http_1.Http])
], DestinyService);
exports.DestinyService = DestinyService;
var Destiny = (function () {
    function Destiny(id, type, imgUrl, destiny, description, value, points) {
        this.id = id;
        this.type = type;
        this.imgUrl = imgUrl;
        this.destiny = destiny;
        this.description = description;
        this.value = value;
        this.points = points;
    }
    return Destiny;
}());
exports.Destiny = Destiny;
var DestFilter = (function () {
    function DestFilter(key, value) {
        this.key = key;
        this.value = value;
    }
    return DestFilter;
}());
exports.DestFilter = DestFilter;
//# sourceMappingURL=destiny.service.js.map