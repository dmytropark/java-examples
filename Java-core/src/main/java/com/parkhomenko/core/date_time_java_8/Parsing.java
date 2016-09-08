package com.parkhomenko.core.date_time_java_8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Dmytro Parkhomenko
 *         Created on 04.09.16.
 */

public class Parsing {
    public static void main(String[] args) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date = LocalDate.parse("01 02 2015", f);
        LocalTime time = LocalTime.parse("11:22");
        System.out.println(date);// 2015-01-02
        System.out.println(time);// 11:22
    }
}
