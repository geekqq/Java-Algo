package Day264;

public class LinkedList {

    private ListNode head;

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        public ListNode() {
            this(0);
        }
    }

    public void addLast(int val) {
        ListNode temp = new ListNode(val);
        if (head == null) head = temp;
        else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = temp;
        }
    }

    public void print() {
        ListNode temp = head;
        if (head == null) return;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public ListNode reverseList() {
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

    public ListNode reverseListI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseListI(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode reverseRange(ListNode head, int left, int right) {
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
        prev.next = reverseListI(subStart);
        subStart.next = next;

        return dummy.next;
    }


    public int countNode(ListNode head) {
        if (head == null) return 0;
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public ListNode reverseInKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        int count = countNode(head);
        if (count < k) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseInKGroup(cur, k);
        return prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 11; i++) {
            list.addLast(i);
        }
        list.print();
//        list.head = list.reverseList();
//        list.print();
        list.head = list.reverseListI(list.head);
        list.print();
        System.out.println("---reverse by range----");
        list.head = list.reverseRange(list.head, 2, 5);
        list.print();
        System.out.println("---reverse in k group----");
        list.head = list.reverseInKGroup(list.head, 4);
        list.print();
        System.out.println("----count node----");
        System.out.println(list.countNode(list.head));
    }
}
