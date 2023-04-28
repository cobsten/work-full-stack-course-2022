import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AdminService } from './admin.service';
import { HttpClientModule } from '@angular/common/http';
import { CustomValidator } from './validators/CustomValidator';
import { LoginFormComponent } from './login-form/login-form.component';
import { MenuComponent } from './menu/menu.component';
import { AirportListComponent } from './components/airport-list/airport-list.component';
import { AirportItemComponent } from './components/airport-item/airport-item.component';
import { NewAirportFormComponent } from './components/new-airport-form/new-airport-form.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationFormComponent,
    LoginFormComponent,
    MenuComponent,
    AirportListComponent,
    AirportItemComponent,
    NewAirportFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }
