import { Component, OnInit } from '@angular/core';

import { UserService } from './user.service';

@Component({
    template: `
        <table class="table">
            <thead>
                <tr>
                    <td>Data</td>
                    <td>Destino</td>
                    <td>Valor</td>
                    <td>Status</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Data</td>
                    <td>Destino</td>
                    <td>Valor</td>
                    <td>Status</td>
                </tr>
            </tbody>
        </table>
    `,
    providers: [UserService]
})
export class UserComponent implements OnInit {

    constructor(private _service: UserService) { }

    ngOnInit() {

    }

}