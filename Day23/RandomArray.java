package Day23;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        int[] a = randomArr();
        int[] b = randomArr();
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(mergeArray(a, b)));
    }

    public static int[] randomArr() {
        int n = 5 + new Random().nextInt(10);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Random().nextInt(101);
        }
        return a;
    }

    public static int[] mergeArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        //j is the index of a, k is the index of b,
        for (int i = 0, j = 0, k = 0; i < c.length; i++) {
            if (j >= a.length) {
                System.arraycopy(b, k, c, i, b.length - k);
                break;
            } else if (k >= b.length) {
                System.arraycopy(a, j, c, i, a.length - j);
                break;
            }
            if (a[j] <= b[k]) {
                c[i] = a[j];
                j++;
            }else {
                c[i] = b[k];
                k++;
            }
        }
        return c;
    }
}
