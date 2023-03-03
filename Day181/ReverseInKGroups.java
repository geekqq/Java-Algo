package Day181;

import Day174.ListNode;

public class ReverseInKGroups {
    private ListNode head;

    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode reverseInKList(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        int count = 0;
        while (prev != null && count < k) {
            prev = prev.next;
            count++;
        }
        if (count == k) {
            prev = reverseInKList(prev, k);
            ListNode cur = head;
            ListNode post = head.next;

            while (count-- > 0) {
                post = cur.next;
                cur.next = prev;
                prev = cur;
                cur = post;
            }
        }
        return prev;
    }

    private static ListNode reverseKGroupII(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = dummy;
        ListNode next = dummy;
        int count = 0;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        while (count >= k) {
            cur = prev.next;
            next = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = cur.next;
            }
            prev = cur;
            count -= k;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseInKGroups list = new ReverseInKGroups();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        list.print();
        list.head = reverseKGroupII(list.head, 4);
        list.print();
    }
}
