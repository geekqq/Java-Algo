package Day278;

public class MyHashTable {

    private HashNode[] buckets;
    private int numOfBuckets;
    private int size;

    class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }
    public MyHashTable(int capacity) {
        this.buckets = new HashNode[capacity];
        this.numOfBuckets = capacity;
        this.size = 0;
    }

    public MyHashTable() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getBucketIndex(int key) {
        return key % numOfBuckets; // buckets.length;
    }

    public void put(Integer key, String value) {
        if (key == null || value == null) throw new IllegalArgumentException();
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        buckets[bucketIndex] = node;
        node.next = head;
    }

    public String get(Integer key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        if (head == null) {
            return "The key is not present!";
        }
        return null;
    }

    public String remove(Integer key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null) {
            return "the key is not present!";
        }
        if (prev != null) {
            prev.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }
        size--;
        return head.value;
    }

    public static void main(String[] args) {
        MyHashTable table = new MyHashTable();
        System.out.println(table.size);
        table.put(102, "taiwan");
        table.put(32, "hayward");
        table.put(15, "San Jose");
        System.out.println(table.size);
        System.out.println(table.get(16));
        System.out.println(table.remove(32));
        System.out.println(table.size);
        Integer a = 1200;
        Integer b = 1200;
        System.out.println(a.equals(b));
    }
}


