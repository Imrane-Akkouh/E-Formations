import { Component, OnInit } from '@angular/core';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  providers: [NgbDropdownConfig]
})
export class NavbarComponent implements OnInit {

  constructor() {
  }
  ngOnInit() {
  }

}
