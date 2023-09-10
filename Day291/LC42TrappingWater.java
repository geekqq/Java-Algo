package Day291;

public class LC42TrappingWater {

    public static int trapWater(int[] height) {
        if (height == null || height.length == 0) return 0;
        int lMax = 0;
        int rMax = 0;
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i <= j) {
            lMax = Math.max(lMax, height[i]);
            rMax = Math.max(rMax, height[j]);
            if (lMax > rMax) {
                res += rMax - height[j--];
            } else {
                res += lMax - height[i++];
            }
        }
        return res;
    }

    public static int trapWaterI(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int l = 0;
        int r = arr.length - 1;
        int leftMax = arr[l];
        int rightMax = arr[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, arr[l]);
                res += leftMax - arr[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, arr[r]);
                res += rightMax - arr[r];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height1 = {4,2,0,3,2,5};
        System.out.println(trapWater(height));
        System.out.println(trapWater(height1));
        System.out.println("=========");
        System.out.println(trapWaterI(height));
        System.out.println(trapWaterI(height1));
    }
}
