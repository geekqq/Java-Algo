package Day04;

public class DemoString {
    public static void main(String[] args) {
        int x = 4;
        System.out.println(x++);
        System.out.println(x);
        System.out.println("-----------------");


        int a = 10;
        int b = 30;

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("+++++++++++++++++");
        char array[] = {'a', 'b', ' ', 'c', 'd', ';', 'e', 'f', ' ',
                'g', 'h', ';', 'i', 'j', ' ', 'k', 'l'};
        String str = new String(array);
        System.out.println(str);
        System.out.println("+++++++++++++++++");
        String str1 = "helloooo";
        str1 = str1.toUpperCase();
        System.out.println(str1);
        System.out.println("+++++++++++++++++");
        String obj1 = new String("run");
        String obj2 = new String("run");
        //String obj1 = "Raun", obj2 = "Raun";
        if (obj1.hashCode() == obj2.hashCode()) System.out.println("obj1和obj2的哈希码相等");
        if (obj1 == obj2) System.out.println("obj1和obj2内存地址一样");
        if (obj1.equals(obj2)) System.out.println("obj1和obj2的值相等");

    }


    public void demo (String str) {
        String[] arr = str.split(";");
        for (String s : arr) {
            System.out.println(s);
        }
    }

}
