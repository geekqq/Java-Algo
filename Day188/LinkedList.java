package Day188;

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

    public static ListNode reverseByRange(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
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

    public static ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPairs(head.next.next);
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = postHead;
        return newHead;
    }

    public static ListNode insertSortNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }
            ListNode insertNode = cur;
            cur = cur.next;
            insertNode.next = prev.next;
            prev.next = insertNode;
        }
        return dummy.next;
    }

    public static ListNode reverseInKGroups(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        int count = 0;
        while (count < k && cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        if (next != null) {
            head.next = reverseInKGroups(next, k);
        }
        return prev;
    }

    public static ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
        ListNode left = mergeSortList(head);
        ListNode right = mergeSortList(slow);
        return mergeList(left, right);
    }

    private static ListNode mergeList(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val <= rightHead.val) {
                cur.next = leftHead;
                leftHead = leftHead.next;
            } else {
                cur.next = rightHead;
                rightHead = rightHead.next;
            }
            cur = cur.next;
            cur.next = leftHead != null ? leftHead : rightHead;
        }
        return dummy.next;
    }

    public void deleteNode(int val) {
        if (head == null) return;
        ListNode prev = null;
        ListNode cur = head;
        if (head != null && head.val == val) {
            head = head.next;
            return;
        }
        while (cur != null && cur.val != val) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) {
            System.out.println("the node is not present");
            return;
        }
        prev.next = cur.next;
    }

    public static void deleteNodeII(ListNode head, ListNode node) {
        if (head == null) return;
        ListNode temp = head;
        if (head == node) {
            if (head.next == null) {
                System.out.println("only one node in the linked list, head can not be deleted");
                return;
            }
            head.val = head.next.val;
            head.next = head.next.next;
        } else {
            while (temp.next != null && temp.next != node) {
                temp = temp.next;
            }
            if (temp.next == null) {
                System.out.println("the node is not present in the list !!");
                return;
            }
            temp.next = temp.next.next;
            System.gc();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.print();
        System.out.println("----reverse by range----");
        list.head = reverseByRange(list.head, 2,5);
        list.print();
        System.out.println("----insert sort node---");
        list.head = insertSortNode(list.head);
        list.print();
        System.out.println("----swap in pairs----");
        list.head = swapInPairs(list.head);
        list.print();
        System.out.println("----merge sort list----");
        list.head = mergeSortList(list.head);
        list.print();
        System.out.println("----delete head----");
        list.deleteNode(0);
        list.print();
        System.out.println("----delete tail----");
        list.deleteNode(6);
        list.print();
        System.out.println("----delete other node----");
        list.deleteNode(3);
        list.print();
        System.out.println("----delete head II ----");
        LinkedList list2 = new LinkedList();
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        list2.head = node0;
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        list2.deleteNodeII(list2.head, node4);
        list2.print();
    }
}
