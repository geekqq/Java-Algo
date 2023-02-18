package Day169;

public class RemoveListElements {
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

    private static ListNode removeListElement(ListNode head, int val) {
        ListNode cur = head;
        while (cur != null && cur.val == val) {
            cur = cur.next;
        }

        head = cur;
        ListNode lastGoodElement = head;
        while (cur != null) {
            if (cur.val == val) {
                lastGoodElement.next = cur.next;
            } else {
                lastGoodElement =cur;
            }
            cur = cur.next;
        }
        return head;
    }

    private static ListNode removeListElementII(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeListElementII(head.next, val);
        return head.val == val ? head.next : head;
    }

    private static ListNode removeListElementIII(ListNode head, int val) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                cur = cur.next;
                continue;
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveListElements list = new RemoveListElements();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(5);
        list.add(6);
        list.print();
        list.head = removeListElementIII(list.head, 6);
        list.print();
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}
