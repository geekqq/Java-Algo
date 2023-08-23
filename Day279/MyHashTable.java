package Day279;

public class MyHashTable {

    private HashNode[] buckets;
    private int numOfBuckets;
    private int size;

    public MyHashTable(int capacity) {
        buckets = new HashNode[capacity];
        numOfBuckets = capacity;
        size = 0;
    }

    public MyHashTable() {
        this(10);
    }

    class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getBucketIndex(int key) {
        return key % numOfBuckets; //buckets.length()
    }

    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        size++;
        buckets[bucketIndex] = node;
        node.next = head;
    }

    public String get(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return "The key is not present!";
    }

    public String remove(Integer key) {
        if (key == null) throw new IllegalArgumentException();
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
        if (head == null) return "The key is not present!";
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
        table.put(12, "stone");
        table.put(23, "jay");
        table.put(16, "gary");
        table.put(12, "tom");
        table.put(16, "jin");
        table.put(26, "hoo");
        table.put(46, "ruin");
        table.put(66, "tim");
        table.put(56, "min");
        System.out.println(table.size);
        System.out.println(table.isEmpty());
        System.out.println(table.get(18));
        System.out.println(table.remove(12));
        System.out.println(table.size);
        System.out.println(table.remove(46));
        System.out.println(table.remove(14));
    }
}
