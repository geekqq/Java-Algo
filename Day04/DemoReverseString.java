package Day04;

import java.util.Arrays;

public class DemoReverseString {
    public static void main(String[] args) {
        String s = "Geeks for Geek";
        System.out.println(reverse(s));
        byte[] byteArray = s.getBytes();
        System.out.println(Arrays.toString(byteArray));
        System.out.println(reverseGetBytes(s));
        System.out.println("------------------");
        char[] charArray = s.toCharArray();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            System.out.print(charArray[i]);
        }
        System.out.println("------------------");
        reverseSwap("StoneHoo@");
        System.out.println("------------------");
        String input = "Java is Great!";
        char[] myArray = input.toCharArray();
        int left = 0;
        int right = myArray.length - 1;
        for (left = 0; left < right; left++, right--) {
            char temp = myArray[left];
            myArray[left] = myArray[right];
            myArray[right] = temp;
        }
        for (char c : myArray) System.out.print(c);

    }




    public static String reverse(String s) {
        String reverse = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            reverse = c + reverse;
        }
        return reverse;
    }

    //Using getBytes() method
    public static String reverseGetBytes(String s) {
        //using getBytes() to get a byte array from the string;
        byte[] byteArray = s.getBytes();
        //creats a result array to store the result, the length is same as the byte array;
        byte[] result = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            result[i] = byteArray[byteArray.length - i - 1];
        }
        String res = new String(result);
        return res;
    }

    //Swap left and right value to reverse the string
    public static void reverseSwap(String s) {
        char[] charArray = s.toCharArray();
        int left, right = 0;
        right = charArray.length - 1;
        for (left = 0; left < right; left++, right--) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
        }
        for (char c : charArray) System.out.print(c);
    }


}
