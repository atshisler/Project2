import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PlatformComponent } from './platform/platform.component';
import { GenreComponent } from './genre/genre.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppRouingModule } from './app-rouing.module';

@NgModule({
  declarations: [
    AppComponent,
    PlatformComponent,
    GenreComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRouingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
