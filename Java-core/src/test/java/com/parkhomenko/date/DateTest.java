package com.parkhomenko.date;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {

    @Test
    public void test_1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String real = simpleDateFormat.format(java.sql.Timestamp.valueOf(LocalDateTime.of(1991, Month.OCTOBER, 1, 0, 0)));
        Assert.assertEquals("1991-10-01", real);
    }

    @Test
    public void test_2() {
        String real = LocalDateTime.of(1991, Month.OCTOBER, 1, 0, 0).format(DateTimeFormatter.ISO_DATE);

        Assert.assertEquals("1991-10-01", real);
    }

    @Test
    public void test_3() {
        String real = LocalDateTime.of(1991, Month.OCTOBER, 1, 0, 0).format(DateTimeFormatter.ISO_DATE);
//        DateTimeFormatter.ISO_DATE;
    }

}
