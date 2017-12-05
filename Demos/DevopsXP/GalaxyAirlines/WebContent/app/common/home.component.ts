import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    template: `
        <div class="pageContentHome">
            <div class="panel panel-default" style="background-color: transparent;">
                <div class="panel-body" style="padding: 10px;">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            Origem: <input type="text" class="form-control" />
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            Destino: <input type="text" class="form-control" [(ngModel)]="destiny" />
                        </div>
                    </div>
                    <div class="panel-default">
                        <button type="button" class="btn btn-default" style="font-size: 12px;" (click)="find();">
                            <img src="img/tickets.png" width="55px"><br/>Encontrar
                        </button>
                    </div>
                </div>
            </div>
        </div>
    `
})
export class HomeComponent {

    destiny: string = "";

    constructor(private _router: Router) { }

    find() {
        this._router.navigate(["destiny/find/"+ this.destiny]);
    }

}