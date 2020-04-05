import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient, private auth: AuthService) {

  }

  allUsers() {
    return this.http.get('http://localhost:8080/user/all', { responseType: 'json' });
  }

  getUser(username: string, token: string){
    let params = new HttpParams().set("username",username); //Create new HttpParams
    let headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get('http://localhost:8080/user', {headers, params}).toPromise();
  }
}
