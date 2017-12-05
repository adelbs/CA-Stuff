"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var router_1 = require("@angular/router");
var home_component_1 = require("./common/home.component");
var destiny_component_1 = require("./destiny/destiny.component");
var user_component_1 = require("./user/user.component");
var admin_component_1 = require("./admin.component");
var notfound_component_1 = require("./common/notfound.component");
exports.routing = router_1.RouterModule.forRoot([
    { path: '', component: home_component_1.HomeComponent },
    { path: 'destiny/:type', component: destiny_component_1.DestinyComponent },
    { path: 'destiny/find/:query', component: destiny_component_1.DestinyComponent },
    { path: 'user', component: user_component_1.UserComponent },
    { path: 'admin', component: admin_component_1.AdminComponent },
    { path: '**', component: notfound_component_1.NotFoundComponent }
]);
//# sourceMappingURL=app.routing.js.map