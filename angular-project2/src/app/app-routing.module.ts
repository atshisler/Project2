import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PlatformPageComponent } from './platform-page/platform-page.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  { path: 'platform', component: PlatformPageComponent },
  { path: 'home', component: AppComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]

})
export class AppRoutingModule { }