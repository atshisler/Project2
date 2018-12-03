import { Component } from '@angular/core';
import { LoginServiceService } from './login-service.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = "Name 'n' Game";
  pass : string;
  email : string;
  user;

  constructor(private _service: LoginServiceService)
  {

  }

  attemptLogin()
  {
    this._service.email = this.email;
    this._service.pass = this.pass;

    this._service.Login().subscribe(data =>
      {
        console.log("hit");
        JSON.stringify(this.user);
        this.user = data;
        console.log(data);
     })
  }
}

