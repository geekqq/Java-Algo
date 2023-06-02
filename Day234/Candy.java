package Day234;

public class Candy {

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        final int len = ratings.length;
        final int[] temp = new int[len];

        for (int i = 0; i < len; i++) {
            temp[i] = 1;
        }
        for (int i = 0; i < len - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                temp[i + 1] = temp[i] + 1;
            }
        }
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                if (temp[i - 1] < temp[i] + 1) {
                    temp[i - 1] = temp[i] + 1;
                }
            }
        }
        int res = 0;
        for (int i : temp) {
            res += i;
        }

        return res;
    }
}
