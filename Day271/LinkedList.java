package Day271;

public class LinkedList {

    private ListNode head;

    class ListNode {
        int data;
        ListNode next;

        public ListNode() {
            this(0);
        }

        public ListNode(int data) {
            this.data = data;
            next = null;
        }
    }

    public void addLast(int val) {
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
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " --> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode swapInPair(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPair(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public ListNode reverseByRange(ListNode head, int left, int right) {
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
        pre.next = reverseRecursion(subStart);
        subStart.next = next;

        return dummy.next;
    }

    public int countNode(ListNode head) {
        if (head == null) return 0;
        return 1 + countNode(head.next);
    }

    public int countNodeI(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode reverseByK(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int count = countNode(head);
        if (count< k) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
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
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        System.out.println(list);
        list.print(list.head);
        System.out.println("---add first---");
        list.addFirst(6);
        list.print(list.head);
        System.out.println("---reverse list---");
        list.head = list.reverse(list.head);
        list.print(list.head);
        list.head = list.reverseRecursion(list.head);
        list.print(list.head);
        System.out.println("---swap in pairs---");
        list.head = list.swapInPair(list.head);
        list.print(list.head);

        System.out.println("---count node---");
        int n = list.countNode(list.head);
        System.out.println(n);
        System.out.println(list.countNodeI(list.head));

        System.out.println("---reverse by range---");
        list.print(list.reverseByRange(list.head, 4, 8));
        System.out.println("---reverse by k---");
        list.print(list.reverseByK(list.head, 4));

    }
}
