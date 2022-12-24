package Day114;

public class MergeLinkedList {
    private ListNode head;
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    public void add(int val) {
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
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        while (true) {
            if (head1 == null) {
                tail.next= head2;
                break;
            }
            if (head2 == null) {
                tail.next = head1;
                break;
            }
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail =  tail.next;
        }
        return dummyNode.next;
    }
    public static ListNode merge2(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head1.next = merge2(head1.next, head2);
            return head1;
        } else {
            head2.next = merge2(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        MergeLinkedList list1 = new MergeLinkedList();
        MergeLinkedList list2 = new MergeLinkedList();
        MergeLinkedList list3 = new MergeLinkedList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.print();
        list2.add(2);
        list2.add(3);
        list2.add(3);
        list2.add(3);
        list2.add(4);
        list2.print();
        list3.head = merge2(list1.head, list2.head);
        list3.print();
    }
}
