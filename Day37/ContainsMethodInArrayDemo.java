package Day37;

import java.util.ArrayList;

public class ContainsMethodInArrayDemo {
    public static void main(String[] args) {
        ArrayList<String> objArray = new ArrayList<>();
        ArrayList<String> objArray2 = new ArrayList<>();
        objArray2.add(0, "common1");
        objArray2.add(1, "common2");
        objArray2.add(2, "notcommon");
        objArray2.add(3, "notcommon1");
        objArray.add(0, "common1");
        objArray.add(1, "common2");
        System.out.println("objArray的元素是：" + objArray);
        System.out.println("objArray2的元素是：" + objArray2);
        System.out.println("objArray是否包含字符串common2? : " + objArray.contains("common2"));
        System.out.println("objArray2是否包含数组objArray? : " + objArray2.contains(objArray));
    }
}
