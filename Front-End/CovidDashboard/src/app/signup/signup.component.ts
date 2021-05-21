import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { UserDetails } from '../classes/UserDetails';
import { Utils } from '../classes/Utils';
import { MiddlwareService } from '../services/middlware.service';
import { ComponentInteractionService } from '../services/ComponentInteractionService';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(
    public userDetails:UserDetails,
    private middlwareService:MiddlwareService,
    private router:Router,
    private componentInteractionService:ComponentInteractionService
    ) { }
  public isInValidUserName:boolean = false;
  public isInValidEmail:boolean = false;
  public isInValidPhone:boolean = false;
  public isInValidPassword:boolean = false;   
  ngOnInit(): void {
  }
  
  submitSignupForm():void{
    this.isInValidUserName = this.userDetails.name.length<3?true:false;
    this.isInValidEmail = !Utils.validateEmail(this.userDetails.email)?true:false;
    this.isInValidPhone = this.userDetails.phone.length!=10?true:false;
    this.isInValidPassword = this.userDetails.password1!=this.userDetails.password2 || this.userDetails.password1.length<6?true:false;
    if(!this.isInValidUserName && !this.isInValidEmail && !this.isInValidPhone && !this.isInValidPassword ){
        this.middlwareService.submitSignup(JSON.stringify(this.userDetails)).subscribe(
          result=>{
            console.log(result);
            if(result.status==201){
              this.componentInteractionService.setSignupComponentData(this.userDetails);
              this.router.navigateByUrl('/otp');
            }
          }
        );
    }
  }
}
