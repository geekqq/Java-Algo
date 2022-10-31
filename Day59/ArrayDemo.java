package Day59;

public class ArrayDemo {
    public static void main(String[] args) {
        //int[] arr11 = new int[4] {3,4,5,6};
        int[] nums = {'a', 23, 45, 6};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        int x = 1, y = 1;
        if (x++ == 2 & ++y == 2) {
            x = 7;
        }
        System.out.println("x = " + x + ", y = " + y);
        boolean b = true;
        if (b = false) {
            System.out.println("a");
        } else if (b) {
            System.out.println(b);
        } else if (!b) {
            System.out.println("c");
        } else {
            System.out.println("d");
        }
        int n = 2, m = 3;
        switch(n) {
            default:
                y++;
            case 3:
                y++;
            case 4:
                y++;
        }
        System.out.println(y);
    }
}
