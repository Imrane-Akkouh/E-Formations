import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { AuthService } from '../services/auth.service';
@Injectable({
    providedIn: 'root'
})
export class BeneficiaireGuard implements CanActivate {
  constructor(public auth: AuthService, public router: Router) {}
  canActivate(): boolean {
    if (this.auth.isBeneficiaire()) {
        return true;
    }else{
        this.router.navigate(['/login']);
        return false;
    }
  }
}