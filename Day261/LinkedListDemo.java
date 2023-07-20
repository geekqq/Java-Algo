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

    public void printList() {
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
        list.printList();
        System.out.println(list.countNodes());
        list.deleteLast();
        list.deleteLast();
        list.printList();
        System.out.println(list.countNodes());
        list.deleteNode(2);
        list.printList();
    }
}
