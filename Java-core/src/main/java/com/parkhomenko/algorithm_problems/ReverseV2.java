package com.parkhomenko.algorithm_problems;

/**
 * @author Dmytro Parkhomenko
 *         Created on 22.11.16.
 */

public class ReverseV2 {

    private static class L {
        public long i;
        public L next;

        public L(long i) {
            this.i = i;
        }
    }

    public static L reverse(L list) {

        if(list == null) {
            return null;
        }

        if(list.next == null) {
            return list;
        }

        L a = list;
        L b = a.next;
        L c = b.next;

        a.next = null;

        while (true) {
            b.next = a;

            if(c == null) {
                return b;
            } else {
                a = b;
                b = c;
                c = c.next;
            }
        }
    }

    public static void print(L list) {
        while(list != null) {
            System.out.print(list.i + " ");
            list = list.next;
        }
        System.out.println();
    }

    private L head = null;
    private L end = head;

    public ReverseV2 add(long i) {
        L item = new L(i);

        if(end == null) {
            head = end = item;
        } else {
            end.next = item;;
            end = item;
        }

        return this;
    }

    public L getHead() {
        return head;
    }

    public static void main(String[] args) {
        ReverseV2 reverse = new ReverseV2();
        L list = reverse
                .add(0)
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .getHead();

        ReverseV2.print(list);
        L reversed = ReverseV2.reverse(list);
        ReverseV2.print(reversed);
    }
}
