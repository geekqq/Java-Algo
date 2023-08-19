package Day275;

import java.util.Stack;

public class LinkedList {

    private ListNode head;

    public void addLast(int val) {
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

    public void print(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static ListNode reverseRe(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverseRe(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static ListNode reverseIt(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode swapInPair(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode postHead = swapInPair(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = postHead;
        return newHead;
    }

    public static int countNode(ListNode head) {
        ListNode cur = head;
        if (head == null) return 0;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public static int countNodeRe(ListNode head) {
        if (head == null) return 0;
        return 1 + countNodeRe(head.next);
    }

    public static ListNode reverseByK(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        int count = countNode(head);
        if (count < k) return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = reverseByK(cur, k);
        return prev;
    }

    public static ListNode reverseByRange(ListNode head, int left, int right) {
        if (head == null || head.next == null) return  head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode subStart = prev.next;
        prev.next = null;
        ListNode subEnd = subStart;
        for (int i = left; i < right; i++) {
            subEnd = subEnd.next;
        }
        ListNode next = subEnd.next;
        subEnd.next = null;
        prev.next = reverseRe(subStart);
        subStart.next = next;
        return dummy.next;
    }

    public static ListNode mergeList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode leftHead = mergeList(head);
        ListNode rightHead = mergeList(slow);
        return mergeTwoSortedArray(leftHead, rightHead);
    }

    public static ListNode mergeTwoSortedArray(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (leftHead != null && rightHead != null) {
            if (leftHead.data < rightHead.data) {
                cur.next = leftHead;
                leftHead = leftHead.next;
            } else {
                cur.next = rightHead;
                rightHead = rightHead.next;
            }
            cur = cur.next;
        }
        cur.next = (leftHead != null ? leftHead : rightHead);
        return dummy.next;
    }

    public static ListNode insertNode(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.data < val) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
        return head;
    }

    public static void removeDuplicates(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast !=null && slow.data == fast.data) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
    }
    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode firstHead = head;
        ListNode secondHead = reverseIt(temp);

        ListNode dummy = new ListNode();
        temp = dummy;
        while (firstHead != null && secondHead != null) {
            temp.next = firstHead;
            firstHead = firstHead.next;
            temp = temp.next;

            temp.next = secondHead;
            secondHead = secondHead.next;
            temp = temp.next;
        }
        temp.next = (firstHead != null ? firstHead : secondHead);
        return dummy.next;
    }

    public static void oddEvenList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }

    public static ListNode removeNode(ListNode head, int val) {
        if (head == null) throw new IllegalArgumentException("The list doesn't exist!");
        if (head.data == val && head.next == null) {
            System.out.println("head is the only node, can not be deleted!");
        } else {
            if (head.data == val) {
                head = head.next;
            } else {
                ListNode cur = head;
                while (cur.next != null && cur.next.data != val) {
                    cur = cur.next;
                }
                if (cur.next == null) {
                    System.out.println("the node is not present!");
                }
                cur.next = cur.next.next;
            }
        }
        return head;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static ListNode getStartingNodeForCircularList(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast =fast.next;
            if (slow == fast) break;
        }
        if (slow != fast) return null;
        ListNode temp = head;
        while (temp != slow) {
            slow = slow.next;
            temp = temp.next;
        }
        return temp;
    }

    public static void plusOne(ListNode head) {
        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.data < 9) {
                node.data++;
                return;
            } else {
                node.data = 0;
            }
        }
        ListNode newNode = new ListNode(1);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 11; i++) {
            list.addLast(i);
        }
        System.out.println("====original list====");
        list.print(list.head);
        System.out.println("===reverse====");
        list.print(list.head = reverseIt(list.head));
        System.out.println();
        list.print(list.head = reverseRe(list.head));
        System.out.println("====swap in pairs");
        list.print(list.head = swapInPair(list.head));
        System.out.println("====count node====");
        System.out.println(countNode(list.head));
        System.out.println(countNodeRe(list.head));
        System.out.println("====reverse by ke====");
        list.head = reverseByK(list.head, 4);
        list.print(list.head);
        System.out.println("====reverse by range====");
        list.print(list.head = reverseByRange(list.head, 5, 9));
        System.out.println("====merge sort list====");
        list.head = mergeList(list.head);
        list.print(list.head);
        System.out.println("====insert new node====");
        list.head = insertNode(list.head,0);
        list.head = insertNode(list.head,5);
        list.head = insertNode(list.head,11);
        list.print(list.head);
        System.out.println("====remove duplicates node====");
        removeDuplicates(list.head);
        list.print(list.head);
        System.out.println("====reorder list====");
        list.print(list.head = reorderList(list.head));
        System.out.println("====odd even list====");
        oddEvenList(list.head);
        list.print(list.head);
        System.out.println("====delete nodes====");
        list.head = removeNode(list.head, 0);
        list.head = removeNode(list.head, 6);
        list.head = removeNode(list.head, 11);
        list.print(list.head);
        System.out.println("====plus one===");
        plusOne(list.head);
        list.print(list.head);
        removeDuplicates(list.head);
        list.print(list.head);
        list.head = removeNode(list.head, 8);
        list.head = removeNode(list.head, 10);
        list.print(list.head);
        plusOne(list.head);
        list.print(list.head);
    }
}
class ListNode {
    int data;
    ListNode next;
    public ListNode(int data) {
        this.data = data;
        next = null;
    }

    public ListNode() {
        this(0);
    }
}
