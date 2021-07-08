import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { MiddlwareService } from '../services/middlware.service';
import { Utils } from '../classes/Utils';

import { ChartType } from 'chart.js';
import { Color } from 'ng2-charts';
import { ComponentInteractionService } from '../services/ComponentInteractionService';
import { UserDetails } from '../classes/UserDetails';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})   
export class HomeComponent implements OnInit {
  public isDrawChart = false;
  public isShowProfile = true;;

  public tableData:any;
  public isShowtable = false;
  dtOptions: DataTables.Settings = {};

  public chartName="Bar Chart";
  public barChartLabels:any = [];
  public barChartValues:any = [];
  public barChartLegend = true;
  
  
  public barChartOptions = {
    scaleShowVerticalLines:false,  
    responsive:true
  };
  public chartType = ['Bar Chart','Line Chart','Pie Chart','Table'];

  public barChartType:ChartType = 'bar'

  public barChartData = [
    {
      data:this.barChartValues,
      label:'Case Count'
    }
  ]

  constructor(
    private router:Router,
    public userDetails:UserDetails,
    private middlwareService:MiddlwareService,
    public componentInteractionService:ComponentInteractionService
  ) { }
  
  ngOnInit() {
         
    if(localStorage.getItem('email')!=null && localStorage.getItem('tokenID')!=null){

        this.dtOptions = {
          pagingType: 'full_numbers',
          pageLength: 10,
          processing: true
        };

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
                this.componentInteractionService.setIsShowHome(true); 
                this.drawHomePage(result);
              }
          })
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
      this.userDetails.name = this.userDetails.email = this.userDetails.phone=this.userDetails.password1=this.userDetails.password2 = '';
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
    this.tableData = response.results;
    
    for(let i=0;i<response.results.length;i++){
                 
            this.barChartLabels.push(response.results[i][0]);
            this.barChartValues.push(response.results[i][1]);
           
      
    }
    console.log(this.barChartLabels);
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
    if(chartName=='Table'){
      this.isShowtable = true;
      this.isDrawChart = false;      
    }else{
      this.isDrawChart = true;
      this.isShowtable = false;
      this.barChartType = chartName.substring(0,chartName.indexOf(" ")).toLowerCase();
    }  
    this.chartName = chartName;
      
  }

}
