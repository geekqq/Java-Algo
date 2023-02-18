package Day170;

public class AddTwoNumbers {
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

    private static ListNode addTwoNums(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            int x = head1 != null ? head1.val : 0;
            int y = head2 != null ? head2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers num1 = new AddTwoNumbers();
        AddTwoNumbers num2 = new AddTwoNumbers();
        AddTwoNumbers sum = new AddTwoNumbers();

        num1.add(2);
        num1.add(4);
        num1.add(3);
        num1.add(3);
        num2.add(5);
        num2.add(6);
        num2.add(4);
        sum.head = addTwoNums(num1.head, num2.head);
        sum.print();
    }
}
