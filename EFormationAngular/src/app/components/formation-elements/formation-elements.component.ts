import { Component, OnInit } from '@angular/core';
import { ElementService } from 'src/app/services/element.service';
import { Router } from '@angular/router';
import { FormationService } from 'src/app/services/formation.service';
import { Formation } from 'src/app/models/formation.model';

@Component({
  selector: 'app-formation-elements',
  templateUrl: './formation-elements.component.html',
  styleUrls: ['./formation-elements.component.scss']
})
export class FormationElementsComponent implements OnInit {

  elements: Element[];
  formation: Formation;
  constructor(private elm: ElementService, private router: Router, private fs: FormationService) {
    let formationId = this.router.url.split('/').pop();

  }

  ngOnInit(): void {
    let formationId = this.router.url.split('/').pop();
    this.fs.getFormation(formationId).then();  //fetching the formation by id

    this.fs.getElements(formationId).then();   // fetching the elements

  }
  validate(){

  }
}
