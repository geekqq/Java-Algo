package OODAdv;

public class BitDemo {
    public static void main(String[] args) {
        //&与运算 两位同时为1结果为1，其它情况结果为0
        System.out.println(0 & 0);
        System.out.println(0 & 1);
        System.out.println(1 & 1);
        System.out.println(1 & 0);
        System.out.println("=======");

        //｜或运算 两位均为0时，结果才为0，其它情况结果为1
        System.out.println(0 | 0);
        System.out.println(0 | 1);
        System.out.println(1 | 1);
        System.out.println(1 | 0);
        System.out.println("=======");

        //^异或运算 相同为0，不同为1
        System.out.println(0 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
        //~取反运算 0变1，1变0
        System.out.println("=======");
        System.out.println(~0);
        System.out.println(~2);
        System.out.println(9 & 1);
        System.out.println("=======");
        System.out.println(-5 % 3);

    }
}
