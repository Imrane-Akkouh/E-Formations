import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { JwtModule } from '@auth0/angular-jwt';
import { FormateurComponent } from './components/formateur/formateur.component';
import { BeneficiaireComponent } from './components/beneficiaire/beneficiaire.component';
import { CvComponent } from './components/cv/cv.component';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { AddFormationComponent } from './components/add-formation/add-formation.component';
import { FormationDetailsComponent } from './components/formation-details/formation-details.component';
import { FormationInformationsComponent } from './components/formation-informations/formation-informations.component';
import { PopupFormComponent } from './components/popup-form/popup-form.component';
import { FormationElementsComponent } from './components/formation-elements/formation-elements.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    FormateurComponent,
    BeneficiaireComponent,
    CvComponent,
    AddFormationComponent,
    FormationDetailsComponent,
    FormationInformationsComponent,
    PopupFormComponent,
    FormationElementsComponent,
    ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    HttpClientModule,
    PdfViewerModule,
    JwtModule.forRoot({config: {tokenGetter: ()=>localStorage.getItem('token')}})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }