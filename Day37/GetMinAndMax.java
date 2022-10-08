package Day37;

public class GetMinAndMax {
    public static void main(String[] args) {
        int[] arr = {-23,1,34,7,0,5};
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
