package Day37;

import java.util.ArrayList;

public class RetainAllDemo {
    public static void main(String[] args) {
        ArrayList objArray1 = new ArrayList();
        ArrayList objArray2 = new ArrayList();
        objArray1.add(0, "common1");
        objArray1.add(1, "common2");
        objArray1.add(2, "notcommon");
        objArray1.add(3, "notcommon1");
        objArray2.add(0, "common1");
        objArray2.add(1, "common2");
        objArray2.add(2, "notcommon2");
        System.out.println("array1的元素是：" + objArray1);
        System.out.println("array2的元素是：" + objArray2);
        objArray2.retainAll(objArray1); // objArray1.retainAll(objArray2)
        System.out.println("array1 和 array2的数组交集为：" + objArray2); // objArray1
    }
}
