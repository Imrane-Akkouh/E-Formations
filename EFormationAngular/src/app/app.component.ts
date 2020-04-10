import { Component } from '@angular/core';
import { Router, Event, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  nav: Boolean = true;
  constructor(private router: Router){
    router.events.subscribe(evt=>{
      if (evt instanceof NavigationEnd){
        if(evt.urlAfterRedirects.includes('login')){
          this.nav = false;
        }else{
          this.nav = true;
        }
      }
    })
  }
}
