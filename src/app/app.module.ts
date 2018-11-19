import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { PlatformPageComponent } from './platform-page/platform-page.component';
import { GenrePageComponent } from './genre-page/genre-page.component';

@NgModule({
  declarations: [
    AppComponent,
    PlatformPageComponent,
    GenrePageComponent
  ],
  imports: [
    BrowserModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
export class YourAppModule{
  
}