package Day223;

public class HammingWeight {

    public static int hammingWeight(int n) {
        if (n == 0) return 0;
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) count++;
            n >>>= 1;
        }
        return count;
    }

    public static int hammingWeightI(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(30));
        System.out.println(hammingWeightI(30));
    }
}
