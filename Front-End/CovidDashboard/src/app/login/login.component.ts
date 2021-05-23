import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { UserDetails } from '../classes/UserDetails';
import { MiddlwareService } from '../services/middlware.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public invalidEmailLength: boolean = false;
  public invalidPasswordLength: boolean = false;
  public invalidUserNameOrPassword:boolean = false;
  constructor(
    public userDetails:UserDetails,
    private middlewareService:MiddlwareService
    ) { }
  
  ngOnInit(): void {
  }
  loginSubmit():void{
    if(this.userDetails.email==''){
      this.invalidEmailLength = true;
    }
    if(this.userDetails.password1==''){
      this.invalidPasswordLength = true;
    }
    if(this.invalidEmailLength || this.invalidPasswordLength){
      return;
    }else{
        let data = {
          "userEmail":this.userDetails.email,
          "password":this.userDetails.password1
        };
      this.middlewareService.login(data).subscribe(
        result=>{
            if(result.status==200){
              console.log(result);
              localStorage.setItem(this.userDetails.email, result.tokenID);
            }else{
              this.invalidUserNameOrPassword = true;
            }
        }
      );
    }
      
  }

}
