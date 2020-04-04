import { Component, OnInit } from '@angular/core';
import { FormationService } from 'src/app/services/formation.service';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { BehaviorSubject, Subject } from 'rxjs';
import { Formation } from 'src/app/models/formation.model';

@Component({
  selector: 'app-formateur',
  templateUrl: './formateur.component.html',
  styleUrls: ['./formateur.component.css']
})
export class FormateurComponent implements OnInit {
  formations:Subject<Array<Formation>> = new BehaviorSubject<Array<Formation>>([])
  constructor(private fs: FormationService, private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.fs.getFormations(this.auth.getCurrentUser().username).subscribe(formations=>{
      this.formations.next(formations as Formation[])
    })
  }

  addCV(){
    this.router.navigate(['/formateur/cv']);
  }

  addFormation(){
    this.router.navigate(['/formateur/newformation']);
  }

}
