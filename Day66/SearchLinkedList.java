package Day66;

public class SearchLinkedList {

    private static Node head;

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
            temp= temp.next;
        }
        System.out.println();
    }

    public static boolean search(Node head, int x) {
        Node temp = head;
        if (head == null) return false;
        while (temp != null) {
            if (temp.val == x) {
                return true;
            }
            temp= temp.next;
        }
        return false;
    }

    public static boolean searchRecursion(Node head, int x) {
        if (head == null) return false;
        if (head.val == x) return true;
        return searchRecursion(head.next, x);
    }

    public static void main(String[] args) {
        SearchLinkedList list = new SearchLinkedList();
        list.push(10);
        list.push(20);
        list.push(30);
        list.push(40);
        list.push(50);
        list.push(60);
        list.print();
        System.out.println(search(list.head, 20));
        System.out.println(searchRecursion(list.head, 60));
    }
}
