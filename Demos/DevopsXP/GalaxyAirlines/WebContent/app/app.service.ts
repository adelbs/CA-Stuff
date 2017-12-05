import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class AppConfig {

    private _configEndpoint: string = "http://localhost:8082/DX3/fi/api-config/config";

    constructor(private _http: Http) {
        if (window.location.origin.indexOf("3000") == -1)
            this._configEndpoint = window.location.origin +"/DX3/fi/api-config/config";
    }
    
    public static buildNumber: string = "";

    public static endpoint: string = "";

    public static newImplementation: boolean = false;

    public static errorNewImplementation: boolean = false;

    public loadConfig() {
        return this._http.get(this._configEndpoint).map(data => data.json());
    }

    public saveConfig() {
        this._http.post(this._configEndpoint, 
            '{"version": "'+ AppConfig.buildNumber 
                +'", "endpoint": "'+ AppConfig.endpoint 
                +'", "newImplementation": "'+ AppConfig.newImplementation 
                +'", "errorNewImplementation": "'+ AppConfig.errorNewImplementation +'"}')
            .subscribe(data => console.log(data));
    }


}