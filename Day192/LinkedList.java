package Day192;

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

    public static ListNode swapInPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPairs(head.next.next);
        head.next.next = head;
        ListNode newHead = head.next;
        head.next = postHead;
        return newHead;
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
        return mergeList(left, right);
    }

    private static ListNode mergeList(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val < rightHead.val) {
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

    public static ListNode reverseInKGroups(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
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

    public static ListNode reverseInKGroupsII(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode prev = null;
        cur = head;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseInKGroupsII(cur, k);
        return prev;
    }

    public static ListNode reorderList(ListNode head) {
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
        ListNode cur = dummy;
        while (firstHead != null && secondHead != null) {
            cur.next = firstHead;
            firstHead = firstHead.next;
            cur = cur.next;
            cur.next = secondHead;
            secondHead = secondHead.next;
            cur = cur.next;
        }
        cur.next = firstHead != null ? firstHead : secondHead;
        return dummy.next;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
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
        return head;
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            if (head.next == null) {
                System.out.println("head is the only node in the list, can not be deleted");
            } else {
                head.val = head.next.val;
                head.next = head.next.next;
            }
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.val != val) {
                cur = cur.next;
            }
            if (cur.next == null) {
                System.out.println("the node is not presented!");
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.print();
        System.out.println("----reverse by range----");
        list.head = reverseByRange(list.head, 2,5);
        list.print();
        System.out.println("----insert sort list----");
        list.head = insertSortList(list.head);
        list.print();
        System.out.println("----swap in pairs----");
        list.head = swapInPairs(list.head);
        list.print();
        System.out.println("----swap in pairs");
        list.head = swapInPairs(list.head);
        list.print();
        System.out.println("----merge sort list----");
        list.head = mergeSortList(list.head);
        list.print();
        System.out.println("---- reverse in k groups----");
        list.head = reverseInKGroups(list.head, 6);
        list.print();
        System.out.println("----reverse in k gourps II----");
        list.head = reverseInKGroupsII(list.head, 6);
        list.print();
        System.out.println("----reorder list----");
        list.head = reorderList(list.head);
        list.print();
        System.out.println("----odd even list----");
        list.head = oddEvenList(list.head);
        list.print();
        System.out.println("----sort list----");
        list.head = mergeSortList(list.head);
        list.print();
        System.out.println("----delete head----");
        list.head = deleteNode(list.head, 0);
        list.print();
        System.out.println("----delete tail----");
        list.head = deleteNode(list.head, 9);
        list.print();
        System.out.println("----delete middle node----");
        list.head = deleteNode(list.head, 5);
        list.print();

    }
}
