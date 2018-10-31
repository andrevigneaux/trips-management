package com.andre.tripsmanagement.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
    public static LocalDate getLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date getDateUtil(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
