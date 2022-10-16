package Day45;

public class LinkedList {

    static class ListNode {
        int value;
        ListNode next;
        ListNode prev;

        //constructor
        ListNode(int value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    static class MergeLists {
        ListNode head;

        public void addToList(ListNode node) {
            if (head == null) {
                head = node;
            } else {
                ListNode cur = head;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = node;

            }
        }
        public void printList() {
                ListNode cur = head;
                while (cur != null) {
                    System.out.print(cur.value + " ");
                    cur = cur.next;
                }
                System.out.println();
            }

    }


    static class Geek {
        public static ListNode mergeTwoSortedLinkedList(ListNode headA, ListNode headB) {
            if (headA == null) return headB;
            if (headB == null) return headA;


            ListNode dummyNode = new ListNode(0);
            ListNode cur = dummyNode;
            while (true) {
                if (headA == null) {
                    cur = headB;
                    break;
                }
                if (headB == null) {
                    cur = headA;
                    break;
                }

                if (headA.value <= headB.value) {
                    cur.next = headA;
                    headA = headA.next;
                } else {
                    cur.next = headB;
                    headB = headB.next;
                }
                cur = cur.next;
            }
            return dummyNode.next;
        }
    }

    public static void main(String[] args) {
        MergeLists llist1 = new MergeLists();
        llist1.addToList(new ListNode(1));
        llist1.addToList(new ListNode(3));
        llist1.addToList(new ListNode(5));
        llist1.addToList(new ListNode(7));

        MergeLists llist2 = new MergeLists();
        llist2.addToList(new ListNode(2));
        llist2.addToList(new ListNode(4));
        llist2.addToList(new ListNode(6));
        llist2.addToList(new ListNode(8));

        llist1.printList();
        llist2.printList();
        llist2.head = Geek.mergeTwoSortedLinkedList(llist1.head, llist2.head);
        llist2.printList();
    }
}
