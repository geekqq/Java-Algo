package Day66;

public class ReverseLinkedList {
    static Node head;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node prev = null;
        Node cur = head;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }

    public Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node rest = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);
        list.print();
        head = list.reverse(head);
        list.print();
        head = list.reverseLinkedList(head);
        list.print();
    }
}
