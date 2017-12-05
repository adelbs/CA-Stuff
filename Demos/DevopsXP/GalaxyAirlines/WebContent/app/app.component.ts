import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfig } from './app.service';

@Component({
  selector: 'my-app',
  templateUrl: 'app/app.template.html',
  providers: [AppConfig]
})
export class AppComponent implements OnInit {
    activeMenu: string = "";
    buildNumber: string = "";

    totalBuildNumberClicks: number = 5;

    constructor(private _router: Router, private _appConfig: AppConfig) { }

    clickMenu(url: string) {
        this.activeMenu = url;
        this._router.navigate([url]);
    }

    isActive(url: string) {
        return this.activeMenu == url;
    }

    adminPage() {
        if (this.totalBuildNumberClicks > 0)
            this.totalBuildNumberClicks--;
        else
            this._router.navigate(["admin"]);
    }

    ngOnInit() {
        this._appConfig.loadConfig().subscribe(data => {
            console.log(data);
            this.buildNumber = data.version;
            AppConfig.endpoint = data.endpoint;
            AppConfig.buildNumber = data.version;
            AppConfig.newImplementation = data.newImplementation;
            AppConfig.errorNewImplementation = data.errorNewImplementation;
        });
        
        resizeWindow();
    }
}
