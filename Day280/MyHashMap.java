package Day280;

public class MyHashMap {

    private HashNode[] buckets;
    private int numOfBuckets;
    private int size; //num of key-value pairs

    class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    public MyHashMap(int capacity) {
        this.buckets = new HashNode[capacity];
        this.numOfBuckets = capacity;
        this.size = 0;
    }

    public MyHashMap() {
        this(10);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int getBucketIndex(Integer key) {
        return key % numOfBuckets;
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
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        buckets[bucketIndex] = node;
        node.next = head;
    }


    public String get(Integer key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null && !head.key.equals(key)) {
            head = head.next;
        }
        if (head == null) return "The key is not present!";
        else return head.value;
    }

    public String remove(Integer key) {
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode prev = null;
        while (head != null && !head.key.equals(key)) {
            prev = head;
            head = head.next;
        }
        if (head == null) return "The key is not present!";
        else {
            if (prev != null) {
                prev.next = head.next;
            } else {
                buckets[bucketIndex] = head.next;
            }
        }
        size--;
        return head.value;
    }
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, "stone");
        map.put(11, "cae");
        map.put(12, "joe");
        map.put(23, "home");
        map.put(104, "kate");
        map.put(104, "jay");
        map.put(101, "jack");

        System.out.println(map.size);
        System.out.println(map.get(11));
        System.out.println(map.remove(15));
        System.out.println(map.size);
    }
}
