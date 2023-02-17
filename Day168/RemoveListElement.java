package Day168;

public class RemoveListElement {
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
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

//    private static ListNode removeListNode(ListNode head, int val) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        ListNode cur = head;
//        ListNode prev = dummy;
//        while (cur != null) {
//            if (cur.val == val) {
//                prev.next = cur.next;
//            } else {
//                prev = cur;
//                cur = cur.next;
//            }
//        }
//        return dummy.next;
//    }

    public static ListNode removeElementsII(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsII(head.next, val);
        return (head.val == val) ? head.next : head;
    }

    public static void main(String[] args) {
        RemoveListElement list = new RemoveListElement();
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.head = removeElementsII(list.head, 6);
        list.print();
    }
}
