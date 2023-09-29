package Day310;

public class MyHashMap {

    private HashNode[] buckets;
    private int numOfBuckets;
    private int size;

    class HashNode{
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
    public MyHashMap() {this(10);}
    public boolean isEmpty() {return size == 0;}
    public int getBucketIdx(Integer key) {return key % numOfBuckets;}
    public void put(Integer key, String value) {
        if (key == null || value == null) return;
        int bucketIdx = getBucketIdx(key);
        HashNode head = buckets[bucketIdx];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIdx];
        HashNode node = new HashNode(key, value);
        buckets[bucketIdx] = node;
        node.next = head;
    }

    public String get(Integer key) {
        if (key == null) return null;
        int bucketIdx = getBucketIdx(key);
        HashNode head = buckets[bucketIdx];
        while (head != null && !head.key.equals(key)) {
            head = head.next;
        }
        if (head == null) return "The key is not present!";
        else return head.value;
    }

    public String remove(Integer key) {
        if (key == null) return null;
        int bucketIdx = getBucketIdx(key);
        HashNode head = buckets[bucketIdx];
        HashNode prev = null;
        while (head != null && !head.key.equals(key)) {
            prev = head;
            head = head.next;
        }
        if (head == null) return "The key is not present!";
        if (prev == null) {
            buckets[bucketIdx] = head.next;
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
