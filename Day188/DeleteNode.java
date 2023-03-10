package Day188;

import Day174.ListNode;

public class DeleteNode {
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

    public void deleteNode(int val) {
        ListNode cur = head;
        ListNode prev = null;
        if (cur != null && cur.val == val) {
            head = head.next;
            return;
        }
        while (cur != null && cur.val != val) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) {
            System.out.println("the node is not present!");
            return;
        }
        prev.next = cur.next;
    }

    public static void main(String[] args) {
        DeleteNode list = new DeleteNode();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.print();
        System.out.println("----delete head----");
        list.deleteNode(0);
        list.print();
        System.out.println("---delete tail----");
        list.deleteNode(9);
        list.print();
        System.out.println("----delete value not in the list----");
        list.deleteNode(10);
        list.print();
        System.out.println("----delete mid node----");
        list.deleteNode(5);
        list.print();


    }
}
