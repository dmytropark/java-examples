package com.parkhomenko.core.initialization;


class Test1 extends Super {
    int three = (int)Math.PI;  // That is, 3
    void printThree() { System.out.println(three); }

    Test1() {
        super();
        printThree();
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
//        t.printThree();
    }
}

class Super {
    Super() { printThree(); }
    void printThree() { System.out.println("three"); }
}