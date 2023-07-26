package Day261;

import Day243.LeapGame;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }
    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;

        }

        public ListNode() {
            this(0);
        }
    }

    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        length++;
        ListNode second = new ListNode(5);
        length++;
        ListNode third = new ListNode(10);
        length++;
        ListNode fourth = new ListNode(15);
        length++;

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        last = fourth;
    }

    public void print() {
        if (last == null) return;
        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.val + " ");
            first = first.next;
        }
        System.out.print(last.val + "\n");
    }

    public void addFirst(int val) {
        ListNode temp;
    }

    public static void main(String[] args) {
        ListNode newNode = new ListNode();
        System.out.println(newNode.val);
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCircularLinkedList();
        csll.print();
        System.out.println(csll.length);
    }
}
