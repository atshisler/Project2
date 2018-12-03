import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  private _login: string = 'http://ec2-3-16-11-92.us-east-2.compute.amazonaws.com:8080/name-and-game/user/login'
  email: string = '';
  pass: string = '';
  httpHeader;
  
  constructor(private http: HttpClient) { }
  
  Login()
  {
    this.httpHeader = {headers: new HttpHeaders({'email':this.email, 'password': this.pass})};
    console.log(this.httpHeader.headers.keys());
    return this.http.post(this._login, this.email, this.httpHeader);
  }

}