package OODAdv;

public class MyHashMap {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75d;
    private int threshold;
    private int size;
    private int resize;
    private MyEntry[] table;

    public MyHashMap() {
        table = new MyEntry[DEFAULT_INITIAL_CAPACITY];
        threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        size = 0;
    }

    private int index(Object key) {
        return Math.abs(key.hashCode() % table.length);
    }

    public void put(Object key, Object value) {
        if (key == null) return;
        int index = index(key);
        //遍历index位置的entry，若找到重复key则需要更新对应entry的值然后返回
        MyEntry entry = table[index];
        while (entry != null) {
            if (entry.getKey().hashCode() == key.hashCode() && (entry.getKey() == key || entry.getKey().equals(key))) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }
        add(index, key, value); //如index位置没有entry或者未找到重复的key则添加到table的index位置
    }

    private void add(int index, Object key, Object value) {
        //将新的entry添加到table的index位置的第一个，如果原来位置有值则以链表形式存放
        MyEntry entry = new MyEntry(key, value, table[index]);
        table[index] = entry;
        //判断size是否已经达到临界值，达到则进行扩容，将table的capacity翻番
        if (size++ >= threshold) {
            resize(table.length * 2);
        }
    }

    private void resize(int capacity) {
        if (capacity <= table.length) return;

        MyEntry[] newTable = new MyEntry[capacity];
        //遍历原table，将每一个entry都重新计算hash放入newTable中
        for (int i = 0; i < table.length; i++) {
            MyEntry old = table[i];
            while (old != null) {
                MyEntry next = old.getNext();
                int index = index(old.getKey());
                old.setNext(newTable[index]);
                newTable[index] = old;
                old = next;
            }
        }
        //用newTable来代替table
        table = newTable;
        threshold = (int) (table.length * DEFAULT_LOAD_FACTOR);
        resize++;
    }

    public Object get(Object key) {
        if (key == null) return null;
        MyEntry entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }

    public MyEntry getEntry(Object key) {
        MyEntry entry = table[index(key)];
        while (entry != null) {
            if (entry.getKey().hashCode() == key.hashCode() && (entry.getKey() == key || entry.getKey().equals(key))) {
                return entry;
            }
            entry = entry.getNext();
        }
        return entry;
    }

    public void remove(Object key) {
        if (key == null) return;
        int index = index(key);
        MyEntry pre = null;
        MyEntry entry = table[index];
        while (entry != null) {
            if (entry.getKey().hashCode() == key.hashCode() && (entry.getKey() == key || entry.getKey().equals(key))) {
                if (pre == null) {
                    table[index] = entry.getNext();
                } else {
                    pre.setNext(entry.getNext());
                }
                size--;
                return;
            }
            pre = entry;
            entry = entry.getNext();
        }
    }

    public boolean containsKey(Object key) {
        if (key == null) return false;
        return getEntry(key) != null;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("size: %s capacity: %s resize: %s\n\n", size, table.length, resize));
        for (MyEntry entry : table) {
            while (entry != null) {
                sb.append(entry.getKey() + ":" + entry.getValue() + "\n");
                entry = entry.getNext();
            }
        }
        return sb.toString();
    }

    final class MyEntry {
        private Object key;
        private Object value;
        private MyEntry next;

        public MyEntry(Object key, Object value, MyEntry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public MyEntry getNext() {
            return next;
        }

        public void setNext(MyEntry next) {
            this.next = next;
        }
    }
}