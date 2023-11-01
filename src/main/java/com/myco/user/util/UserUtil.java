package com.myco.user.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserUtil {
	
	public Date getDate() {
//		log.info(">>>> getDate()");
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String formattedDate = sdf.format(date);
//		log.info("<<<< getDate(), date : {} ", formattedDate);
//		return formattedDate;
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, 1);

		Date date = cal.getTime();             

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

		String date1 = format1.format(date);            

		Date inActiveDate = null;

		try {

		    inActiveDate = format1.parse(date1);

		} catch (ParseException e1) {

		    log.error(">>>> error on getDate() , exception : {} " , e1.getMessage());

		}
			log.info("Date : {}",inActiveDate);
		return inActiveDate;
	}

}
