package Day70;

public class numOfBits {
    public static void main(String[] args) {
        System.out.println(numOfBits(3));
    }

    public static int numOfBits(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask << i) != 0) {
                count++;
            }
        }
        return count;
    }
}
