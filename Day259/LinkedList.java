package Day259;

public class LinkedList {
    private ListNode head;

    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) head = newNode;
        else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        else {
            if (head.val == val) {
                head.val = head.next.val;
                head = head.next;
            } else {
                ListNode cur = head;
                while (cur.next != null && cur.next.val != val) {
                    cur = cur.next;
                }
                if (cur.next == null) {
                    System.out.println("the node is not presented");
                } else {
                    cur.next = cur.next.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        list.add(1);
        list.add(8);
        list.add(2);
        list.add(11);
        list.printList(list.head);
        list.head = list.deleteNode(list.head, 5);
        list.printList(list.head);
        list.head = list.deleteNode(list.head, 11);
        list.printList(list.head);
        list.head = list.deleteNode(list.head, 8);
        list.printList(list.head);
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}

