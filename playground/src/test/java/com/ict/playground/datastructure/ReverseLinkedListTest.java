package com.ict.playground.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseLinkedListTest {
    @Test
    void test() {
        ReverseLinkedList.Node node1 = new ReverseLinkedList.Node(1);
        ReverseLinkedList.Node node2 = new ReverseLinkedList.Node(2);
        node1.next = node2;
        ReverseLinkedList.Node node3 = new ReverseLinkedList.Node(3);
        node2.next = node3;
        ReverseLinkedList.Node node4 = new ReverseLinkedList.Node(4);
        node3.next = node4;

        Assertions.assertEquals(
                Arrays.asList(4, 3, 2, 1), collect(ReverseLinkedList.reverse(node1)));
    }

    private static List<Integer> collect(ReverseLinkedList.Node head) {
        List<Integer> ret = new ArrayList<>();
        ReverseLinkedList.Node current = head;
        while (current != null) {
            ret.add(current.value);
            current = current.next;
        }
        return ret;
    }
}