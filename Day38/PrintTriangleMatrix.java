package Day38;

public class PrintTriangleMatrix {
    public static void main(String[] args) {
        int[][] matrix = printTriangleMatrix(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    //matrix里有n行，第一行0个0，第二行1个0。。。第n行有n-1个0，input是n行
    public static int[][] printTriangleMatrix(int n) {
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[i];
        }
        return matrix;
    }
}
