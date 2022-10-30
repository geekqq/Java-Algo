package Day52;

public class AddTwoNumbers {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }
        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        //this add method is not working. see Day58 AddTwoNumbers
        public void add(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                head.next = newNode;
                //newNode.next = null;
            }
        }

        public static void printList(ListNode head) {
            ListNode cur = head;
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        if (l1 != null) {
            l1 = l1.next;
        }
        if (l2 != null) {
            l2 = l2.next;
        }
        return dummyHead.next;
    }

//    public static void main(String[] args) {
//        AddTwoNumbers list1 = new AddTwoNumbers();
//        AddTwoNumbers list2 = new AddTwoNumbers();
//        list1.head = new ListNode(7);
//        list1.head.next = new ListNode(4);
//        list1.head.next.next = new ListNode(6);
//        ListNode.printList(list1.head);
//        list2.head = new ListNode(3);
//        list2.head.next = new ListNode(5);
//        list2.head.next.next = new ListNode(8);
//        ListNode.printList(list2.head);
//        AddTwoNumbers ob = new AddTwoNumbers();
//        ListNode newNode = ob.addTwoNumbers(list1.head, list2.head);
//        ListNode.printList(newNode);
//    }
}
