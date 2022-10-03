package Day31;

import java.util.Scanner;

public class Product {
        //成员变量
        static String[] names = {"iPhoneXS", "华为 Mate 20 Pro", "小米X", "Vivo NEX",  "Oppo Find"};
        static double[] price = {8999, 5399, 2399, 4399, 3999};
        static int[] numbers = {50, 20, 80, 120, 90};

    public static void main(String[] args) {
        /*
         *-------------------
         * 1. 商品列表
         * 2. 商品录入
         * 3. 商品查询
         * 4. 统计信息
         * 5. 退出
         *-------------------
         * 选择: > 1
         * ....
         */
        //死循环显示菜单
        outer:
        while (true) {
            //显示菜单，并获得选择的值
            int c = menu();
            //判断c的值
            switch (c) {
                case 1: f1(); break;
                case 2: f2(); break;
                case 3: f3(); break;
                case 4: f4(); break;
                case 5: break outer;
            }
        }
    }

    private static int menu() {
        System.out.println("-------------------");
        System.out.println("1. 商品列表");
        System.out.println("2. 商品录入");
        System.out.println("3. 商品查询");
        System.out.println("4. 统计信息");
        System.out.println("5. 退出");
        System.out.println("-------------------");
        System.out.println("选择: > ");
        return new Scanner(System.in).nextInt();
    }

    private static void f1() {
        //逐行打印出商品名称，价格和数量
        for (int i = 0; i < names.length; i++) {
            String n = names[i];
            double p = price[i];
            int b = numbers[i];
            System.out.println((i+ 1) + " " + n + ", 价格 " + p + ", 数量 " + b);
        }
    }

    private static void f2() {
        for (int i = 0; i <= names.length; i++) {
            System.out.println("录入第" + (i+1) + "件商品：");
            System.out.println("名称：");
            String n = new Scanner(System.in).nextLine();
            System.out.println("价格：");
            double p = new Scanner(System.in).nextDouble();
            System.out.println("数量：");
            int b = new Scanner(System.in).nextInt();
            names[i] = n;
            price[i] = p;
            numbers[i] = b;
        }
        //重新显示商品列表
        f1();
    }

    private static void f3() {
        System.out.println("请输入要查询的商品名称：");
        String n = new Scanner(System.in).nextLine();
        for (int i = 0; i < names.length; i++) {
            if (n.equals(names[i])) {
                String name = names[i];
                double p = price[i];
                int b = numbers[i];

                System.out.println((i + 1) + "名称：" + name + ", 价格：" + p + ", 数量：" + b);
                return;
            }
        }
        //循环结束，所有商品都比较完，没有找到该商品。
        System.out.println("没有找到该商品。");
    }

    private static void f4() {
        //商品总价，单价总价，最高单价，最高总价
        double spzj = 0;
        double djzj = 0;
        double zgdj = 0;
        double zgzj = 0;

        for (int i = 0; i < names.length; i++) {
            spzj += price[i] * numbers[i];
            djzj += price[i];
            if (price[i] > zgdj) {
                zgdj = price[i];
            }
            if (price[i] * numbers[i] > zgzj) {
                zgzj = price[i] * numbers[i];
            }
        }
        System.out.println("商品总价：" + spzj);
        System.out.println("单价总价：" + djzj);
        System.out.println("最高单价：" + zgdj);
        System.out.println("最高总价：" + zgzj);
    }
}
