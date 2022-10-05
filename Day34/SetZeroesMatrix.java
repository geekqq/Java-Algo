package Day34;

public class SetZeroesMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {3,5,1,6},
                {0,1,5,9},
                {2,0,4,6},
                {1,4,7,4},
        };

        setZeroesMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] setZeroesMatrix(int[][] nums) {
        int n = nums.length; //行数
        int m = nums[0].length; //列数

        boolean[] rows = new boolean[n]; //行数的boolean数组，用来保存每一行里是否有0，有0设置为true
        boolean[] cols = new boolean[m]; //列数同上

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || cols[j]) {
                    nums[i][j] = 0;
                }
            }
        }
        return nums;
    }
}
