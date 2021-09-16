package com.ict.playground.datastructure;

/**
 * 反转一个单链表
 * 例：1->2->3->4 转为 4->3->2->1
 *
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;

        print(node1);
        System.out.println();
        print(reverse(node1));
    }

    /**
     * 翻转一个单链表
     * 传递的参数是原始链表的头节点
     * 返回翻转后的链表的头节点
     * @param head 原始链表的头节点
     * @return 返回翻转后的链表的头节点
     */
    public static Node reverse(Node head) {
        // todo
        //前后指针
        Node pre = new Node(-1);
        pre = head;
        Node next = new Node(0);
        next = head.next;
        if (head == null || head.next == null){
            return head;
        }
        // 跳到最后一个节点,保留前一个节点
        while (next!=null){
            // 将next插到head前面
            pre.next = next.next;
            next.next = head;
            // head前移，next后移
            head = next;
            next = pre.next;
        }
        return head;
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
    }
}