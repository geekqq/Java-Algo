package Day132;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {1,2,3,4,5,9,12};
        int[] citations2 = {5};
        System.out.println(findHIndex(citations2));
        System.out.println(findHIndex(citations));
    }

    public static int findHIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return -1;
        }
        if (citations.length == 1) {
            return citations[0] == 0 ? 0 : 1;
        }

        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left);
            if (citations[mid] == n - mid) {
                return n -mid;
            } else if (citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
}
