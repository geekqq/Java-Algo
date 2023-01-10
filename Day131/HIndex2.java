package Day131;

public class HIndex2 {
    public static void main(String[] args) {
        int[] citations = {1,2,3,4,5,9,12};
        System.out.println(findHIndex(citations));
    }
    public static int findHIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            } else if (citations[mid] < n - mid){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }
}
