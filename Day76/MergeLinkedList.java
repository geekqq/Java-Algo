package Day76;

public class MergeLinkedList {

    private ListNode head;

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next= null;
        }
    }

    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode mergeLinkedList(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }

        if (h1.val < h2.val) {
            h1.next = mergeLinkedList(h1.next, h2);
            return h1;
        } else {
            h2.next = mergeLinkedList(h1, h2.next);
            return h2;
        }
    }

    public static void main(String[] args) {
        MergeLinkedList list1 = new MergeLinkedList();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(7);
        list1.addLast(9);
        MergeLinkedList list2 = new MergeLinkedList();
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list2.addLast(8);
        list2.addLast(10);
        MergeLinkedList list3 = new MergeLinkedList();
        list3.head = mergeLinkedList(list1.head, list2.head);
        list3.print();
    }
}
