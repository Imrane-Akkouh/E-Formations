import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private Http : HttpClient) {

  }

  allUsers() {
    return this.Http.get('http://localhost:8080/user/all', { responseType: 'json' });
  }
}
