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
  httpOptions = {
    //'responseType'  : 'arraybuffer' as 'json'
    'responseType'  : 'blob' as 'json'        //This also worked
  };
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
  //Excel download Service
  downloadAsExcel(){
    return this.httpClient.get('Covid19Dashboard/downloadAsExcel',{responseType: 'blob'});
  }
  home(formData:any){
    return this.httpClient.post<any>('Covid19Dashboard/home', formData, {headers: this.headers});
  }
  logout(formData:any){
    return this.httpClient.post<any>('Covid19Dashboard/logout', formData, {headers: this.headers});
  }
}
