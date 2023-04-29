import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, delay, tap, map, BehaviorSubject } from 'rxjs';
import { Admin } from 'src/Objects';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedInSubject = new BehaviorSubject<boolean>(this.hasToken());

  isLoggedInObservable(): Observable<boolean> {
    return this.isLoggedInSubject.asObservable();
  }

  isLoggedIn() {
    if (sessionStorage.getItem('loggedIn') == 'yes') {
      return true;
    } else {
      return false;
    }
  }

  // store the URL so we can redirect after logging in
  redirectUrl: string | null = null;

  private serverUrl = 'http://localhost:8080';
  private loginUserApiUrl = this.serverUrl + '/api/users/login'
  constructor(private client: HttpClient) { }


  login(user: Admin) {
    return this.client.post<boolean>(this.loginUserApiUrl, user).subscribe((success: boolean) => {
      if (success) {
        sessionStorage.setItem('loggedIn', 'yes');
        this.isLoggedInSubject.next(true);
      }
    }
    );
  }

  logout(): void {
    sessionStorage.removeItem('loggedIn');
    this.isLoggedInSubject.next(false);
  } 
  
  private hasToken():boolean{
    return !!sessionStorage.getItem('loggedIn');
  }
}
