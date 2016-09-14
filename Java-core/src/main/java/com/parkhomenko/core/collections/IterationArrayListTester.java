package com.parkhomenko.core.collections;

import java.util.Iterator;

/**
 * @author Dmytro Parkhomenko
 *         Created on 12.09.16.
 */

public class IterationArrayListTester {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
//
//        Iterator<Integer> itr = list.iterator();
//
//        while(itr.hasNext()) {
//            int curr = itr.next();
//            if(curr == 1) {
//                itr.remove();
//            }
//        }
//
//        System.out.println(list);
//
//        ///
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
//
//        Iterator<Integer> itr1 = list1.listIterator();
//
//        while(itr1.hasNext()) {
//            int curr = itr1.next();
//            if(curr == 1) {
//                itr1.remove();
//            }
//        }
//
//        System.out.println(list1);

        ///
        ///
//        List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
//        Iterator<Integer> itr2 = list2.listIterator();
//        while(itr2.hasNext()) {
//            int curr = itr2.next();
//            if(curr == 1) {
//                list2.remove(0);
//            }
//        }
//        System.out.println(list2);


//        List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
//        for(int index = 0; index < list2.size(); index++) {
//
//            System.out.println("index = " + index);
//
//            if(list2.get(index) == 1) {
//                list2.add(24);
//            }
//        }
//        System.out.println(list2);

//                List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
//        for(int index = 0; index < list2.size(); index++) {
//
//            System.out.println("index = " + index + " value = " + list2.get(index));
//
//            if(list2.get(index) == 0) {
//                list2.remove(0);
//            }
//        }
//        System.out.println(list2);
    }
}

class test implements Iterator<Integer> {


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
