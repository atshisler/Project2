import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PlatformComponent } from './platform/platform.component';
import { GenreComponent } from './genre/genre.component';
import { DashboardComponent } from './dashboard/dashboard.component'
import { SearchComponent } from './search/search.component';
import { SignupComponent } from './signup/signup.component'



const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch:'full'},
  { path: 'platform', component: PlatformComponent },
  { path: 'genre', component: GenreComponent},
  { path: 'home', component: DashboardComponent},
  { path: 'search', component: SearchComponent},
  { path: 'signup', component: SignupComponent}
]


@NgModule({
  
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule]

})
export class AppRoutingModule { }
