package Day291;

import Day266.ListNode;

public class LinkedList {

    private ListNode head;

    public void add(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
        } else {
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
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseRecursion(ListNode head ){
        if (head == null || head.next == null) return head;
        ListNode rest = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public int count(ListNode head) {
        if (head == null) return 0;
        if (head.next == null) return 1;
        return 1 + count(head.next);
    }

    public int countNode(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = count(head);
        if (count < k) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseInKGroup(cur, k);
        return prev;
    }


    public ListNode reverseInPair(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = reverseInPair(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public ListNode reverseByRange(ListNode head, int left, int right) {
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
        prev.next =reverse(subStart);
        subStart.next = next;
        return dummy.next;
    }

    public ListNode mergeList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow= slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode leftNode = mergeList(head);
        ListNode rightNode = mergeList(slow);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode leftNode, ListNode rightNode) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (leftNode != null && rightNode != null) {
            if (leftNode.data < rightNode.data) {
                cur.next = leftNode;
                leftNode = leftNode.next;
            } else {
                cur.next = rightNode;
                rightNode =rightNode.next;
            }
            cur = cur.next;
        }
        cur.next = leftNode != null ? leftNode : rightNode;
        return dummy.next;
    }

    public ListNode insertNode(int val) {
        ListNode node = new ListNode(val);
        if (head == null || head.data >= val) {
            node.next = head;
            head = node;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data < val) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return head;
    }


    public void removeDuplicates() {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && slow.data == fast.data) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
    }



    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        list.print(list.head);
        System.out.println("====reverse in k group====");
        list.head = list.reverseInKGroup(list.head, 4);
        list.print(list.head);
        System.out.println("====reverse list====");
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.reverseRecursion(list.head);
        list.print(list.head);
        System.out.println("====count====");
        System.out.println(list.count(list.head));
        System.out.println(list.countNode(list.head));
        System.out.println("====reverse in pairs====");
        list.head = list.reverseInPair(list.head);
        list.print(list.head);
        list.head = list.reverseInKGroup(list.head, 2);
        list.print(list.head);
        System.out.println("====reverse by range====");
        list.head = list.reverseByRange(list.head, 5, 8);
        list.print(list.head);
        System.out.println("====merge sort list====");
        list.head = list.mergeList(list.head);
        list.print(list.head);
        System.out.println("====insert node====");
        list.head = list.insertNode(0);
        list.head = list.insertNode(6);
        list.head = list.insertNode(4);
        list.head = list.insertNode(11);
        list.print(list.head);
        System.out.println("====remove duplicates====");
        list.removeDuplicates();
        list.print(list.head);

    }
}
