import { Component, OnInit } from '@angular/core';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
import { LoginService } from '../../services/login.service';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [NgbDropdownConfig]
})
export class NavbarComponent implements OnInit {
  homepage:string = "";
  constructor(private auth: AuthService, private router: Router) {
  }
  ngOnInit() {
    if(this.auth.isFormateur()){
      this.homepage = "/formateur";
    }
    if(this.auth.isBeneficiaire()){
      this.homepage = "/beneficiaire";
    }
  }

  logout(){
    this.auth.logout();
    this.router.navigate(['/login']);
  }
}
