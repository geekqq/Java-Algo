package Day264;

public class QueueDemo {

    private ListNode front;
    private ListNode rear;
    private int length;

    public QueueDemo() {
        front = null;
        rear = null;
        length = 0;
    }
    private class ListNode {
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

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void display() {
        if (isEmpty()) return;
        ListNode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }
    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public ListNode dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty!");
        }
        ListNode temp = front;
        front = front.next;
        if (front == null) rear = null;
        length--;
        return temp;
    }


    public static void main(String[] args) {
        QueueDemo queue = new QueueDemo();
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(10);
        System.out.println(queue);
        System.out.println(queue.length);
        queue.display();
        System.out.println("==========");
        queue.dequeue();
        System.out.println(queue.dequeue().data);
        queue.display();
        System.out.println(queue.length);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.length);
        queue.display();
        queue.dequeue();
    }
}
