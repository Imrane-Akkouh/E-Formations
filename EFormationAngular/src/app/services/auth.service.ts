import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/user.model';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: User;
  authToken: any;

  constructor(private jwtHelper: JwtHelperService, private http: HttpClient) {
    if(!this.tokenNotExpired()){
      this.logout();
    }
  }


  authenticateUser(username:string, password:string) {

    return this.http.post('http://localhost:8080/authenticate', {username:username, password: password}, { responseType: 'text' as 'json' }).toPromise();
  }

  registerUser(username:string, password:string, role:string) {

    return this.http.post('http://localhost:8080/register', {username: username, password: password, role: role}, { responseType: 'text' as 'json' }).toPromise();
  }



  storeUserData(token: any, user: User) {
    localStorage.setItem('token', token);
    localStorage.setItem('user', JSON.stringify(user));
    this.authToken = token;
    this.user = user;
  }
//   updateUserData(user: any) {
//     localStorage.setItem('user', JSON.stringify(user));
//     this.user = user;
//   }

  isLoggedIn() {
    return this.tokenNotExpired();
  }

  logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    this.authToken = null;
    this.user = null;
  }

  tokenNotExpired() {
    // get the token from the global variable
    let token: string = this.authToken;
    // in case if the user reload the page he gonna lose the variable content so we check the localStorage of the browser
    if (token == null) {
      token = localStorage.getItem('token');
    }
    return token != null && !this.jwtHelper.isTokenExpired(token);
  }
  getToken() {
    return localStorage.getItem('token');
  }
  getCurrentUser() {
    this.user = JSON.parse(localStorage.getItem('user'));
    return this.user;
  }

}
