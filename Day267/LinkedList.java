package Day267;

import Day266.ListNode;

public class LinkedList {

    private ListNode head;

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) head = newNode;
        else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void print(ListNode head) {
        ListNode cur = head;
        if (head == null) return;
        System.out.print(head.data + " ");
        print(head.next);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public int countNode(ListNode head) {
        if (head == null) return 0;
        return 1 + countNode(head.next);
    }

    public int countNodeIt(ListNode head) {
        if (head == null) return 0;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPairs(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode subStart = pre.next;
        pre.next = null;
        ListNode subEnd = subStart;
        for (int i = left; i < right; i++) {
            subEnd = subEnd.next;
        }
        ListNode next = subEnd.next;
        subEnd.next = null;
        pre.next = reverse(subStart);
        subStart.next = next;

        return dummy.next;
    }

    public ListNode reverseByK(ListNode head, int k) {
        if (head == null) return head;
        int count = countNode(head);
        if (count < k) return head;
        ListNode prev = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseByK(cur, k);
        return prev;
    }

    public ListNode reOrder(ListNode head) {
        //if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode firstHead = head;
        ListNode secondHead = reverseI(temp);
        ListNode dummy = new ListNode();
        temp = dummy;
        while (firstHead != null && secondHead != null) {
            temp.next = firstHead;
            firstHead = firstHead.next;
            temp = temp.next;

            temp.next = secondHead;
            secondHead = secondHead.next;
            temp = temp.next;
        }
        temp.next = (firstHead != null ? firstHead : secondHead);
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.print(list.head);
        System.out.println("---reverse list---");
        list.head = list.reverse(list.head);
        list.print(list.head);
        System.out.println();
        list.head = list.reverseI(list.head);
        list.print(list.head);
        System.out.println("---count node---");
        System.out.println(list.countNode(list.head));
        System.out.println(list.countNodeIt(list.head));
        System.out.println("---swap in pairs---");
        list.head = list.swapInPairs(list.head);
        list.print(list.head);
        System.out.println();
        System.out.println("---reverse by range---");
        list.head = list.reverseByRange(list.head, 3, 10);
        list.print(list.head);
        System.out.println();
        System.out.println("---reverse by k---");
        list.head = list.reverseByK(list.head, 4);
        list.print(list.head);
        System.out.println();
        System.out.println("---reorder list---");
        list.head = list.reOrder(list.head);
        list.print(list.head);
        System.out.println();
    }
}
