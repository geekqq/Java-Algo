package Day44;

public class LinkedListDemo {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static class MergeLists {
        Node head;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp =temp.next;
        }
        System.out.println();
    }

    }

    public static void main(String[] args) {
        MergeLists llist1 = new MergeLists();
        MergeLists llist2 = new MergeLists();

        llist1.addToTheLast(new Node(5));
        llist1.addToTheLast(new Node(10));
        llist1.addToTheLast(new Node(15));

        llist2.addToTheLast(new Node(2));
        llist2.addToTheLast(new Node(3));
        llist2.addToTheLast(new Node(20));

        System.out.println(llist1.head.data);
        System.out.println(llist2.head.data);

        llist1.printList();
        llist2.printList();
        System.out.println("------------");
        llist1.head = new Gfg().sortedMerge(llist1.head, llist2.head);
        llist1.printList();

    }

    static class Gfg {
        Node sortedMerge(Node headA, Node headB) {
            if (headA == null) return headB;
            if (headB == null) return headA;

            Node dummyNode = new Node(0);
            Node tail = dummyNode;
            while (true) {
                if (headA == null) {
                    tail.next = headB;
                    break;
                }
                if (headB == null) {
                    tail.next = headA;
                    break;
                }

                if (headA.data <= headB.data) {
                    tail.next = headA;
                    headA = headA.next;
                } else {
                    tail.next = headB;
                    headB = headB.next;
                }
                tail = tail.next;
            }
            return dummyNode.next;
        }
    }
}
