import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import jspdf from 'jspdf';
import html2canvas from 'html2canvas';

import { MiddlwareService } from '../services/middlware.service';
import { EnumValues } from '../classes/EnumValues';
import { ChartType } from 'chart.js';


declare var jsPDF: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})   
export class HomeComponent implements OnInit {
  public isValidUser = false;

  public chartName="Bar Chart";
  public barChartLabels:any = [];
  public barChartValues:any = [];
  public barChartLegend = true;

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
            this.isValidUser = true;
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
    var element = document.getElementById('pdfTable') as HTMLCanvasElement;
    html2canvas(element).then(
      (canvas)=>{
        console.log(canvas);
        var imgData = canvas.toDataURL('image/png');
        var doc = new jspdf('p', 'mm', 'a4',true);
        doc.addImage(imgData,50,10,100,100);
        doc.save('chart.pdf');
      }
    )
  }
  downloadAsExcel(){
    this.middlwareService.downloadAsExcel().subscribe(
      (response)=>{      
        let file = new Blob([response], { type: 'application/vnd.ms-excel' });
        var fileURL = URL.createObjectURL(file);
        console.log(fileURL);
        window.open(fileURL, "_blank");

      }
    );
  }
  selectChartType(chartName:any){
    this.barChartType = chartName;
    if(chartName=='line'){
      this.chartName = 'Line Chart';      
    }
    if(chartName=='pie'){
      this.chartName = 'Pie Chart';
    }
      
  }
  public barChartOptions = {
    scaleShowVerticalLines:false,  
    responsive:true
  };
  public chartType = ['bar','line','pie'];

  public barChartType:ChartType = 'bar'

  public barChartData = [
    {
      data:this.barChartValues,//[65,59,80,81,56,55,40],
      label:'Series A'
    }/* ,
    {
      data:[100,200,300,400,500],
      label:'Series B'
    } */
  ]
 
}
