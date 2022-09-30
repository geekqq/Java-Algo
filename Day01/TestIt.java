package Day01;

public class TestIt {
    public static void main(String[] args) {
        int[] myArray = {1,2,3,4,5};
        ChangeIt.dolt(myArray);

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i] + " ");
        }
    }
}
