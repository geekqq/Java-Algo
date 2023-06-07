package Day240;

public class PlusMinus {

    public static void printPlusMinus(int[] arr) {
        //cc
        int countPos = 0;
        int countNeg = 0;
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > 0) {
                countPos++;
            } else if (arr[i] < 0) {
                countNeg++;
            } else {
                countZero++;
            }
        }
        double numberPos = (double) countPos / arr.length;
        String ratioPos = String.format("%.6f", numberPos);
        System.out.println(ratioPos);
        double numberNeg = (double) countNeg / arr.length;
        String ratioNeg = String.format("%.6f", numberNeg);
        System.out.println(ratioNeg);
        double numberZero = (double) countZero / arr.length;
        String ratioZero = String.format("%.6f", numberZero);
        System.out.println(ratioZero);
    }

    public static void main(String[] args) {
        int[] arr = {-1, 4,2,0,1, -4};
        printPlusMinus(arr);
    }
}
