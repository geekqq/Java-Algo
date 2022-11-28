package Day88;

public class MergeLinkedList2 {
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
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
    public void print() {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode merge2(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;
        while (true) {
            if (head1 == null) {
                tail.next = head2;
                break;
            }
            if (head2 == null) {
                tail.next = head1;
                break;
            }
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1= head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        MergeLinkedList2 list1 = new MergeLinkedList2();
        MergeLinkedList2 list2 = new MergeLinkedList2();
        MergeLinkedList2 list3 = new MergeLinkedList2();
        list1.add(0);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(1);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list3.head = merge2(list1.head, list2.head);
        list3.print();
    }
}
