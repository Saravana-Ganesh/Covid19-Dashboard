package com.covid.delete;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TestDate {

	public static void main(String[] args) throws InterruptedException {
		 LocalDateTime date1 = LocalDateTime.now();
		 System.out.println(date1);
		 String day = date1.getDayOfMonth()+":"+date1.getMonth()+":"+date1.getYear();
		 System.out.println(day);
		 System.out.println(date1.getHour()+":"+date1.getMinute());
		 LocalTime time1 = LocalTime.of(23,56,00);
	     LocalTime time2 = LocalTime.of(00,6,00);
	     System.out.println(ChronoUnit.HOURS.between(time2, time1));
	     System.out.println(ChronoUnit.MINUTES.between(time2, time1) % 60);
	}

}
