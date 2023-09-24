package Day305;

import Day266.ListNode;

public class LinkedList {

    private ListNode head;

    public void add(int val) {
        ListNode node = new ListNode(val);
        if (head == null) head = node;
        else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void print(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapPairs(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public static ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode subStart = prev.next;
        prev.next = null;
        ListNode subEnd = subStart;
        for (int i = left; i < right; i++) {
            subEnd = subEnd.next;
        }
        ListNode next = subEnd.next;
        subEnd.next = null;
        prev.next = reverseRecursion(subStart);
        subStart.next = next;
        return dummy.next;
    }


    public static int count(ListNode head) {
        if (head == null) return 0;
        return 1 + count(head.next);
    }

    public static int countNode(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public static ListNode reverseByK(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = countNode(head);
        if (count < k) return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseByK(cur, k);
        return prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        list.print(list.head);
        System.out.println("====reverse list====");
        list.head = reverse(list.head);
        list.print(list.head);
        list.head = reverseRecursion(list.head);
        list.print(list.head);

        System.out.println("====swap pairs====");
        list.head = swapPairs(list.head);
        list.print(list.head);
        System.out.println("====reverse by range====");
        list.head = reverseByRange(list.head, 5, 10);
        list.print(list.head);
        System.out.println("====reverse in k====");
        list.head = reverseByK(list.head, 6);
        list.print(list.head);
    }
}
