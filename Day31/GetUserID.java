package Day31;

import java.util.Scanner;

public class GetUserID {
    public static void main(String[] args) {
        System.out.println("请输入您的邮箱：");
        String email = new Scanner(System.in).nextLine();
        int index = email.indexOf("@");   //TODO: if return -1, @ doesn't exit in the string
        if (index == -1) {
            System.out.println("邮箱格式错误");
            return;
        }
        String userName = email.substring(0, index);
        System.out.println(userName);
        System.out.println("------------");
        System.out.println(getName(email));
    }

    public static String getName(String s) {
        int index = s.indexOf("@");

        if (index == -1) {
            return "@不存在，邮箱格式错误";
        } else {
            return s.substring(0, index);
        }
    }
}
