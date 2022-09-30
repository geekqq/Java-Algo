package Day23;

public class TwoWayArray {
    public static void main(String[] args) {
        char[][] a = {
                {'道','路','千','万','条'},
                {'安','全','第','一','条'},
                {'行','车','不','规','范'},
                {'亲','人','两','行','泪'},
        };

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
