import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'  
})
export class MiddlwareService {
  constructor(
    private httpClient:HttpClient
  ) { }
  headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
  //Registration related services...
  submitSignup(formData: any) {
    return this.httpClient.post<any>('Covid19Dashboard/signup', formData, {headers: this.headers});
  }
  verifSignupOTP(formData:any){
    return this.httpClient.post<any>('Covid19Dashboard/signupOTP', formData, {headers: this.headers});
  }
  reSendSignupOTP(formData:any){
    return this.httpClient.post<any>('Covid19Dashboard/reSendSignupOTP', formData, {headers: this.headers});
  }
  //Login related services...
  login(formData:any){
    return this.httpClient.post<any>('Covid19Dashboard/login', formData, {headers: this.headers});
  }
}
