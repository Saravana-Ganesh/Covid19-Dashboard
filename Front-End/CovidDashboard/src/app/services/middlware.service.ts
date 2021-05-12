import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'  
})
export class MiddlwareService {
  constructor(
    private httpClient:HttpClient
  ) { }
  headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');

  submitSignup(formData: any) {
    return this.httpClient.post<any>('/Covid19Dashboard/signup', formData, {headers: this.headers});
  }
  
}
