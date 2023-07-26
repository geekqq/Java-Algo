package Day262;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void addFirst(int val) {
        ListNode temp = new ListNode(val);
        if (last == null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    public void addLast(int val) {
        ListNode temp = new ListNode(val);
        if (last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public ListNode removeFirst() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        ListNode temp = last.next;
        if (last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }
    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);
        ListNode fifth = new ListNode(20);

        first.next = second;
        length++;
        second.next = third;
        length++;
        third.next = fourth;
        length++;
        fourth.next = fifth;
        length++;
        fifth.next = first;
        length++;
        last = fifth;
    }

    public void print() {
        if (last == null) return;
        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.val + " ");
            first = first.next;
        }
        System.out.print(first.val + "\n");
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        //csll.createCircularLinkedList();
        csll.print();
        System.out.println("----add first----");
        csll.addFirst(0);
        csll.addFirst(0);
        csll.addFirst(2);
        csll.print();
        System.out.println(csll.length);
        System.out.println("----add last----");
        csll.addLast(3);
        csll.addLast(4);
        csll.addLast(5);
        csll.print();
        System.out.println(csll.length);
        System.out.println("----remove first----");
        csll.removeFirst();
        csll.print();
        csll.removeFirst();
        csll.print();
    }
}
