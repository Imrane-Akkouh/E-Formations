import { Component, OnInit } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { ElementService } from 'src/app/services/element.service';
import { Router } from '@angular/router';
import { Formation } from 'src/app/models/formation.model';
import { Element } from 'src/app/models/element.model';
import { FormationService } from 'src/app/services/formation.service';
import { Inscription } from 'src/app/models/inscription.model';

@Component({
  selector: 'app-formation-elements',
  templateUrl: './formation-elements.component.html',
  styleUrls: ['./formation-elements.component.css']
})
export class FormationElementsComponent implements OnInit {
  formation: Formation;
  elements: Element[];
  elementsId: string[] = [];
  email: string = '';
  address: string = '';
  phone: string = '';
  popup: boolean = false;
  selectedElements: string[] = [];
  inscription: Inscription ;
  already: boolean = false;
  noPlace: boolean = false;
  outdated: boolean = false;
  constructor(private fs: FormationService, private router: Router, private auth: AuthService) {

    let formationId = this.router.url.split('/').pop();
    this.fs.getFormation(formationId)
      .then((formation: any) => {
        this.formation = (formation as Formation);
        if(this.formation.nb_places==this.formation.nb_enrolled){
          this.noPlace = true;
        }
        if(this.formation.date<new Date()){
          this.outdated = true;
        }
      })
      .then(res => {
        return this.fs.getElements(this.formation.id);
      })
      .then((elements: any) => {
        this.elements = (elements as Element[]);
      })
      .then(res=>{
        return this.fs.getInscription(this.auth.getCurrentUser().username, this.formation.id);
      })
      .then((inscript: any)=>{
        this.inscription = (inscript as Inscription);
        if(this.inscription!=null){
          this.already = true;
          this.inscription.elements.forEach(element=>{
            this.selectedElements.push(element);
          })
        }
      });
  }

  ngOnInit(): void {
  }


  toggleCheck(elementId: string) {
    if (this.elementsId.includes(elementId)) {
      this.elementsId.splice(this.elementsId.indexOf(elementId), 1);
    } else {
      this.elementsId.push(elementId);
    }
  }

  selectElement(elementId: string) {
    if (this.selectedElements.includes(elementId)) {
      this.selectedElements.splice(this.selectedElements.indexOf(elementId), 1);
    } else {
      this.selectedElements.push(elementId);
    }

  }

  subscribe() {
    this.popup = !this.popup;
  }

  inscrire() {
    this.fs.addInscription(this.formation.id, this.selectedElements, { beneficiaireId: this.auth.getCurrentUser().id, formation: this.formation.id, username: this.auth.getCurrentUser().username, email: this.email, address: this.address, phone: this.phone, elements: this.selectedElements })
      .then(res => {
        this.popup = false;
        this.already = true;
        this.email = '';
        this.address = '';
        this.phone = '';
        this.router.navigate(['/beneficiaire/formation_details/' + this.formation.id]);
      })
      .catch(err => {
        this.popup = false;
        this.already = true;
        this.router.navigate(['/beneficiaire/formation_details/' + this.formation.id]);
      })
  }
  
  reactivate(){
    this.fs.reactivateInscription(this.auth.getCurrentUser().username, this.formation.id)
    .then(res=>{
      console.log('reactivated successfully')
    })
    .catch(err=>{
      console.log('Done it');
    });
  }
}
