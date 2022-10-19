package Day48;

public class LinkedList<E> {//Generics 泛型数据
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
        if (head == null || index < 0 || index >= size) {
            return null; //throw new IllegalArgumentsException("getVal()")
        }
        ListNode<E> cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addHead(E val) {
        ListNode newHead = new ListNode<E>(val);
        if (head == null) {
            head = newHead; //or tail = newHead;
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
    ListNode<E> next;
    ListNode<E> prev;

    //methods
    public ListNode(E val) {
        this.val = val;
        prev = null;
        next = null;
    }

    public ListNode() {
        this(null); //初始值可以任意赋值
    }
}
