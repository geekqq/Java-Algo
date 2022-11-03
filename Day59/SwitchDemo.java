package Day59;

public class SwitchDemo {
    public static void main(String[] args) {
        char c = 'A';
        int num = 10;
        switch (c) {
            case 'B':
                num++;
            case 'A':
                num++;
                //break;
            case 'Y':
                num++;
                //break;
            default:
                num++;
        }
        System.out.println(num);
        int i = 10;
        float f = 1.1f;
        byte  b  =25;
        byte a = 0, x = 3;
        short s = 23;
        s = (short)(s + 12);
        s+= 12;
        //float f = 23 + 23.23;
        System.out.println('a' + 122);
        System.out.println('a' + 122 + "");
        System.out.println('a' + "" +122);
        System.out.println("" + 'a' + 122);
        System.out.println("++++++++++++");
        i = 100;
        while (true) {
            if (i++ > 100) {
                break;
            }
            System.out.println(i);
        }
    }

}
