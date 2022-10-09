package Day37;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class CompareCollections {
    public static void main(String[] args) {
        String[] coins = {"Penny","nickel","dime","Quarter","dollar","Pen"};
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }

        //字符串比较大小，看首字母的asc码，大写字母小于小写字母，首字母相同往后找直到找到不同字符在比较，如果没有不同就比较字符串长度
        System.out.println(Collections.min(set));
        System.out.println(Collections.max(set));
        System.out.println("---------");
        System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER));
        System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));
    }
}
