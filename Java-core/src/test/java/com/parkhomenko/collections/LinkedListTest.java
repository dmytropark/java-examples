package com.parkhomenko.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class LinkedListTest {

    @Test
    public void linked_list_as_stack_behaviour() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);

//        peek(): Looks at the object at the top of this stack without removing it from the stack.
        // from Queue interface
        Integer head = linkedList.peek();

        Assert.assertEquals(3, head.intValue());
        Assert.assertEquals(3, linkedList.size());
    }
}
