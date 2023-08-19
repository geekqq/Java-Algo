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
