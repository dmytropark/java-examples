package com.parkhomenko.arrays_code_chalange;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SumUpTwoItemsTest {

    @Test
    public void sumUpImplTest() {
        int [] source = {2, 1, 5, 7, 3, 10};
        int[] sumUp2ItemIndices = sumUp2Items(source, 4);

        Assert.assertEquals(1, sumUp2ItemIndices[0]);
        Assert.assertEquals(4, sumUp2ItemIndices[1]);
    }

    private int[] sumUp2Items(int [] source, int target) {
        Map<Integer, Integer> map = new HashMap<>(source.length);

        for (int i = 0; i < source.length; i++) {
            Integer j = map.get(source[i]);

            if(j != null) {
                return new int[] {j, i};
            }

            map.put(target - source[i], i);
        }

        return new int [] {};
    }
}
