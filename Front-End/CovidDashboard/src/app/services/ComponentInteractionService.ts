import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'  
})
export class ComponentInteractionService{
    private signupComonentData:any;
    public setSignupComponentData(data: any):void{
        this.signupComonentData = data;
    }
    public getSignupComponentData():any{
      return this.signupComonentData;
    }
}


