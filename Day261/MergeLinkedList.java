package Day261;

public class MergeLinkedList {
    private ListNode head;

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
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " --> ");
            cur = cur.next;
        }
        System.out.println("null\n");
    }

    public static ListNode mergeLinkedList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur1 != null) {
            cur.next = cur1;
        } else {
            cur.next = cur2;
        }

        return dummy.next;
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        if (head1 == null ) return head2;
        if (head2 == null) return head1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int x = head1 == null ? 0 : head1.val;
            int y = head2 == null ? 0 : head2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        MergeLinkedList list1 = new MergeLinkedList();
        MergeLinkedList list2 = new MergeLinkedList();
        MergeLinkedList result = new MergeLinkedList();
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(9);
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list1.print();
        list2.print();
        result.head = mergeLinkedList(list1.head, list2.head);
        result.print();
        MergeLinkedList sum = new MergeLinkedList();
        System.out.println("-----------add two numbers-----------------");
        list1.print();
        list2.print();
        sum.head = addTwoNumbers(list1.head, list2.head);
        sum.print();
    }
}

