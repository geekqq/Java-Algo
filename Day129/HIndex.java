package Day129;

public class HIndex {
    public static void main(String[] args) {

    }
    public static int findHIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
}
