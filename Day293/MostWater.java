package Day293;

public class MostWater {

    public static int maxWater(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        while (l < r) {
            res = heights[l] > heights[r] ? Math.max(res,(r - l) * heights[r--])
                    : Math.max(res, (r - l) * heights[l++]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};
        System.out.println(maxWater(height2));
        System.out.println(maxWater(height));
    }
}
