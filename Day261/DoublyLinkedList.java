package Day261;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode {
        private int val;
        private ListNode next;
        private ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) tail = newNode;
        else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void printForward() {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " --> ");
            cur = cur.next;
        }
        System.out.println("null\n");
    }

    public void printBackward() {
        if (tail == null) return;
        ListNode cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " --> ");
            cur = cur.prev;
        }
        System.out.println("null\n");
    }

    public void deleteFirst() {
        if (isEmpty()) return;
        if (head.next == null) return;
        head = head.next;
        head.prev = null;
    }

    public ListNode deleteFirstAndReturnFirstNode() {
        if (isEmpty()) {
            throw new NoSuchElementException("No node to be deleted!");
        } else if (head == tail) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        ListNode temp = head;
        head = head.next;
        length--;
        return temp;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addLast(4);
        dll.addLast(6);
        dll.addLast(2);
        dll.addLast(8);
        dll.addLast(5);
        dll.printForward();
        dll.printBackward();
        System.out.println("----add first----");
        dll.addFirst(1);
        dll.printForward();
        dll.printBackward();
        System.out.println("----delete the first----");
        dll.deleteFirst();
        dll.printForward();
        dll.printBackward();
        System.out.println("----delete the first and return it----");
        System.out.println(dll.deleteFirstAndReturnFirstNode().val);
        System.out.println(dll.deleteFirstAndReturnFirstNode().val);
        System.out.println(dll.deleteFirstAndReturnFirstNode().val);
        System.out.println(dll.deleteFirstAndReturnFirstNode().val);
        System.out.println(dll.deleteFirstAndReturnFirstNode().val);
        System.out.println(dll.deleteFirstAndReturnFirstNode().val);
    }
}
