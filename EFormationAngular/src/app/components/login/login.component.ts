import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string = "";
  password: string = "";

  @ViewChild('container') container : ElementRef;

  constructor(private auth: AuthService) { }

  ngOnInit(): void {
  }

  
  authenticate(){
    this.auth.authenticateUser(this.username, this.password)
    .subscribe(token=>{
      console.log(token);
    });
  }





  signUpButton(){
    this.container.nativeElement.classList.toggle("right-panel-active");
  };

  signInButton(){
	  this.container.nativeElement.classList.toggle("right-panel-active");
  };

}
