package Day01;

public class DemoArray {
    public static void main(String[] args) {
        double[] array = {1.2, 2.9, 3.4, 3.5};
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
            sum += array[i];
        }
        System.out.println("The total is: " + sum);

        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) max = array[i];
        }
        System.out.println("The max number is: " + max);

        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        System.out.println("The min number is: " + min);
    }

}
