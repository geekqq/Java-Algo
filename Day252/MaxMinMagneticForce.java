package Day252;

import java.util.Arrays;

//LC1552
public class MaxMinMagneticForce {

    public static int maxMinMagneticForceBtwTwoBalls(int[] positions, int m) {
        Arrays.sort(positions);
        int start = 1;
        int n = positions.length;
        int end = positions[n - 1] - positions[0];
        int ans = 1;

        while (start <= end) {
            int mid = start + end >> 1;
            if (isDistancePossible(positions, m, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isDistancePossible(int[] positions, int m, int dist) {
        int noOfBallsPlaced = 1;
        int lastPosition = positions[0];
        for (int i = 1; i < positions.length && noOfBallsPlaced < m; i++) {
            if (positions[i] >= lastPosition + dist) {
                noOfBallsPlaced++;
                lastPosition = positions[i];
            }
        }
        if (noOfBallsPlaced < m) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] positions = {1,2,3,4,7};
        int[] positions1 = {5,4,3,2,1,1000000000};
        int n = 2;
        int m = 3;
        System.out.println(maxMinMagneticForceBtwTwoBalls(positions, m));
        System.out.println(maxMinMagneticForceBtwTwoBalls(positions1, n));
    }
}
