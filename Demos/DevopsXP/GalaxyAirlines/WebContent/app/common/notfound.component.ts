import { Component } from '@angular/core';

@Component({
    template: `
        <div style="background-color: #0000FF; color: #FFFFFF;">
            Erro! Area de memoria XD00990FFF33 esta corrompida ou confusa.<br/>
            Unsupported transaction 51.0<br/>
                at java.lang.ClassLoader.defineClass1(Native Method)<br/>
                at java.lang.ClassLoader.defineClassCond(Unknown Source)<br/>
        </div>
    `
})
export class NotFoundComponent {

}