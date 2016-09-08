package com.parkhomenko.core.date_time_java_8;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author Dmytro Parkhomenko
 *         Created on 04.09.16.
 */

public class Formatting {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM");
        LocalDate now = LocalDate.now();
        System.out.println(now.format(formatter));
    }
}
