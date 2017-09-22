package com.parkhomenko.collections;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FindElementInArray {
    /**
     * Straight up Java: Object
     */
    @Test
    public void element_index_in_array_java () {

        String[] lilyFlowers = {
                "Lily of the valley",
                "Lily Elite",
                "Lily Monte Negro",
                "Lily Casa Blanca",
                "Lily of the Nile – Alba",
                "Lily Stargazer"};

        int indexOfFlower = Arrays.asList(lilyFlowers).indexOf("Lily Monte Negro");

        assertEquals(2, indexOfFlower);
    }

    /**
     * Straight up Java: Primitive
     */
    @Test
    public void element_index_in_int_array_java () {

        Integer[] twoQuarters = {1, 2, 3, 4, 5, 6};

        int endOfFirstQuarter = Arrays.asList(twoQuarters).indexOf(3);

        assertEquals(2, endOfFirstQuarter);
    }

    /**
     * Apache Commons: Object
     */
    @Test
    public void element_index_of_string_array_java_with_apache_commons() {

        String[] lilyFlowers = { "Lily of the valley", "Lily Elite",
                "Lily Monte Negro", "Lily Casa Blanca",
                "Lily of the Nile – Alba", "Lily Stargazer" };

        int indexOfFlower = ArrayUtils.indexOf(lilyFlowers, "Lily Elite");

        assertEquals(1, indexOfFlower);
    }

    /**
     * Apache Commons: Primitive
     */
    @Test
    public void element_index_of_int_array_java_with_apache_commons() {

        int [] twoQuarters = {1, 2, 3, 4, 5, 6};

        int lastMonthInFirstQuarter = ArrayUtils.indexOf(twoQuarters, 3);
        assertEquals(2, lastMonthInFirstQuarter);
    }
}
