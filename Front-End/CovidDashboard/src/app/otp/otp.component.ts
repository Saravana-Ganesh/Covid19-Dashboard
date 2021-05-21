import { Component, OnInit} from '@angular/core';
import { ComponentInteractionService } from '../services/ComponentInteractionService';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.css']
})
export class OtpComponent implements OnInit { 
  public otp: String[] = ['','','','','',''];
  constructor(
    private componentInteractionService:ComponentInteractionService,
  ) { }
  ngOnInit(): void {    
  }
  
  public signupData = this.componentInteractionService.getSignupComponentData();
  public movetoNext(event:any):void{      
    if(event.key>=0 && event.key<=9){ 
      console.log(event);
      console.log(this.otp)
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
    console.log(currentOtp);
  }
}
