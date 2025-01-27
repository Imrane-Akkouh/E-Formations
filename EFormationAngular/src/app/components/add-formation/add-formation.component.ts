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
  elements: {
    formateurId: string,
    element_name: string,
    duration: number,
    date: Date,
    cost: number,
    nb_beneficiaries: number
  }[] ;
  constructor(private auth: AuthService, private fs: FormationService, private router: Router) { }

  ngOnInit(): void {

    this.formation = new Formation('', '', this.auth.getCurrentUser().id, '', '', '', new Date(), 0, 0,false,0, [])
    this.elements = [{
      formateurId: this.formation.formateurId,
      element_name: '',
      duration: 0,
      date: new Date("yyyy-MM-dd"),
      cost: 0,
      nb_beneficiaries: 0
    }];
    
  }

  addElement(){
    this.elements.push({
      formateurId: this.formation.formateurId,
      element_name: '',
      duration: 0,
      date: new Date("yyyy-MM-dd"),
      cost: 0,
      nb_beneficiaries: 0
    });
  }
  deleteElement(index: number){
    if(this.elements.length != 1)
    this.elements.splice(index,1);
  }
  saveFormation(){
    this.elements.forEach(element=>{
      console.log(element.cost);
      this.formation.totalPrice = this.formation.totalPrice+element.cost;
      console.log(this.formation.totalPrice);
    })
    this.fs.createFormation(this.formation, this.elements).subscribe(formation=>{
      this.router.navigate(['/formateur']);
    })
  }

}
