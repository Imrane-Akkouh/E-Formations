import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: any;
  authToken: any;

  constructor(private jwtHelper: JwtHelperService, private http: HttpClient) { }


  authenticateUser(user: any) {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');

    return this.http.post('http://localhost:8080/users/authenticate', user, { headers });
  }

  storeUserData(token: any, user: any) {
    localStorage.setItem('token', token);
    localStorage.setItem('user', JSON.stringify(user));
    this.authToken = token;
    this.user = user;
  }
  updateUserData(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
    this.user = user;
  }

  loggedIn() {
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
