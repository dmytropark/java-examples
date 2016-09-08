package com.parkhomenko.core.date_time_java_8;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 * @author Dmytro Parkhomenko
 *         Created on 03.09.16.
 */

public class UnsupportedExceptionTest {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        LocalTime time = LocalTime.of(12, 12);
        try {
            System.out.println(formatter.format(time)); // java.time.temporal.UnsupportedTemporalTypeException
        } catch (UnsupportedTemporalTypeException ex) {
            System.out.println("UnsupportedTemporalTypeException raised!!!");
        }
    }
}
