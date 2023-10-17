package Day324;

import java.util.Arrays;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int hours = 0;
            for (int p : piles) {
                hours += Math.ceil((double) p / mid);
            }
            if (hours <= h) {
                res = Math.min(res, mid);
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));

        int[] piles1 = {30,11,23,4,20};
        int h1 = 5;
        int h2 = 6;
        System.out.println(minEatingSpeed(piles1, h1));
        System.out.println(minEatingSpeed(piles1, h2));
    }
}
