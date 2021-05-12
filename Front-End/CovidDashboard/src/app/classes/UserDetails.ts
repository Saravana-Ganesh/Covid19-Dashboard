import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })
export class UserDetails{
    public name: String="";
    public email:String="";
    public phone:String="";
    public password1:String="";
    public password2:String="";
}