package Day211;

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
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private static ListNode swapInPairs(ListNode head) {
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

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        if (count < k) return head;
        cur = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseInKGroup(cur, k);
        return prev;
    }

    public static ListNode partitionList(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;
        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall  = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        return small.next;
    }

    public static ListNode insertSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode prev = dummy;
            while (prev.next != null && cur.val > prev.next.val) {
                prev = prev.next;
            }
            ListNode insertNode = cur;
            cur = cur.next;
            insertNode.next = prev.next;
            prev.next = insertNode;
        }
        return dummy.next;
    }

    public static ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode prev = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
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
        }
        cur.next = leftHead != null ? leftHead : rightHead;
        return dummy.next;
    }

    public static ListNode insertNode(ListNode head, int x) {

        ListNode newNode = new ListNode(x);
        if (head == null || head.val >= x) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.val < x) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
        return head;
    }

    public static void deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
    }

    public static ListNode reOrderList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode firstHead = head;
        ListNode secondHead = reverse(temp);
        ListNode dummy = new ListNode(0);
        temp = dummy;
        while (fast != null && secondHead != null) {
            temp.next = firstHead;
            firstHead = firstHead.next;
            temp = temp.next;
            temp.next = secondHead;
            secondHead = secondHead.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void oddEvenList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }

    public static ListNode deleteNode(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        if (head.val == x) {
            if (head.next == null) {
                System.out.println("head is the only list, can not be deleted!");
            } else {
                head.val = head.next.val;
                head.next = head.next.next;
            }
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.val != x) {
                cur = cur.next;
            }
            if (cur.next == null) {
                System.out.println("The node is not presented!");
            }
            cur.next = cur.next.next;
        }
        return head;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        list.print();
        System.out.println("----reverse by range----");
        list.head = reverseByRange(list.head, 4,10);
        list.print();
        System.out.println("----swap in pairs----");
        list.head = swapInPairs(list.head);
        list.print();
        System.out.println("----reverse in k group----");
        list.head = reverseInKGroup(list.head, 4);
        list.print();
        System.out.println("----partition list----");
        list.head = partitionList(list.head, 5);
        list.print();
        System.out.println("----merge sort list----");
        list.head = mergeSortList(list.head);
        list.print();
        System.out.println("----reorder list----");
        list.head = reOrderList(list.head);
        list.print();
        System.out.println("----insert node----");
        list.head = insertNode(list.head, 0);
        list.head = insertNode(list.head, 4);
        list.head = insertNode(list.head, 14);
        list.head = insertNode(list.head, 15);
        list.print();
        System.out.println("----delete duplicates----");
        deleteDuplicates(list.head);
        list.print();
        System.out.println("----odd even list----");
        oddEvenList(list.head);
        list.print();
        System.out.println("----delete nodes----");
        list.head = deleteNode(list.head, 0);
        list.head = deleteNode(list.head, 14);
        list.head = deleteNode(list.head, 13);
        list.head = deleteNode(list.head, 15);
        list.print();
    }
}
