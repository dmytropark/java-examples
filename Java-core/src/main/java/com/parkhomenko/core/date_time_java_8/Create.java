package com.parkhomenko.core.date_time_java_8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * @author Dmytro Parkhomenko
 *         Created on 04.09.16.
 */

public class Create {

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        LocalDate localDate = LocalDate.of(2016, Month.APRIL, 21);
        localDate = localDate.plusDays(1);
        System.out.println(localDate);
        localDate = localDate.plusWeeks(1);
        System.out.println(localDate);
        localDate = localDate.plus(1, ChronoUnit.DAYS);
        System.out.println(localDate);
    }
}
