import { Injectable } from '@angular/core';
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

  getBeneficiaireFormations(){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    return this.http.get('http://localhost:8080/allFormations', { headers} );
  }
  
  createFormation(formation: Formation, elements: any[]){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    return this.http.post('http://localhost:8080/addFormation', 
    {formation_name: formation.formation_name, 
      formateurId: formation.formateurId, 
      objectives: formation.objectives,
      pre_requisites: formation.pre_requisites,
      establishment: formation.establishment,
      date: formation.date,
      nb_places: formation.nb_places,
      nb_enrolled: 0,
      totalPrice: formation.totalPrice,
      elements: elements},{headers});
  }

  getFormation(formationId: string){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    let params = new HttpParams().set('formationId',formationId);
    return this.http.get('http://localhost:8080/getFormation',{headers, params}).toPromise();
  }

  getElements(formationId:string){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    let params = new HttpParams().set('formationId',formationId);
    return this.http.get('http://localhost:8080/formationElements',{headers, params}).toPromise();
  }

  validerFormation(formationId: string){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    let params = new HttpParams().set('formationId',formationId);
    return this.http.get('http://localhost:8080/validateFormation',{headers, params}).toPromise();
  }

  addInscription(formationId: string, elementsId: string[], inscription: any){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    return this.http.post('http://localhost:8080/formationInscription',
    {formationId:formationId,elementsId:elementsId,inscription:inscription},
    {headers}).toPromise();
  }

  getInscription(username: string, formationId: string){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    let params = new HttpParams().set('username',username).set('formation',formationId);
    return this.http.get('http://localhost:8080/getInscription',{headers, params}).toPromise();
  }

  reactivateInscription(username: string, formationId: string){
    let headers = new HttpHeaders().set('Authorization', 'Bearer ' + this.auth.getToken());
    let params = new HttpParams().set('username',username).set('formation',formationId);
    return this.http.get('http://localhost:8080/reactivateInscription',{headers, params}).toPromise();
  }

}
