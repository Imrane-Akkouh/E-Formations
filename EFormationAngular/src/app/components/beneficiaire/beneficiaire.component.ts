import { Component, OnInit } from '@angular/core';
import { Formation } from 'src/app/models/formation.model';
import { BehaviorSubject, Subject } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { FormationService } from 'src/app/services/formation.service';

@Component({
  selector: 'app-beneficiaire',
  templateUrl: './beneficiaire.component.html',
  styleUrls: ['./beneficiaire.component.scss']
})
export class BeneficiaireComponent implements OnInit {

  formations:Subject<Formation[]> = new BehaviorSubject<Formation[]>([]);
  
  constructor(private fs: FormationService, private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.fs.getBeneficiaireFormations().subscribe(formations=>{
      this.formations.next(formations as Formation[]);
    })
  }
  showFormationDetails(formationId: any){
    console.log(formationId);
  }
}
 