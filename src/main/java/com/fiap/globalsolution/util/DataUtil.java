package com.fiap.globalsolution.util;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DataUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	//Formata a data
	public static String formatar(Calendar data) {
		return sdf.format(data.getTime());
	}
	
	//Transforma a String em um Calendar
	public Calendar parse(String data) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(data));
		return calendar;
	}
	
	public static Double calculaDias(Calendar dateInicial, Calendar dataFinal, Double precoDiaria ) {
		
    	DateTime dtToday = new DateTime(dateInicial);//pega dataInicial
        DateTime dtOther = new DateTime(dataFinal); //pega dataFinal

        Duration dur = new Duration(dtToday,dtOther);
		return (dur.getStandardDays() * precoDiaria);
    }
}

	

