package com.dnd.party.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

	
	/**
	  * 한주전 일요일을 반환한다.
	  * @return
	  */
	 public static String getBeforeThursDay(){
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(new java.util.Date());
	  
	  int dayNum = cal.get(Calendar.DAY_OF_WEEK);
	  if(dayNum >=5) { // 목금토 일경우
		  cal.add(Calendar.DAY_OF_WEEK, 0);
	  
	  }else { // 일월화수 일경우
		  cal.add(Calendar.DAY_OF_WEEK, -1);
		  
	  }
	  cal.setFirstDayOfWeek(Calendar.THURSDAY);
	  cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
	  
	  
	  return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	 }
	 
}
