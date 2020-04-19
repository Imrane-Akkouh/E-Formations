import { Component, OnInit } from '@angular/core';
import { Formation } from 'src/app/models/formation.model';
import { FormationService } from 'src/app/services/formation.service';
import { Element } from 'src/app/models/element.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-formation-details',
  templateUrl: './formation-details.component.html',
  styleUrls: ['./formation-details.component.css']
})
export class FormationDetailsComponent implements OnInit {

  formation: Formation;
  elements: Element[];
  
  constructor(private fs: FormationService, private router: Router) {
    
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
      });
  }

  ngOnInit(): void {
  }

  validate(){
    this.formation.validated = true;
    this.fs.validerFormation(this.formation.id);
  }

}
