package Day52;

public class ReverseLinkedListUsingRecursion {
    static Node head;

    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        //reverse the rest list and put the first element at the end
        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

    static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    static void push(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
    }

    public static void main(String[] args) {
        push(20);
        push(4);
        push(15);
        push(85);
        System.out.println("Given linked list is: ");
        print();

        head = reverse(head);
        System.out.println("Reversed linked list is: ");
        print();
    }
}
