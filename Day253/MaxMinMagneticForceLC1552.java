package Day253;

import java.util.Arrays;

//LC1552
public class MaxMinMagneticForceLC1552 {

    public static int findMaxDistance(int[] positions, int m) {
        Arrays.sort(positions);
        int l = 0;
        int r = (int)1e9;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(positions, m, mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    private static boolean check(int[] positions, int m, int mid) {
        int last = positions[0];
        int count = 1;
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - last >= mid) {
                count++;
                last = positions[i];
            }
        }
        return count >= m;
    }

}
