import { Component, OnInit } from '@angular/core';
import { ChartType } from 'chart.js';
import { MiddlwareService } from '../services/middlware.service';

@Component({
  selector: 'app-covid-india-org-api-data',
  templateUrl: './covid-india-org-api-data.component.html',
  styleUrls: ['./covid-india-org-api-data.component.css']
})
export class CovidIndiaOrgApiDataComponent implements OnInit {

  constructor(
    private middlwareService:MiddlwareService
  ) { }

  ngOnInit(): void {
    this.middlwareService.indiaData().subscribe(
      response=>{
        this.drawResponseInChart(response);
      }
    )
  }
  public chartName="Bar Chart";
  public barChartLabels:any = [];
  public barChartValues:any = [];
  public barChartLegend = true;
  
  
  public barChartOptions = {
    scaleShowVerticalLines:false,  
    responsive:true
  };
  public chartType = ['Bar Chart','Line Chart','Pie Chart','Table'];
  public states = ['AN','AP','AR','AS','BR','CH','CT','DL','DN','GA','GJ','HP',
                  'HR','JH','JK','KA','KL','LA','LD','MH','ML','MN','MP','MZ','NL','OR','PB',
                  'PY','RJ','SK','TG','TN','TR','UP','UT','WB'];
  public barChartType:ChartType = 'pie'

  public barChartData = [
    {
      data:this.barChartValues,
      label:'Case Count'
    }
  ]
  getStateName(stateCode:any):string{
    switch(stateCode){
      case 'AN':
         return "Andaman";
      case 'AP':
         return "Andhra Pradesh";
      case 'TN':
         return "Tamil Nadu";
      case 'AR':
         return "Arunachal Pradesh";
      case 'AS':
         return "Assam";
      case 'BR':
         return "Bihar";
      case 'CH':
         return "Chandigarh";
      case 'CT':
         return "Chattisgarh";
      case 'DL':
         return "Dehi";
      case 'DN':
         return "Daman & Diu";
      case 'GA':
         return "GOA";
      case 'GJ':
         return "Gujarat";
      case 'HP':
         return "Himachal Pradesh";      
      case 'HR':
          return "Haryana";
      case 'JH':
          return "Jharkhand";
      case 'KA':
          return "Karnataka";
      case 'KL':
          return "Kerala";
      case 'LA':
          return "Ladakh";
      case 'LD':
          return "Lakshadeep";
      case 'MH':
          return "Maharashtra";
      case 'ML':
          return "Meghalaya";
      case 'MN':
          return "Manipur";
      case 'MP':
          return "Madhya Pradesh";
      case 'MZ':
          return "Mizoram";
      case 'NL':
          return "Nagaland";
      case 'OR':
          return "Odisha";
      case 'PB':
          return "Punjab";
      case 'RJ':
          return "Rajasthan	";
      case 'SK':
          return "Sikkim";
      case 'TG':
          return "Telangana";
      case 'TR':
          return "Tripura";
      case 'PY':
          return "Pondicherry";
      case 'UP':
          return "Uttar Pradesh	";
      case 'UT':
          return "Uttarakhand";
      case 'WB':
          return "West Bengal	"; 
          
      default:
        return "Indian State"
    }
    return "";
  }
  drawResponseInChart(data:any):void{
   console.log(data);
    for(let i=0;i<this.states.length;i++){      
      let stateCode = this.states[i];
      let stateName = this.getStateName(stateCode);
      console.log(stateCode+"--"+stateName)
      this.barChartLabels[i] = stateName;
      this.barChartValues[i] = data[stateCode].delta21_14.confirmed;
      //console.log(this.barChartLabels[i]+'---------'+this.barChartValues[i]);
    }
    console.log(this.barChartLabels+'---------'+this.barChartValues);
  }
}
