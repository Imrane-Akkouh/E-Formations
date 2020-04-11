import { Component, OnInit } from '@angular/core';
import { Element } from 'src/app/models/element.model';
import { Formation } from 'src/app/models/formation.model';
import { AuthService } from 'src/app/services/auth.service';
import { FormationService } from 'src/app/services/formation.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-formation',
  templateUrl: './add-formation.component.html',
  styleUrls: ['./add-formation.component.css']
})
export class AddFormationComponent implements OnInit {
  formation: Formation;
  elements: Element[] ;
  constructor(private auth: AuthService, private fs: FormationService, private router: Router) { }

  ngOnInit(): void {
    this.formation = new Formation('', '', this.auth.getCurrentUser().id, '', '', '', new Date(), 0,false, [])
    this.elements = [new Element('', this.formation.formateurId,'',0,new Date("yyyy-MM-dd"),0,0)];
  }

  addElement(){
    this.elements.push(new Element('', this.formation.formateurId,'',0,new Date("yyyy-MM-dd"),0,0));
  }
  deleteElement(index: number){
    if(this.elements.length != 1)
    this.elements.splice(index,1);
  }
  saveFormation(){
    this.fs.createFormation(this.formation, this.elements).subscribe(formation=>{
      this.router.navigate(['/formateur']);
    })
  }

}
