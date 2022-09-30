package Day05;

import java.util.Scanner;

public class DemoPhoneNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the phone number: ");
        String number = input.nextLine().toLowerCase();
        String newNum = "";
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (!Character.isLetter(c) && !Character.isDigit(c)) newNum = "This is not a valid phone number";
            else if (c >= 48 && c <= 57) newNum += c;
            else if (c >= 97 && c <= 99) newNum += "2";
            else if (c >= 100 && c <= 102) newNum += "3";
            else if (c >= 103 && c <= 105) newNum += "4";
            else if (c >= 106 && c <= 108) newNum += "5";
            else if (c >= 109 && c <= 111) newNum += "6";
            else if (c >= 112 && c <= 115) newNum += "7";
            else if (c >= 116 && c <= 118) newNum += "8";
            else if (c >= 119 && c <= 122) newNum += "9";
        }
        System.out.println(newNum);;
    }
}
