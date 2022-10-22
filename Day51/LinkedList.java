package Day51;

public class LinkedList<E> {
    //fields
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    //method
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public E getVal(int index) {
        if (head == null || index < 0 || index >= size) {
            return null; // or throw new IllegalArgumentException("getVal()")
        }
        ListNode<E> cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addHead(E val) {
        ListNode<E> newHead = new ListNode<E>(val);
        if (head == null) { // means tail == null too;
            tail = newHead;
        } else {
            newHead.next = head;
            head.prev = newHead;
        }
        head = newHead;
        size++;
    }

    public void addTail(E val) {
        ListNode<E> newTail = new ListNode<E>(val);
        if (tail == null) {
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

class ListNode<E> {
    //fields
    ListNode<E> next;
    ListNode<E> prev;
    E val;

    //methods
    public ListNode(E val) {
        this.val = val;
        next = null;
        prev = null;
    }

    public ListNode() {
        this(null);
    }
}
