package Day30;

import javax.swing.tree.TreeNode;
import java.security.Key;

//public class DemoHashMap {


    //HashMap的put操作
//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }
//
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); //进行 与 操作
//    }
//
//    //具体添加细节
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
//        Node<K, V>[] tab; //创建数组
//        Node<K, V> p; //新节点
//        int n, i;
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length; //对数组进行初始化
//        if ((p = tab[i = (n - 1) & hash]) == null) // (n - 1) & hash 求数组的下标，判断是否有元素，没有
//            tab[i] = newNode(hash, key,value, null); //直接放入
//        else {
//            Node<K, V> e;
//            K k;
//            //判断两个节点是否存在。
//            //1。 两个对象的hash值不同，一定不是同一个对象
//            //2。 hash值相同，两个对象不一定相等
//            if (p.hash == hash && (k = p.key) == key || (key != null & key.equals(k)))) e = p;
//            else if (p instanceof TreeNode)//存储的节点的key不存在，判断是否为树节点（是不是已经转化为红黑树）
//                e = ((TreeNode<K, V>)p).putTreeVal(this, tab, hash, key, value);
//            else {
//                for (int binCount = 0; ; ++binCount) {
//                    if ((e = p.next) == null) { //直接找到链表的尾部，直接插入
//                        p.next = newNode(hash, key, value, null);
//                        if (binCount >= TREEIFY_THREASHOLD - 1)  // -1 for 1st 判断链表的长度是否大于可以转化为树结构的阀值
//                            treeifyBin(tab, hash); //树化
//                        break;
//                    }
//
//                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) //判断是否和插入对象相同
//                        break;
//                    p = e;
//                }
//                if (e != null) { // existing mapping for key 存在映射的key，覆盖原职，将原值返回
//                    V oldValue = e.value;
//                    if (!onlyIfAbsent || oldValue == null)
//                        e.value = value;
//                    afterNodeAccess(e);return oldValue;
//                }
//            }
//            ++modCount;
//            if (++size > threshold) //hashmap 的容量大于阀值
//                resize();
//            afterNodeInsertion(evict);
//            return null;
//        }
//    }
//}
