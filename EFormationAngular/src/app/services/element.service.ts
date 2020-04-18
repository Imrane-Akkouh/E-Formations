import { Injectable } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ElementService {
  constructor(private http: HttpClient, private auth: AuthService) { }

  getFormationElements(formationId: any){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    let params = new HttpParams().set('formationId', formationId);
    return this.http.get('http://localhost:8080/formationElements', { headers, params} );
  }

}
