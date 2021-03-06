import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'  
})
export class MiddlwareService {
  productionUrl = '../../Covid19Dashboard';
  developmentUrl = 'Covid19Dashboard'
  url!: string;
  constructor( private httpClient:HttpClient) {
    if (environment.production) {
       this.url = this.productionUrl;
    }else{
      this.url = this.developmentUrl;         
    }
   }
  headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
  httpOptions = {
    //'responseType'  : 'arraybuffer' as 'json'
    'responseType'  : 'blob' as 'json'        //This also worked
  };
  
  //Registration related services...
  submitSignup(formData: any) {
    return this.httpClient.post<any>(this.url+'/signup', formData, {headers: this.headers});
  }
  verifSignupOTP(formData:any){
    return this.httpClient.post<any>(this.url+'/signupOTP', formData, {headers: this.headers});
  }
  reSendSignupOTP(formData:any){
    return this.httpClient.post<any>(this.url+'/reSendSignupOTP', formData, {headers: this.headers});
  }
  //Login related services...
  login(formData:any){
    return this.httpClient.post<any>(this.url+'/login', formData, {headers: this.headers});
    //return this.httpClient.post<any>('http://localhost:8080/login', formData, {headers: this.headers});
  }
  //Excel download Service
  downloadAsExcel(){
    return this.httpClient.get(this.url+'/downloadAsExcel',{responseType: 'blob'});
  }
  home(formData:any){
    return this.httpClient.post<any>(this.url+'/home', formData, {headers: this.headers});
  }
  userProfile(formData:any){
    return this.httpClient.post<any>(this.url+'/profile', formData, {headers: this.headers});
  }
  logout(formData:any){
    return this.httpClient.post<any>(this.url+'/logout', formData, {headers: this.headers});
  }
  indiaData(){
    return this.httpClient.get('https://api.covid19india.org/v4/min/data.min.json')
  }
}
