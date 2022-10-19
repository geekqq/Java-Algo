package Day47;

public class LinkedList<E> { //E Generics
    //fields
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    //methods
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public E getVal(int index) {
        if (head == null || index < 0 || index > size - 1) {
            return null;  //throw new IllegalArgumentsException("getVal()");
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
        if (head == null) {
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
        if (tail == null) {  //此时head也一定是null
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
    ListNode<E> next;
    ListNode<E> prev;

    public ListNode(E val) {
        this.val = val;
        next = null;
        prev = null;
    }

    public ListNode() {
        this(null); //无参构造，ListNode创建的初始值为null,也可以设为0；
    }
}
