package Day136;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {2};
        System.out.println(findHIndex(citations));
    }
    private static int findHIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int left = 0;
        int n = citations.length;
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
