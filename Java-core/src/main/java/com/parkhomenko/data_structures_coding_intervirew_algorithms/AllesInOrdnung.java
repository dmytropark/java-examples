package com.parkhomenko.data_structures_coding_intervirew_algorithms;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AllesInOrdnung {

    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        List temp = ar; //1
        temp.add(new Date());
        temp.add(new Float(1.66));
        Iterator it = ar.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(ar.get(0));
    }
}
