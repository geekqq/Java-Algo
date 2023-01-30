package Day150;

public class LinkedListDemo {
    static ListNode head;
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

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printRecursively(ListNode head) {
        if (head == null) return;
        System.out.println(head.val);
        printRecursively(head.next);
    }

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.printRecursively(list.head);
    }
}
