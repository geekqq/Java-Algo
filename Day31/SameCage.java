package Day31;

public class SameCage {
    public static void main(String[] args) {
        for (int j = 0, t = 35; j <= 35 ; j++, t--) {
            if (j * 2 + t * 4 == 94) {
                System.out.printf("鸡有%d只，兔有%d只。", j, t);
            }
        }

    }
}
