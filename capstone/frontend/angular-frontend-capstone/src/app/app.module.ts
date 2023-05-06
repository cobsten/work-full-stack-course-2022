import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationFormComponent } from './components/registration-form/registration-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { AdminService } from './services/admin.service';
import { HttpClientModule } from '@angular/common/http';
import { CustomValidator } from './validators/CustomValidator';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { MenuComponent } from './components/menu/menu.component';
import { AirportListComponent } from './components/airport-list/airport-list.component';
import { AirportItemComponent } from './components/airport-item/airport-item.component';
import { NewAirportFormComponent } from './components/new-airport-form/new-airport-form.component';
import { TopNavBarComponent } from './components/top-nav-bar/top-nav-bar.component';
import { AirportSearchComponent } from './components/airport-search/airport-search.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationFormComponent,
    LoginFormComponent,
    MenuComponent,
    AirportListComponent,
    AirportItemComponent,
    NewAirportFormComponent,
    TopNavBarComponent,
    AirportSearchComponent
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
