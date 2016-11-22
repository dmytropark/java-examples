package com.parkhomenko.algorithm_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Dmytro Parkhomenko
 *         Created on 20.11.16.
 */

public class Reverse {

    private static class L {
        public long i;
        public L next;

        public L(long i) {
            this.i = i;
        }
    }

    private static class Result {
        public L head;
        public L currHead;

        public Result(L currHead, L head) {
            this.head = head;
            this.currHead = currHead;
        }
    }

    private static Result reverseV2(L head) {

        if (head.next == null) {
            L newHead = new L(head.i);
            return new Result(newHead, newHead);
        }

        Result result = reverseV2(head.next);
        L prev = result.currHead;
        prev.next = new L(head.i);
        return new Result(prev.next, result.head);
    }

    public static L trueReverse(L head) {
        Result reverse = reverseV2(head);
        return reverse.head;
    }

    public static L reverse(L head) {

        if(head == null) {
            return null;
        }

        List<L> tmpList = new ArrayList<>();
        L curr = head;
        while(curr != null) {
            tmpList.add(curr);
            curr = curr.next;
        }

        if(tmpList.size() == 1 ) {
            return tmpList.get(0);
        }

        Collections.reverse(tmpList);

        tmpList.get(tmpList.size() - 1).next = null;

        Iterator<L> frontIterator = tmpList.iterator();
        Iterator<L> followedIterator = tmpList.subList(1, tmpList.size()).iterator();

        L next = frontIterator.next();
        L newHead = next;

        while(followedIterator.hasNext()) {
            next.next = followedIterator.next();
            next = frontIterator.next();
        }

        return newHead;
    }

    public static void print(L head) {
        System.out.println("Print:");
        L curr = head;
        while (curr != null) {
            System.out.println(curr.i);
            curr = curr.next;
        }
    }

    public static L reverseV3(L list) {
        if (list == null) return null; // first question

        if (list.next == null) return list; // second question

        // third question - in Lisp this is easy, but we don't have cons
        // so we grab the second element (which will be the last after we reverse it)

        L secondElem = list.next;

        // bug fix - need to unlink list from the rest or you will get a cycle
        list.next = null;

        // then we reverse everything from the second element on
        L reverseRest = reverseV3(secondElem);

        // then we join the two lists
        secondElem.next = list;

        return reverseRest;
    }

    public static void main(String[] args) {
        L head = new L(0) ;
        L item1 = new L(1) ;
        head.next = item1;
        L item2 = new L(2);
        item1.next = item2;
        L item3 = new L(3);
        item2.next = item3;
        item3.next = null;

        print(head);
//        L reverse = reverse(head);
//        L reverse = trueReverse(head);
        L reverse = reverseV3(head);
        print(reverse);
    }
}
