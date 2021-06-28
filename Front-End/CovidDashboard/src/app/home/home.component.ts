import { Component, OnInit } from '@angular/core';
import jspdf from 'jspdf';
import html2canvas from 'html2canvas';

declare var jsPDF: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})   
export class HomeComponent implements OnInit {
 
  constructor() { }
  ngOnInit() {
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
  public barChartOptions = {
    scaleShowVerticalLines:false,
    responsive:true
  };
  public barChartLabels = ['2006','2007','2008','2009','2010','2011','2012'];
  public barChartType = 'bar';
  public barChartLegend = true;

  public barChartData = [
    {
      data:[65,59,80,81,56,55,40],
      label:'Series A'
    },
    {
      data:[100,200,300,400,500],
      label:'Series B'
    }
  ]
 
}
