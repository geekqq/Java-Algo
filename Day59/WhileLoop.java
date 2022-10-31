package Day59;

public class WhileLoop {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while(i <= 100) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
            i++;
        }
        System.out.println(sum);
        System.out.println("-----------");
        int sumj = 0;
        for (int j = 0; j <= 100 ; j += 2) {
            sumj += j;
        }
        System.out.println(sumj);

        System.out.println("------");
        char ch = 'c';
        switch(ch) {
            case 'a':
                System.out.print("a");
                break;
            case 'b':
                System.out.print("ab");
            case 'c':
                System.out.print("c");
            default:
                System.out.print('d');
        }
        System.out.println();
        float f = 10;
        f += 0.1;
        System.out.println(f);
        System.out.println("-----------");
        int a = 10;
        if (a++ > 10) {
            a = 20;
        }
        System.out.println(a);
        System.out.println("--------");
        byte e = 23;
        byte d = 12;
        int z = e + d;
        System.out.println(z);
    }

}
