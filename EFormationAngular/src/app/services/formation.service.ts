import { Injectable } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs';
import { Formation } from '../models/formation.model';
import { Element } from '../models/element.model';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class FormationService {
  constructor(private http: HttpClient, private auth: AuthService) { }

  getFormations(username: string){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    let params = new HttpParams().set('username', username);
    return this.http.get('http://localhost:8080/myFormations', { headers, params} );
  }

  createFormation(formation: Formation, elements: Element[]){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    let params = new HttpParams().set('username', this.auth.getCurrentUser().username);
    return this.http.post('http://localhost:8080/addFormation', 
    {formation_name: formation.formation_name, 
      formateur: formation.formateurId, 
      objectives: formation.objectives,
      pre_requisites: formation.pre_requisites,
      establishment: formation.establishment,
      date: formation.date,
      nb_places: formation.nb_places,
      nb_enrolled: 0,
      elements: elements},{headers, params});
  }
}
