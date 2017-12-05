import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { AppConfig } from '../app.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class DestinyService {

    private _errorEndpoint: string = "http://localhost:8082/DX3/fi/api/error";

    constructor(private _http: Http) { }

    getDestiny(filter: DestFilter) {
        return this._http.post(AppConfig.endpoint +"/DX3/fi/api/get", JSON.stringify(filter))
            .map(data => data.json());
    }

    createDefaultData() {
        var dests = [
            new Destiny(0, "1-national", "RioDeJaneiro.jpg", "Rio de Janeiro", "desc desc desc", 222, 111),
            new Destiny(0, "1-national", "Manaus.jpg", "Manaus", "desc desc desc", 333, 222),
            new Destiny(0, "2-international", "NewYork.jpg", "New York", "desc desc desc", 333, 222)
        ];

        for (var i = 0; i < dests.length; i++)
            this._http.post(AppConfig.endpoint +"/DX3/fi/api/put", JSON.stringify(dests[i])).subscribe(data => console.log(data));
    }

    createTestData() {
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
            this._http.post(AppConfig.endpoint +"/DX3/fi/api/put", JSON.stringify(dests[i])).subscribe(data => console.log(data));
    }

    clearData() {
        this._http.get(AppConfig.endpoint +"/DX3/fi/api/clear").subscribe(data => console.log(data));
    }

    error() {
        this._http.get(this._errorEndpoint).map(data => data.json()).subscribe(data => console.log(data));
    }

}

export class Destiny {

    constructor(
        public id: number,
        public type: string,
        public imgUrl: string, 
        public destiny: string, 
        public description: string, 
        public value: number, 
        public points: number) { }

}

export class DestFilter {

    constructor (public key: string, public value: string) { }

}
