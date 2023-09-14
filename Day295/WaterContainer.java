package Day295;

public class WaterContainer {

    public static int waterMax(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = height[l] > height[r] ? Math.max(res, (r - l) * height[r--]) : Math.max(res, (r - l) * height[l++]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};
        System.out.println(waterMax(height2));
        System.out.println(waterMax(height));
    }
}
