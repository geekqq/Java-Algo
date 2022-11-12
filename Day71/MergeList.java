package Day71;

public class MergeList {
    Node head;

    public void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node mergeSorted(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }

        if (headA.val < headB.val) {
            headA.next = mergeSorted(headA.next, headB);
            return headA;
        } else {
            headB.next = mergeSorted(headA, headB.next);
            return headB;
        }

    }

    public static void main(String[] args) {
        MergeList list1 = new MergeList();
        MergeList list2 = new MergeList();
        MergeList list3 = new MergeList();
        list1.head = new Node(0);
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(6);
        list1.addLast(8);
        list1.addLast(10);
        list1.print();
        list2.head = new Node(1);
        list2.addLast(3);
        list2.addLast(5);
        list2.addLast(7);
        list2.addLast(9);
        list2.addLast(11);
        list2.print();
        list3.head = mergeSorted(list1.head, list2.head);
        list3.print();
    }

}

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        next  = null;
    }
}