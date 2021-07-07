import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDetails } from '../classes/UserDetails';
import { ComponentInteractionService } from '../services/ComponentInteractionService';
import { MiddlwareService } from '../services/middlware.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(
    public userDetails:UserDetails,
    private middelwareService:MiddlwareService,
    private componentInteractionService:ComponentInteractionService,
    private router:Router
  ) { }
  @Input() public parentData:any;
  ngOnInit(): void {
    console.log(this.parentData);
    if(localStorage.getItem('email')!=null && localStorage.getItem('tokenID')!=null){
     if(this.userDetails.name == '' || this.userDetails.email =='' || this.userDetails.phone ==''){

      let userDetails = {
        email:localStorage.getItem('email'),
        key:localStorage.getItem('tokenID')
      };
      this.middelwareService.userProfile(userDetails).subscribe(
        result=>{
          console.log(result);
          if(result.status==200){
            this.userDetails.name = result.registrationBOList[0][0]
            this.userDetails.email = result.registrationBOList[0][1]
            this.userDetails.phone = result.registrationBOList[0][2]
          }else{
              this.router.navigateByUrl('/login');
          }
        }
      )

     }

    }
    
  }

  navigateTohome(){
    this.componentInteractionService.setIsDrawChart(true);
    this.componentInteractionService.setisShowProfile(false);
    //alert(this.componentInteractionService.getIsDrawChart());
  }
}
