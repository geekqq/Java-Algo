package Day43;

public class LinkedList {

    ListNode head;

    static class ListNode {
        int value;
        ListNode next;

        //constructor
        ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
    public static LinkedList insert(LinkedList list, int value) {
        //create a new node with given data
        ListNode newNode = new ListNode(value);

        if (list.head == null) {
            list.head = newNode;
        } else {
            ListNode last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void printList(LinkedList list) {
        ListNode cur = list.head;
        while(cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        printList(list);
        System.out.println(list.head.value);
    }
}
