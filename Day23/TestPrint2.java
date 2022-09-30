package Day23;

import java.util.Scanner;

public class TestPrint2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的身高：");
        double height = input.nextDouble();
        System.out.println("请输入您的体重：");
        double weight = input.nextDouble();
        double bmi = weight / (height * height);

        if (bmi < 18.5) System.out.println("过轻了");
        else if (bmi >= 18.5 && bmi <= 22.9) System.out.println("正常！");
        else if (bmi >= 23 && bmi <= 24.9) System.out.println("偏胖！");
        else if (bmi >= 25 && bmi <= 29.9) System.out.println("偏肥！");
        else if (bmi >= 30 && bmi <= 40) System.out.println("重度肥胖！");
        else if (bmi > 40) System.out.println("极度肥胖！");
    }
}
