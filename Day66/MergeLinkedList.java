package Day66;

public class MergeLinkedList {
    Node head;

    public void addToLast(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = temp;
        }
    }

    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeLinkedList list1 = new MergeLinkedList();
        list1.addToLast(12);
        list1.addToLast(14);
        list1.addToLast(16);
        list1.addToLast(18);
        list1.addToLast(20);
        list1.print();

        MergeLinkedList list2 = new MergeLinkedList();
        list2.addToLast(13);
        list2.addToLast(15);
        list2.addToLast(17);
        list2.addToLast(18);
        list2.addToLast(19);
        list2.print();

        MergeLinkedList list3 = new MergeLinkedList();
        list3.head = merge(list1.head, list2.head);
        list3.print();
    }

    public static Node merge(Node h1, Node h2) {
        Node dummyNode = new Node(0);
        Node tail = dummyNode;
        while (true) {
            if (h1 == null) {
                tail.next = h2;
                break;
            }
            if (h2 == null) {
                tail.next = h1;
                break;
            }

            if (h1.val <= h2.val) {
                tail.next = h1;
                h1 = h1.next;
            } else {
                tail.next = h2;
                h2 = h2.next;
            }
            tail = tail.next;
        }
        return dummyNode.next;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        next =null;
    }
}