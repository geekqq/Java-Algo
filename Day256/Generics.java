package Day256;

public class Generics {

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {5.5,4.4, 3.3, 2.2, 1.1};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        String[] stringArray = {"B", "Y", "E"};

        displayArray(intArray);
        displayArray(doubleArray);
        displayArray(charArray);
        displayArray(stringArray);
    }

    public static void displayArray(Integer[] array) {
        for (Integer x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void displayArray(Double[] array) {
        for (Double x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void displayArray(Character[] array) {
        for (Character x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void displayArray(String[] array) {
        for (String x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

}
