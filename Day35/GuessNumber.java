package Day35;

public class GuessNumber {
    //LC374
//    public int guessNumber(int n) {
//        int left = 1;
//        int right = n;
//        int mid = 0;
//
//        while (left <= right) {
//            mid = left + (right - left) / 2;
//
//            if (guess(mid) == 0) {
//                return mid;
//            } else if (guess(mid) == -1) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return -1;
//    }
// LC题目中已经pre defined 了 guess() 所以不用写，但是自己写的话，这个pick是怎么来的？guess只有一个参数，没办法比较啊。
//    public int guess(int n) {
//        if (n == pick) {
//            return 0;
//        } else if (n < pick) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
}
