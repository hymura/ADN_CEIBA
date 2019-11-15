package co.com.ceiba.oc.dominio.model;

import java.util.Calendar;


public class CalendarManager {
	
	public int dayOfWeek() {
		Calendar today =  Calendar.getInstance();
		return(today.get(Calendar.DAY_OF_WEEK));
	}
	


}
