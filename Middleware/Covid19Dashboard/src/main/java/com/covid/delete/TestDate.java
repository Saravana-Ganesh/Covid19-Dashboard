package com.covid.delete;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class TestDate {
	static int a=10;
	
	public static void main(String[] args) throws InterruptedException {	
		assert(false);		
		List<String> _l = new ArrayList<String>();
		_l.add("String 1...");
		_l.add("String 2...");
		_l.add("String 3...");
		for(String a:_l) {
			System.out.println(a);
		}
		/*for(int i=0;i<l.size();i++) {
			String a = l.get(i);
			System.out.println(a);
		}*/
		
		 /*LocalDateTime date1 = LocalDateTime.now();
		 System.out.println(date1);
		 String day = date1.getDayOfMonth()+":"+date1.getMonth()+":"+date1.getYear();
		 System.out.println(day);
		 System.out.println("Current Time:"+date1.getHour()+":"+date1.getMinute());
		 LocalTime time1 = LocalTime.of(23,56,00);
	     LocalTime time2 = LocalTime.of(00,6,00);
	     System.out.println(ChronoUnit.HOURS.between(time2, time1));
	     System.out.println(ChronoUnit.MINUTES.between(time2, time1) % 60);
	     System.out.println("Convert total day into minutes...");
	     System.out.println(date1.getHour()*60+date1.getMinute());*/
	    /* TreeSet<Date> t = new TreeSet<Date>();
	     Date d = new Date("12/3/1997");
	     t.add(d);
	     Date d1 = new Date("01/3/1997");
	     t.add(d1);
	     System.out.println(t);*/
	     
	}

}
