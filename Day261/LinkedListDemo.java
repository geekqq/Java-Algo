package Day261;

public class LinkedListDemo {

    private ListNode head;

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode add(int val) {
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
        return head;
    }

    public void printList(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.print("null\n");
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        while (cur.next != null) {
            pre= cur;
            cur = cur.next;
        }
        pre.next = null;
        return cur;
    }

    public int countNodes() {
        ListNode cur = head;
        int count = 1;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void deleteNode(int pos) {
        if (pos > countNodes()) {
            throw new IllegalArgumentException("position out of bounds");
        }
        if (pos == 1) head = head.next;
        else {
            ListNode prev = head;
            int count = 1;
            while (count < pos - 1) {
                prev = prev.next;
                count++;
            }
            ListNode cur = prev.next;
            prev.next = cur.next;
        }
    }

    public boolean find(int val) {
        if (head == null) return false;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseI(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        LinkedListDemo list  =new LinkedListDemo();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(10);
        list.add(4);
        list.add(7);
        list.add(9);
        list.printList(list.head);
        System.out.println(list.countNodes());
        list.deleteLast();
        list.deleteLast();
        list.printList(list.head);
        System.out.println(list.countNodes());
        //list.deleteNode(9);
        list.printList(list.head);
        System.out.println(list.find(5));
        System.out.println(list.find(9));
        System.out.println(list.find(4));
        ListNode reverseListHead = list.reverseI(list.head);
        list.printList(reverseListHead);
    }
}
