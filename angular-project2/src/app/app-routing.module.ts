import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PlatformComponent } from './platform/platform.component';
import { GenreComponent } from './genre/genre.component';
import { DashboardComponent } from './dashboard/dashboard.component'
import { ProfileComponent } from './profile/profile.component'
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  { path: 'platform', component: PlatformComponent },
  { path: 'genre', component: GenreComponent},
  { path: 'home', component: DashboardComponent},
  { path: 'profile', component: ProfileComponent},
  { path: 'login', component: LoginComponent} ,
  { path: 'signup', component: SignupComponent},
  { path: 'search', component: SearchComponent},
]


@NgModule({
  
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule]

})
export class AppRoutingModule { }
