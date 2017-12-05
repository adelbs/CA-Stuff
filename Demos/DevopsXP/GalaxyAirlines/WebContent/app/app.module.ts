import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent }   from './app.component';
import { HomeComponent } from './common/home.component';
import { DestinyComponent } from './destiny/destiny.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin.component';
import { NotFoundComponent } from './common/notfound.component';

import { routing } from './app.routing';

@NgModule({
  imports:      [ BrowserModule, FormsModule, HttpModule, routing ],
  declarations: [ 
      AppComponent, 
      HomeComponent, 
      DestinyComponent, 
      UserComponent,
      AdminComponent,
      NotFoundComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
