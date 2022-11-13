package Day73;

public class MergeLinkedList {

    private ListNode head;

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp= temp.next;
        }
        System.out.println();
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }

        if (h1.val < h2.val) {
            h1.next = merge(h1.next, h2);
            return h1;
        } else {
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }

    public static void main(String[] args) {
        MergeLinkedList list1 = new MergeLinkedList();
        MergeLinkedList list2 = new MergeLinkedList();
        MergeLinkedList list3 = new MergeLinkedList();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(7);
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list2.addLast(8);
        list1.print();
        list2.print();
        list3.head = list1.merge(list1.head, list2.head);
        list3.print();
    }
}
