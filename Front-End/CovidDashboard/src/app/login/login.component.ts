import { Component, OnInit } from '@angular/core';
import { UserDetails } from '../classes/UserDetails';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public invalidEmailLength: boolean = false;
  public invalidPasswordLength: boolean = false;
  constructor(public userDetails:UserDetails) { }
  
  ngOnInit(): void {
  }
  loginSubmit():void{
    if(this.userDetails.email==''){
      this.invalidEmailLength = true;
    }
    if(this.userDetails.password1=='')
      this.invalidPasswordLength = true;
  }

}
