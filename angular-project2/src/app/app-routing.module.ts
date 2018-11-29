import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PlatformComponent } from './platform/platform.component';
import { GenreComponent } from './genre/genre.component';
import { DashboardComponent } from './dashboard/dashboard.component'
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  { path: 'platform', component: PlatformComponent },
  { path: 'genre', component: GenreComponent},
  { path: 'home', component: DashboardComponent},
  { path: 'search', component: SearchComponent},
]


@NgModule({
  
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule]

})
export class AppRoutingModule { }
