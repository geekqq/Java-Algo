package Day65;

import org.w3c.dom.Node;

public class SearchLinkedList {
    Node head;
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

    public void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp =temp.next;
        }
        System.out.println();
    }

    public boolean searchLinkedList(Node head, int x) {
        Node temp = head;
        if (head == null) return false;
        while (temp != null) {
            if (temp.val == x) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean searchUsingRecursion(Node head, int x) {
        //base case
        if (head == null) return false;
        if (head.val == x) return true;
        return searchUsingRecursion(head.next, x);
    }

    public static void main(String[] args) {
        SearchLinkedList list = new SearchLinkedList();
        list.push(10);
        list.push(20);
        list.push(11);
        list.push(21);
        list.push(14);
        list.print(list.head);
        if (list.searchLinkedList(list.head, 2)) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }

        if (list.searchUsingRecursion(list.head, 3)) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }
    }
}
