package Day261;

public class ReverseLinkedList {

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

    public void display(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " --> ");
            cur = cur.next;
        }
        System.out.println("null\n");
    }

    public ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public int countNode(ListNode head) {
        if (head == null) return 0;
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public ListNode reverseII(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseII(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode getNthNodeFromEnd(int n) {
        if (head == null) return null;
        if (n <= 0) throw new IllegalArgumentException("n不能为负数或者0");
        ListNode mainPointer = head;
        ListNode refPointer = head;
        int count = 0;
        while (count < n) {
            if (refPointer == null) {
                throw new IllegalArgumentException(n + " is greater than the number of total list");
            }
            refPointer = refPointer.next;
            count++;
        }

        while (refPointer != null) {
            refPointer = refPointer.next;
            mainPointer = mainPointer.next;
        }
        return mainPointer;
    }

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void removeDuplicates() {
        if (head == null || head.next == null) return;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }

    // this method can not deal insert at the first pos
    public ListNode insertNodeInSortedList(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) return newNode;

        if (head.val >= val) {
            newNode.next = head;
            head = newNode;
        }

        ListNode temp = null;
        ListNode cur = head;

        while (cur != null && cur.val < val) {
            temp = cur;
            cur = cur.next;
        }
        newNode.next = cur;
        temp.next = newNode;
        return head;
    }

    public ListNode insertAtBeginning(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) return newNode;
        newNode.next = head;
        head = newNode;
        return head;
    }

    public void deleteNode(int val) {
        if (head == null) return;
        if (head.val == val) {
            head = head.next;
        } else {
            ListNode cur = head;
            ListNode temp = null;
            while (cur != null && cur.val != val) {
                temp = cur;
                cur = cur.next;
            }
            if (cur == null) {
                System.out.println("The node is not presented!");
            } else {
                temp.next = cur.next;
            }
        }
    }

    public boolean hasLoop(ListNode head) {
        if (head == null) return false;
        ListNode fast  = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public ListNode findStartingNodeInLoop(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) return null;
        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        list.display(list.head);
        ListNode reversedHead = list.reverseI(list.head);
        list.display(reversedHead);
        ListNode reversedAgainHead = list.reverseII(reversedHead);
        list.display(reversedAgainHead);
        System.out.println("-----find mid node-----");
        System.out.println(list.countNode(list.head));
        System.out.println(list.findMid(list.head).val);
        System.out.println("-----get Nth node from the end-----");
        System.out.println(list.getNthNodeFromEnd(2).val);
        System.out.println("-----remove duplicates-----");
        list.addFirst(0);
        list.addFirst(0);
        list.addFirst(0);
        list.display(list.head);
        list.removeDuplicates();
        list.display(list.head);
        System.out.println("----insert a node into the sorted linked list----");
        list.display(list.head);
        list.insertNodeInSortedList(1);
        list.display(list.head);
        System.out.println("----insert node at the beginning of the list----");
        list.insertAtBeginning(23);
        list.display(list.head);
        System.out.println("-----delete node------");
        list.deleteNode(10);
        list.display(list.head);
        System.out.println("------has loop-----");
        System.out.println(list.hasLoop(list.head));
        System.out.println("----find starting node in a loop----");
        //LinkedListDemo newList = new LinkedListDemo();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = fourth;
        //list.display(first);
        System.out.println(list.hasLoop(first));
        System.out.println(list.findStartingNodeInLoop(first).val);
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