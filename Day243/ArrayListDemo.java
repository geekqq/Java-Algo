package Day243;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i);
        }
        System.out.println(arr);
        arr.add(0,1);
        System.out.println(arr);
        arr.remove(Integer.valueOf(1));
        System.out.println(arr);
        System.out.println("-----------");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            L.add(sc.nextInt());
        }
        int Q = sc.nextInt();
        while (Q-- > 0) {
            String s = sc.next();
            switch (s) {
                case "Insert" :
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    L.add(x, y);
                    break;
                case "Delete" :
                    int i = sc.nextInt();
                    L.remove(i);
                    break;
            }
        }
        for (int i : L) {
            System.out.print(i + " ");
        }
    }

}
