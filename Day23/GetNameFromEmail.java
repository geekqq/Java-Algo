package Day23;

import java.util.Scanner;

public class GetNameFromEmail {
    public static void main(String[] args) {
        Scanner email = new Scanner(System.in);
        System.out.println("请输入您的邮箱：");
        String s = email.nextLine();
        System.out.println(getName(s));
    }

    public static String getName(String s) {
        int index = s.indexOf("@");
        return index == -1 ? "邮箱格式错误！" : s.substring(0, index);
    }
}
