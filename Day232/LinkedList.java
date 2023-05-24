package Day232;

import Day174.ListNode;

public class LinkedList {

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

    public void print(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + ",");
        print(head.next);
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPairs(head.next.next);
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = postHead;
        return newHead;
    }

    public static ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
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
        prev.next = reverse(subStart);
        subStart.next = next;
        return dummy.next;
    }

    public static ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(slow);
        return merge(left, right);
    }
    private static ListNode merge(ListNode leftNode, ListNode rightNode) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                cur.next = leftNode;
                leftNode = leftNode.next;
            } else {
                cur.next = rightNode;
                rightNode = rightNode.next;
            }
            cur = cur.next;
            cur.next = leftNode != null ? leftNode : rightNode;
        }
        return dummy.next;
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        if (count < k) return head;
        ListNode prev = null;
        cur = head;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            next  = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseInKGroup(cur, k);
        return prev;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.print(list.head);
        System.out.println();
        list.print();
        System.out.println("---------------");
        list.head = reverse(list.head);
        list.print();
        list.head = reverseI(list.head);
        list.print();
        System.out.println("---------------");
        list.head = swapInPairs(list.head);
        list.print();
        System.out.println("---------------");
        list.head = reverseByRange(list.head, 3,6);
        list.print();
        System.out.println("---------------");
        list.head = mergeSortList(list.head);
        list.print();
        System.out.println("---------------");
        list.head = reverseInKGroup(list.head, 4);
        list.print();
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
    }


}
