package Day320;

import java.util.Arrays;

public class LC875KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for (int i : piles) {
            max = Math.max(max, i);
        }
        while (min < max) {
            int mid = (min + max) / 2;
            if (getHoursToEat(piles, mid) > h) {
                min = mid + 1;
            } else max = mid;
        }
        return min;
    }

    private static int getHoursToEat(int[] piles, int mid) {
        int hours = 0;
        for (int i : piles) {
            hours += Math.ceil((double) i / mid);
        }
        return hours;
    }


    public static int minEatingSpeedI(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r) {
            int k = l + (r - l) / 2;
            int hours = 0;
            for (int p : piles) {
                hours += Math.ceil((double) p / k);
            }
            if (hours <= h) {
                res = Math.min(res, k);
                r = k - 1;
            }  else l = k + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeedI(piles, h));
    }
}
