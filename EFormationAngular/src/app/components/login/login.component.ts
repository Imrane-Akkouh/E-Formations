import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginError: string = "";
  registerError: string = "";
  username: string = "";
  password: string = "";
  role: string = "BENEFICIAIRE";

  @ViewChild('container') container: ElementRef;

  constructor(
    private auth: AuthService, 
    private userService: UserService,
    private router: Router
  ) {

  }

  ngOnInit(): void {
  }


  authenticate() {
    let userToken;
    this.auth.authenticateUser(this.username, this.password)
      .then(token => {
        userToken = token;
        return this.userService.getUser(this.username, userToken)
      })
      .then(res=>{
        let user :any = res;
        console.log(user.rated_fromations);
        this.auth.storeUserData(userToken, new User(user.id, this.username, user.rating, user.nbr_reviewers, user.rated_fromations, user.formations, user.roles[0].role));
        if(user.roles[0].role == "BENEFICIAIRE"){
          this.router.navigate(['/beneficiaire']);
        }else{
          this.router.navigate(['/formateur']);
        }
      })
      .catch((err)=>{
        try{
          this.loginError = JSON.parse(err.error).message;
        }catch(error){
          this.loginError = err.error.message;
        }
      });
  }

  register() {
    let userToken;
    if(this.password=="" || this.username==""){
      this.registerError = "Cannot submit empty fields";
    }else{
      this.auth.registerUser(this.username, this.password, this.role)
      .then(token => {
        userToken = token;
        return this.userService.getUser(this.username, userToken)
      })
      .then(res => {
        let user: any = res;
        this.auth.storeUserData(userToken, new User(user.id, this.username, user.rating, user.nbr_reviewers, user.rated_formations, user.formations, user.roles[0].role));
        if(user.roles[0].role == "BENEFICIAIRE"){
          this.router.navigate(['/beneficiaire']);
        }else{
          this.router.navigate(['/formateur']);
        }
        return;
      })
      .catch((err)=>{
        console.log(err);
        this.registerError = JSON.parse(err.error).message;
      });
      
    }
    
  }





  handleChange(evt){
    if(this.role === "BENEFICIAIRE" ){
      this.role = "FORMATEUR";
    }else{
      this.role = "BENEFICIAIRE";
    }
  }





  signUpButton() {
    this.container.nativeElement.classList.toggle("right-panel-active");
  };

  signInButton() {
    this.container.nativeElement.classList.toggle("right-panel-active");
  };

}
