package Day275;

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
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.print("null");
    }

    public static ListNode reverseRe(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseRe(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static ListNode reverseIt(ListNode head) {
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

    public static ListNode swapInPair(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPair(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public static int countNode(ListNode head) {
        ListNode cur = head;
        if (head == null) return 0;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public static int countNodeRe(ListNode head) {
        if (head == null) return 0;
        return 1 + countNodeRe(head.next);
    }

    public static ListNode reverseByK(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
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

    public static ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return  head;
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
        prev.next = reverseRe(subStart);
        subStart.next = next;
        return dummy.next;
    }

    public static ListNode mergeList(ListNode head) {
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
        ListNode leftHead = mergeList(head);
        ListNode rightHead = mergeList(slow);
        return mergeTwoSortedArray(leftHead, rightHead);
    }

    public static ListNode mergeTwoSortedArray(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (leftHead != null && rightHead != null) {
            if (leftHead.data < rightHead.data) {
                cur.next = leftHead;
                leftHead = leftHead.next;
            } else {
                cur.next = rightHead;
                rightHead = rightHead.next;
            }
            cur = cur.next;
        }
        cur.next = (leftHead != null ? leftHead : rightHead);
        return dummy.next;
    }

    public static ListNode insertNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data < val) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 11; i++) {
            list.addLast(i);
        }
        System.out.println("====original list====");
        list.print(list.head);
        System.out.println("===reverse====");
        list.print(list.head = reverseIt(list.head));
        System.out.println();
        list.print(list.head = reverseRe(list.head));
        System.out.println("====swap in pairs");
        list.print(list.head = swapInPair(list.head));
        System.out.println("====count node====");
        System.out.println(countNode(list.head));
        System.out.println(countNodeRe(list.head));
        System.out.println("====reverse by ke====");
        list.head = reverseByK(list.head, 4);
        list.print(list.head);
        System.out.println("====reverse by range====");
        list.print(list.head = reverseByRange(list.head, 5, 9));
        System.out.println("====merge sort list====");
        list.head = mergeList(list.head);
        list.print(list.head);
        System.out.println("====insert new node====");
        list.head = insertNode(list.head,0);
        list.head = insertNode(list.head,5);
        list.head = insertNode(list.head,11);
        list.print(list.head);


    }
}
class ListNode {
    int data;
    ListNode next;
    public ListNode(int data) {
        this.data = data;
        next = null;
    }

    public ListNode() {
        this(0);
    }
}
