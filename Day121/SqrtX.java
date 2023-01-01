package Day121;

public class SqrtX {
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 2;
        int right = x / 2;
        int res;
        while (left <= right) {
            res = left + (right - left) / 2;
            if (res < x/res) {
                left = res + 1;
            } else if (res > x/res){
                right = res - 1;
            } else {
                return res;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(3));
    }
}
