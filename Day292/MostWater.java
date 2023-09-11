package Day292;

public class MostWater {
    public static int maxWater(int[] height) {
        if (height == null || height.length == 0) return 0;
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static int maxWaterI(int[] height) {
        if (height == null || height.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                res = Math.max(res, area);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};
        System.out.println(maxWater(height));
        System.out.println(maxWater(height2));
        System.out.println(maxWaterI(height));
        System.out.println(maxWaterI(height2));
    }
}
