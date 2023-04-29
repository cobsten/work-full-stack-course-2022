import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationFormComponent } from './components/registration-form/registration-form.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { MenuComponent } from './components/menu/menu.component';
import { authGuard } from './auth/auth.guard';
import { AirportListComponent } from './components/airport-list/airport-list.component';
import { NewAirportFormComponent } from './components/new-airport-form/new-airport-form.component';

const routes: Routes = [
  { path: '',  component: MenuComponent, canActivate:[authGuard]},
  { path: 'registration', component: RegistrationFormComponent },
  { path: 'login', component: LoginFormComponent},
  { path: 'airports', component: AirportListComponent, canActivate:[authGuard]},
  { path: 'airports/new', component: NewAirportFormComponent, canActivate:[authGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
