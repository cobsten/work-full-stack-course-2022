import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subscriber, map } from 'rxjs';
import { Admin } from 'src/Objects';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private serverUrl = 'http://localhost:8080';
  private createUserApiUrl = this.serverUrl +'/api/users'
  private queryEmailExistsApiUrl = this.serverUrl +'/api/users/emails/exist'
  constructor(private client: HttpClient) {}

  getData(): Observable<Admin[]> {
    return this.client.get<Admin[]>('../assets/admin.json').pipe(
      map((data) => {
        return data.map((item: Admin) => {
          return {
            name: item.name,
            email: item.email,
            passphrase: item.passphrase,
          } as Admin;
        });
      })
    );
  }
  
  createUser(user: Admin){
    return this.client.post(this.createUserApiUrl,user);
  }

  isEmailTaken(input: string): Observable<boolean> {
    let body = {email:input};
    console.log(JSON.stringify(body));
    return this.client.post<boolean>(this.queryEmailExistsApiUrl,body);
  }
}