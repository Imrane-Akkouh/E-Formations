import { Component, OnInit } from '@angular/core';
import { Formation } from 'src/app/models/formation.model';
import { FormationService } from 'src/app/services/formation.service';
import { Element } from 'src/app/models/element.model';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-formation-informations',
  templateUrl: './formation-informations.component.html',
  styleUrls: ['./formation-informations.component.css']
})
export class FormationInformationsComponent implements OnInit {
  formation: Formation;
  elements: Element[];
  elementsId: string[] = [];
  email: string = '';
  address: string = '';
  phone: string = '';
  nb_inscriptions: number = 0;
  
  constructor(private fs: FormationService, private router: Router, private auth: AuthService) {
    
    let formationId = this.router.url.split('/').pop();
    this.fs.getFormation(formationId)
      .then((formation: any) => {
        this.formation = (formation as Formation);
      })
      .then(res => {
        return this.fs.getElements(this.formation.id);
      })
      .then((elements: any) => {
        this.elements = (elements as Element[]);
        console.log(this.elements);
        this.elements.forEach(element=>{
          this.nb_inscriptions += element.nb_beneficiaries;
        });
      });
  }

  ngOnInit(): void {
  }


  toggleCheck(elementId: string){
    if(this.elementsId.includes(elementId)){
      this.elementsId.splice(this.elementsId.indexOf(elementId),1);
    }else{
      this.elementsId.push(elementId);
    }
  }

  inscrire(){
    this.fs.addInscription(this.formation.id,this.elementsId, {beneficiaireId: this.auth.getCurrentUser().id, formation: this.formation.formation_name, username: this.auth.getCurrentUser().username, email: this.email, address: this.address, phone: this.phone})
  }

}
