package Day263;

public class ListNodeDemo {

    private ListNode head;

    public void addFirst(int val) {
        ListNode temp = new ListNode(val);

        temp.next = head;
        head = temp;
    }

    public void addLast(int val) {
        ListNode temp = new ListNode(val);
        if (head == null) {
            head = temp;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = temp;
        }
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public void insertToSort(int val) {
        ListNode temp = new ListNode(val);
        if (head.val >= val) {
            temp.next = head;
            head = temp;
        } else {
            ListNode cur = head;
            ListNode pre = null;
            while (cur.val < val) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = temp;
            temp.next = cur;
        }
    }

    public ListNode insertNode(ListNode head, int val) {
        ListNode temp = new ListNode(val);
        if (head == null || head.val >= val) {
            temp.next = head;
            head = temp;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.val < val) {
                cur = cur.next;
            }
            temp.next = cur.next;
            cur.next = temp;
        }
        return head;
    }

    public ListNode reverse() {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseI(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public void removeDuplicate() {
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && fast.val == slow.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
    }

    public static void main(String[] args) {
        ListNodeDemo list = new ListNodeDemo();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.print();
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.print();
        System.out.println("----insert to sort----");
        ListNodeDemo list2 = new ListNodeDemo();
        for (int i = 0; i < 6; i++) {
            list2.addLast(i);
        }
        list2.print();
        list2.insertToSort(0);
        list2.print();
        System.out.println("----remove duplicates----");
        list2.removeDuplicate();
        list2.print();
        System.out.println("----reverse list----");
        list2.head = list2.reverse();
        list2.print();
        list2.head = list2.reverseI(list2.head);
        list2.print();
        System.out.println("----insert node----");
        list2.head = list2.insertNode(list2.head, 0);
        list2.insertNode(list2.head, 3);
        list2.insertNode(list2.head, 6);
        list2.print();
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode() {
        this(0);
    }
}
