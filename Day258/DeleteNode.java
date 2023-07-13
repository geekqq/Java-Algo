package Day258;

public class DeleteNode {
    private static ListNode head;

    public static void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null; // or throw exceptions since input invalid
        }
        if (head.data == val) {
            if (head.next == null) {
                return null; // only one node in the list
            } else {
                head = head.next;
            }
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data != val) {
                cur = cur.next;
            }
            if (cur.next == null) {
                System.out.println("The node to be deleted is not presented!");
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}

class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
