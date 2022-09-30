package Day24;

import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        String s = new Scanner(System.in).nextLine();
        int letterCount = 0;
        int spaceCount = 0;
        int otherCount = 0;
        int digitCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                letterCount++;
            } else if (s.charAt(i) == ' ') {
                spaceCount++;
            } else if (Character.isDigit(s.charAt(i))) {
                digitCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println("字母的个数：" + letterCount);
        System.out.println("数字的个数：" + digitCount);
        System.out.println("空格的个数：" + spaceCount);
        System.out.println("其它字符的个数：" + otherCount);
    }
}
