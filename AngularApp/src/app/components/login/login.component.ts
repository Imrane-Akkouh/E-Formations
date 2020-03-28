import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @ViewChild('container') container : ElementRef;
  constructor(private auth: LoginService) { }

  ngOnInit(): void {
  }

  signUpButton(){
    this.container.nativeElement.classList.toggle("right-panel-active");
  };

  signInButton(){
	  this.container.nativeElement.classList.toggle("right-panel-active");
  };
}
