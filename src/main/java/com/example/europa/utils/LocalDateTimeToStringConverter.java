package com.example.europa.utils;

import java.time.LocalDateTime;

public class LocalDateTimeToStringConverter {
    public static String convert(LocalDateTime ldt){
        String dateString = ldt.getDayOfMonth() + "/" + ldt.getMonthValue() + "/" + ldt.getYear() + " ";
        String hour = ldt.getHour() + "";

        if(hour.length() == 1)
            hour = "0" + hour;

        String minutes = ldt.getMinute() + "";

        if(hour.length() == 1)
            minutes = "0" + minutes;


        return dateString + hour + ":" + minutes;
    }
}
