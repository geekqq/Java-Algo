package Day53;

public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addHead(int val) {
        ListNode newHead = new ListNode(val);
        if (tail == null) {
            tail = newHead;
        } else {
            newHead.next = head;
            head.prev = newHead;
        }
        head = newHead;
        size++;
    }
    public void addTail(int val) {
        ListNode newTail = new ListNode(val);
        if (head == null) {
            head = newTail;
        } else {
            tail.next = newTail;
            newTail.prev = tail;
        }
        tail = newTail;
        size++;
    }

    public int getSize() {
        return size;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int val) {
        this.val = val;
        next = null;
        prev = null;
    }
}