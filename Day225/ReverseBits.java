package Day225;

public class ReverseBits {

    public static int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        int mask = 0;
        for (int i = 0; i < 32; i++) {
            mask = (n >> 1) & 1;
            res |= (mask << 31 - i);
        }
        return res;
    }
}
