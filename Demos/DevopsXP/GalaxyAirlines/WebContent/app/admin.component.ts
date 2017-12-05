import { Component, OnInit } from '@angular/core';
import { DestinyService } from './destiny/destiny.service';
import { AppConfig } from './app.service';

@Component({
    templateUrl: "app/admin.template.html",
    providers: [DestinyService, AppConfig]
})
export class AdminComponent {

    activeTab: string = "endpoint";

    buildNumber: string;
    endpoint: string;
    newImplementation: boolean;
    errorNewImplementation: boolean;

    constructor (private _service: DestinyService, private _appConfig: AppConfig) { }

    ngOnInit() {
        this.buildNumber = AppConfig.buildNumber;
        this.endpoint = AppConfig.endpoint;
        this.newImplementation = AppConfig.newImplementation;
        this.errorNewImplementation = AppConfig.errorNewImplementation;
    }

    createDefaultData() {
        this._service.createDefaultData();
    }

    createTestData() {
        this._service.createTestData();
    }

    clearData() {
        this._service.clearData();
    }

    saveConfig() {
        AppConfig.buildNumber = this.buildNumber;
        AppConfig.endpoint = this.endpoint;
        AppConfig.newImplementation = this.newImplementation;
        AppConfig.errorNewImplementation = this.errorNewImplementation;
        this._appConfig.saveConfig();
    }
}