package Day270;

public class IntToBinary {

    public static String intToBinary(int n) {
        String res = "";
        while (n > 0) {
            int remainder = n % 2;
            res = remainder + res;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.print(intToBinary(i) + " ");
        }
        System.out.println();
    }
}
