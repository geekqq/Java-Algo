package Day72;

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
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void print() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode mergeRecursion(ListNode hA, ListNode hB) {
        if (hA == null) {
            return hB;
        }
        if (hB == null) {
            return hA;
        }

        if (hA.val < hB.val) {
            hA.next = mergeRecursion(hA.next, hB);
            return hA;
        } else {
            hB.next = mergeRecursion(hA, hB.next);
            return hB;
        }
    }

    public static void main(String[] args) {
        MergeLinkedList list1 = new MergeLinkedList();
        MergeLinkedList list2 = new MergeLinkedList();
        MergeLinkedList list3 = new MergeLinkedList();
        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list2.addLast(3);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(10);
        list3.head = mergeRecursion(list1.head, list2.head);
        list3.print();
    }
}
