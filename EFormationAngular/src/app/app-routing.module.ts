import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from '../app/components/home/home.component';
import { LoginComponent } from '../app/components/login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { AuthReverseGuard } from './guards/auth-reverse.guard';
import { FormateurGuard } from './guards/formateur-role.guard';
import { FormateurComponent } from './components/formateur/formateur.component';
import { BeneficiaireGuard } from './guards/beneficiaire-role.guard';
import { BeneficiaireComponent } from './components/beneficiaire/beneficiaire.component';
import { CvComponent } from './components/cv/cv.component';
import { AddFormationComponent } from './components/add-formation/add-formation.component';
import { FormationDetailsComponent } from './components/formation-details/formation-details.component';
import { FormationElementsComponent } from './components/formation-elements/formation-elements.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent,canActivate: [AuthReverseGuard]},
  { path: 'formateur/cv', component: CvComponent, canActivate: [FormateurGuard]},
  { path: 'formateur', component: FormateurComponent, canActivate: [FormateurGuard]},
  { path: 'beneficiaire', component: BeneficiaireComponent, canActivate: [BeneficiaireGuard]},
  { path: 'formateur/newformation', component: AddFormationComponent, canActivate: [FormateurGuard]},
  { path: 'formateur/formation_details/:id', component: FormationDetailsComponent, canActivate: [FormateurGuard] },
  { path: 'beneficiaire/formation_details/:id', component: FormationElementsComponent, canActivate: [BeneficiaireGuard] },
  { path: '**', component: HomeComponent, canActivate:[AuthGuard]},
  
];

@NgModule({ 
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
