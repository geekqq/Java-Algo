package Day313;

import java.util.Arrays;

public class CarFleet {

    public static int carFleet(int[] position, int[] speed, int target) {
        int n = speed.length;
        int res = 0;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars [i] = new double[] {position[i], (double) (target - position[i]) / speed[i]};
        }
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        double cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (cars[i][1] > cur) {
                cur = cars[i][1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 12;
        System.out.println(carFleet(position, speed, target));

        int[] position1 = {3};
        int[] speed1 = {3};
        int target1 = 10;
        System.out.println(carFleet(position1, speed1, target1));

        int[] position2 = {0, 2, 4};
        int[] speed2 = {4, 2, 1};
        int target2 = 100;
        System.out.println(carFleet(position2, speed2, target2));
    }
}
