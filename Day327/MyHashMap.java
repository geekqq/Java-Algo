package Day327;

public class MyHashMap {

    private HashNode[] bucket;
    private int numOfBucket;
    private int size;

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
        this.bucket = new HashNode[capacity];
        this.numOfBucket = capacity;
        this.size = 0;
    }

    public MyHashMap() {
        this(10);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getBucketIdx(int key) {
        return key % numOfBucket;
    }

    public void put(Integer key, String value) {
        if (key == null || value == null) throw new IllegalArgumentException("Invalid input!");
        int bucketIdx = getBucketIdx(key);
        HashNode head = bucket[bucketIdx];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = bucket[bucketIdx];
        HashNode node = new HashNode(key, value);
        node.next = head;
        bucket[bucketIdx] = node;
        size++;
    }

    public String get(Integer key) {
        if (key == null) throw new IllegalArgumentException("Invalid input");
        int bucketIdx = getBucketIdx(key);
        HashNode head = bucket[bucketIdx];
        while (head != null && !head.key.equals(key)) {
            head = head.next;
        }
        if (head == null) {
            return "The key is not present";
        } else {
            return head.value;
        }
    }

    public String remove(Integer key) {
        if (key == null) throw new IllegalArgumentException("Invalid input!");
        int bucketIdx = getBucketIdx(key);
        HashNode head = bucket[bucketIdx];
        HashNode prev = null;
        while (head != null && !head.key.equals(key)) {
            prev = head;
            head = head.next;
        }
        if (head == null) {
            System.out.println("The key is not present!");
        } else if (prev == null) {
            bucket[bucketIdx] = head.next;
        } else {
            prev.next = head.next;
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
        System.out.println(map.get(1));
        System.out.println(map.get(11));
        System.out.println(map.get(12));
        System.out.println(map.get(23));
        System.out.println(map.get(104));
        System.out.println(map.get(101));
        System.out.println(map.size);
        System.out.println(map.remove(101));
        System.out.println(map.get(101));
        System.out.println(map.size);
        System.out.println(map.remove(1));
        System.out.println(map.size);
        System.out.println(map.get(25));
    }
}
