package Day43;

import java.util.LinkedList;

public class MergeTwoSortedLinkedList {
    class ListNode {
        int value;
        ListNode prev;
        ListNode next;
        ListNode head;


        public ListNode(int value) {
            this.value = value;
            next = null;
        }

        public ListNode getNext() {
            return next;
        }
    }

    public ListNode mergeTwoLinkedList(ListNode head1, ListNode head2) {
        //corner case
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode head = new ListNode(0);
        if (head1.value < head2.value) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 =head2.next;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode cur = head;
        while (cur1 != null & cur2 != null) {
            if (cur1.value < cur2.value) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        while (cur1 != null) {
            cur.next = cur1;
        }
        while (cur2 != null) {
            cur.next = cur2;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(8);
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        System.out.println(list1);
        System.out.println(list2);
    }

}
