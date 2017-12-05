import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { AppConfig } from '../app.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class UserService {

    constructor(private _http: Http) { }

}