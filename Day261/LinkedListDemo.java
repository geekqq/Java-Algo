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

    public static void main(String[] args) {
        LinkedListDemo list  =new LinkedListDemo();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(3);
        list.printList();
        list.deleteLast();
        list.printList();
    }
}
