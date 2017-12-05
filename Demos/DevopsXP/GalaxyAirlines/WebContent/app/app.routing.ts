import { Router, RouterModule } from '@angular/router';

import { HomeComponent } from './common/home.component';
import { DestinyComponent } from './destiny/destiny.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin.component';
import { NotFoundComponent } from './common/notfound.component';

export const routing = RouterModule.forRoot([
    { path: '', component: HomeComponent },
    { path: 'destiny/:type', component: DestinyComponent },
    { path: 'destiny/find/:query', component: DestinyComponent },
    { path: 'user', component: UserComponent },
    { path: 'admin', component: AdminComponent },
    { path: '**', component: NotFoundComponent }
]);