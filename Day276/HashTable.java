package Day276;

public class HashTable {

    private HashNode[] buckets;
    private int numOfBuckets;
    private int size; //number of key-value pair

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[numOfBuckets];
        this.size = 0;
    }
    private class HashNode {
        private Integer key;  //TODO generic type
        private String value;  //TODO generic type
        private HashNode next;  //reference to the next HashNode

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

    public void put(Integer key, String value) {
        if (key == null || value == null) throw new IllegalArgumentException("Key or Value is null!");
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
        node.next = head;
        buckets[bucketIndex] = node;
    }

    public int getBucketIndex(int key) {
        return key % numOfBuckets;
    }

    public String getKey(Integer key) {
        int bucketIndex = getBucketIndex(key);
        HashNode cur = buckets[bucketIndex];
        while (cur != null && cur.key != key) {
            cur = cur.next;
        }
        if (cur == null) {
            return "the value to the key is not present!";
        }
        return cur.value;
    }

    public String remove(Integer key) {

        int bucketIndex = getBucketIndex(key);
        HashNode cur = buckets[bucketIndex];
        HashNode prev = null;
        while (cur != null) {
            if (cur.key.equals(key)) {
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) return null;
        size--;
        if (prev != null) {
            prev.next = cur.next;
        } else {
            buckets[bucketIndex] = cur.next;
        }
        return cur.value;
    }


    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(105, "stone");
        table.put(31, "hao");
        table.put(21, "joy");
        table.put(21, "ruien");
        System.out.println(table.size);
        System.out.println(table.getKey(21));
        System.out.println(table.remove(31));
        System.out.println(table.size);
    }
}
