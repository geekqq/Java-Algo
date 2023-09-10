package Day291;

public class LC11MostWater {

    public static int containerWaterMax(int[] height) {
        if (height == null || height.length == 0) return 0;
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = height[i] > height[j] ? Math.max(res, (j - i) * height[j--])
                    : Math.max(res, (j - i) * height[i++]);
        }
        return res;
    }

    public static int containerMaxWater(int[] height) {
        if (height == null || height.length == 0) return 0;
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            if (height[i] > height[j]) {
                res = Math.max(res, height[j] * (j - i));
                j--;
            } else {
                res = Math.max(res, height[i] * (j - i));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height1 = {1, 1};
        System.out.println(containerWaterMax(height));
        System.out.println(containerWaterMax(height1));

        System.out.println(containerMaxWater(height));
        System.out.println(containerMaxWater(height1));
    }
}
