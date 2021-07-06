import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { MiddlwareService } from '../services/middlware.service';
import { Utils } from '../classes/Utils';

import { ChartType } from 'chart.js';
import { Color } from 'ng2-charts';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})   
export class HomeComponent implements OnInit {
  public isDrawChart = false;
  public isShowProfile = false;

  public chartName="Bar Chart";
  public barChartLabels:any = [];
  public barChartValues:any = [];
  public barChartLegend = true;

  // public chartColors: any[] = [
  //   { 
  //     backgroundColor:["purple"] 
  //   }];
  
  public barChartOptions = {
    scaleShowVerticalLines:false,  
    responsive:true
  };
  public chartType = ['Bar Chart','Line Chart','Pie Chart'];

  public barChartType:ChartType = 'bar'

  public barChartData = [
    {
      data:this.barChartValues,
      label:'Series A'
    }
  ]

  constructor(
    private router:Router,
    private middlwareService:MiddlwareService
  ) { }
  ngOnInit() {
    if(localStorage.getItem('email')!=null && localStorage.getItem('tokenID')!=null){
      let userDetails = {
        email:localStorage.getItem('email'),
        key:localStorage.getItem('tokenID')
      };
      this.middlwareService.home(JSON.stringify(userDetails)).subscribe(
        result=>{
          console.log(result);
          if(result.status==401){
            this.router.navigateByUrl('/login');
          }else{
            this.isDrawChart = true;
            this.drawHomePage(result);
          }
        }
      )
    }else{
      this.router.navigateByUrl('/login')
    }
    
  }
  logout(){
    if(localStorage.getItem('email')!=null && localStorage.getItem('tokenID')!=null){
      let userDetails = {
        email:localStorage.getItem('email'),
        key:localStorage.getItem('tokenID')
      };
      localStorage.removeItem('email');
      localStorage.removeItem('tokenID');
      this.middlwareService.logout(JSON.stringify(userDetails)).subscribe(
        result=>{
          this.router.navigateByUrl('/login');
        }
      )
    }else{
        this.router.navigateByUrl('/login');
    }
    
  }
  drawHomePage(response:any){
    for(let i=0;i<response.results.length;i++){
      for(let j=0;j<response.results[i].length;j++){            
            this.barChartLabels.push(response.results[i][0]);
            this.barChartValues.push(response.results[i][1]);
      }
    }
  }
  downloadAsPDF(){
    Utils.downloadAsPdf('pdfTable')
  }
  downloadAsExcel(){
    this.middlwareService.downloadAsExcel().subscribe(
      (response)=>{              
        Utils.downloadAsExcel(response);
      }
    );
  }
  selectChartType(chartName:any){    
    this.barChartType = chartName.substring(0,chartName.indexOf(" ")).toLowerCase();
    this.chartName = chartName;       
  }

  viewProfile(){
    this.router.navigateByUrl('/profile');
  }   
 
}
