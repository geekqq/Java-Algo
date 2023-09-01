package Day285;



public class LinkedList {
    public ListNode head;

    public void add(int data) {
        ListNode node = new ListNode(data);
        if (head == null) head = node;
        else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void print() {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l2.data : 0;
            int y = l2 != null ? l2.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
        //cc
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode();
        ListNode curSum = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int sum = 0;

        while (cur1 != null || cur2 != null || sum != 0) {
            if (cur1 != null) {
                sum += cur1.data;
                cur1 = cur1.next;
            }

            if (cur2 != null) {
                sum += cur2.data;
                cur2 = cur2.next;
            }

            curSum.next = new ListNode(sum % 10);
            curSum = curSum.next;
            sum /= 10;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList l3 = new LinkedList();
        l1.add(2);
        l1.add(4);
        l1.add(3);
        l2.add(5);
        l2.add(6);
        l2.add(4);
        l3.head = addTwoNumbers(l1.head, l2.head);
        l3.print();
        l3.head = addTwoNumbersI(l1.head, l2.head);
        l3.print();
    }
}

class  ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        next = null;
    }

    public ListNode() {
        this(0);
    }
}
