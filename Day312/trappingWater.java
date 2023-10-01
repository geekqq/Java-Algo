package Day312;

public class trappingWater {

    public static int trappingWater(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height1 = {4,2,0,3,2,5};
        System.out.println(trappingWater(height));
        System.out.println(trappingWater(height1));
    }
}
