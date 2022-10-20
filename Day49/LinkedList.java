package Day49;

public class LinkedList<E> {
    //fields
    private  int size;
    private ListNode<E> head;
    private ListNode<E> tail;

    //methods
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public E getVal(int index){
        if (head == null || index < 0 || index >= size) {
            return null; // throw new IllegalArgumentException("getVal");
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
        if (head == null) { // tail is null when head is null
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
    E val;
    ListNode<E> prev;
    ListNode<E> next;

    //methods
    public ListNode(E val) {
        this.val = val;
        next = null;
        prev = null;
    }
}
