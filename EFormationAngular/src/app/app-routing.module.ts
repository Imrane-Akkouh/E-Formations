import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from '../app/components/home/home.component';
import { LoginComponent } from '../app/components/login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { AuthReverseGuard } from './guards/auth-reverse.guard';

const routes: Routes = [
  { path: 'login', component: LoginComponent,canActivate:[AuthReverseGuard]},
  { path: 'home', component: HomeComponent, canActivate:[AuthGuard]},
  { path: '**', component: HomeComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
