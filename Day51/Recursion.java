package Day51;

public class Recursion {
    static ListNode head;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rest = reverse(head.next);
        head.next.next = head;

        head.next = null; //结尾挂null
        return rest;
    }

    public static void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void push(int val) {
        ListNode temp = new ListNode(val);
        temp.next = head;
        head = temp;
    }

    public static void main(String[] args) {
        push(20);
        push(4);
        push(15);
        push(85);
        push(43);

        System.out.println("Give linked list: ");
        printList();
        head = reverse(head);
        System.out.println("Reversed linked list:");
        printList();
    }
}
