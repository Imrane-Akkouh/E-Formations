import { Component, OnInit } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { ElementService } from 'src/app/services/element.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-formation-elements',
  templateUrl: './formation-elements.component.html',
  styleUrls: ['./formation-elements.component.scss']
})
export class FormationElementsComponent implements OnInit {

  elements: Element[];
  constructor(private elm: ElementService, private router: Router) {
    let formationId = this.router.url.split('/').pop();
    console.log(formationId);
    console.log("test");
    
  }

  ngOnInit(): void {
  }
}
