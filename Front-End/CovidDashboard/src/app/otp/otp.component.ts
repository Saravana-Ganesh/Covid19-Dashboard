import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { ComponentInteractionService } from '../services/ComponentInteractionService';
import { MiddlwareService } from '../services/middlware.service';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.css']
})
export class OtpComponent implements OnInit { 
  public otp = new Array(6);
  public signupData = this.componentInteractionService.getSignupComponentData();
  public isInValidOTP:boolean = false;
  constructor(
    private router:Router,
    private componentInteractionService:ComponentInteractionService,
    private middlwareService:MiddlwareService
  ) { }
  ngOnInit(): void {    
  }  
  public movetoNext(event:any):void{      
    if(event.key>=0 && event.key<=9){      
      if(this.otp.includes(undefined)!=true){
        this.verifyOTP();
        return;
      }
      let element = event.srcElement.nextElementSibling;  
      if(element!=null)    
          element.focus();  
    }
  }
  public verifyOTP():void{
    let currentOtp = "";    
    for(let i=0;i<this.otp.length;i++){
      currentOtp+=this.otp[i];
    }
    if(this.signupData.email!=null && currentOtp!=null && currentOtp.length==6){
      let data ={
        "email":this.signupData.email,
        "otp":currentOtp
      }
      this.middlwareService.verifSignupOTP(data).subscribe(
        result=>{
          console.log(result);
          if(result.status == 201){            
            this.router.navigateByUrl('/login');
          }else{
           this.isInValidOTP = true;
        }
      });
    }
    console.log(this.signupData.email+'---'+currentOtp);
  }
  public reSendSignupOTP(){
      this.middlwareService.reSendSignupOTP(this.signupData).subscribe(
        result=>{
          console.log(result);                   
        }
      );
  }

}
