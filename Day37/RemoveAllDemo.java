package Day37;

import java.util.ArrayList;

public class RemoveAllDemo {
    public static void main(String[] args) {
        ArrayList objArray1 = new ArrayList();
        ArrayList objArray2 = new ArrayList();

        objArray2.add(0, "common1");
        objArray2.add(1, "common2");
        objArray2.add(2, "notcommon");
        objArray2.add(3, "notcommon1");
        objArray1.add(0, "common1");
        objArray1.add(1, "common2");
        objArray1.add(2, "notcommon2");
        System.out.println("array1的元素为：" + objArray1);
        System.out.println("array2的元素为：" + objArray2);
        objArray1.removeAll(objArray2);
        System.out.println("array1 与 array2的数组差集为：" + objArray1);
    }
}
