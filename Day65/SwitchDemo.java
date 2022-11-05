package Day65;

public class SwitchDemo {
    public static void main(String[] args) {
        int n = 20;
        switch(n) {
            case 10:
                System.out.println("case 10 被执行了");
                break;
            case 20:
                System.out.println("case 20 被执行了");
            case 30:
                System.out.println("case 30 被执行了");
            case 40:
                System.out.println("case 40 被执行了");
            default:
                System.out.println("default 被执行了");
        }
    }
}
