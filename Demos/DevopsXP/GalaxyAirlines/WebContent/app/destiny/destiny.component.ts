import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { DestinyService, Destiny, DestFilter } from './destiny.service';
import { AppConfig } from '../app.service';

@Component({
    templateUrl: 'app/destiny/destiny.template.html',
    providers: [DestinyService]
})
export class DestinyComponent implements OnInit, OnDestroy {

    dests: Destiny[];

    type: string;
    newImplementation: boolean = false;

    routeSubscription;
    destinySubscription;

    constructor(private _router: Router, private _route: ActivatedRoute, private _service: DestinyService) { }

    ngOnInit() {
        this.routeSubscription = this._route.params.subscribe(params => {
            this.type = params["type"];

            if (this.type == undefined) {
                this.loadDestiny({key: "destiny", value: params["query"]});
            }
            else {
                this.loadDestiny({key: "type", value: this.type});
            }
        });

        this.newImplementation = AppConfig.newImplementation;
    }

    loadDestiny(filter: DestFilter) {
        this.destinySubscription = this._service.getDestiny(filter).subscribe(data => {
            console.log(data);
            this.dests = data;
        });
    }

    buyTicket() {
        $("#defModal").modal( "hide" );
        if (AppConfig.errorNewImplementation) {
            this._service.error();
            this._router.navigate(["error"]);
        }
        else {
            setTimeout(function() {
                $("#defModalConfirm").modal( "show" );
            }, 500);
        }
    }

    ngOnDestroy() {
        this.routeSubscription.unsubscribe();
    }

}