package Day113;

public class FindFirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1; //left 和 right 都不是index而是对应数组里的版本号[1,2,3,...,n]
        int right = n;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
    public boolean isBadVersion(int n) {
        if (n > 0) {
            return true;
        }
        return false;
    }
}
