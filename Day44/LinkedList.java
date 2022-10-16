package Day44;

public class LinkedList {
    ListNode head;

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        LinkedList ob = new LinkedList();
        ob.addNode(4);
        ob.printList(head);
    }

    public void printList(ListNode head) {
        if (head == null) {
            System.out.println("the list is empty");
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(head.value + " ");
            cur = cur.next;
        }
    }

    public void addNode(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            newNode.next = null;
        } else {
            ListNode cur = head;
            while (cur != null) {
                cur = cur.next;
            }
            cur = newNode;
            cur.next = null;
        }
    }
}
