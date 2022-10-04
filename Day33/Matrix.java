package Day33;

public class Matrix {
    public static void main(String[] args) {
        int[][] numsMatrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5},
        };

        setZeroesMatrix(numsMatrix);
        for (int i = 0; i < numsMatrix.length; i++) {
            for (int j = 0; j < numsMatrix[0].length; j++) {
                System.out.print(numsMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] setZeroesMatrix(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        boolean[] rows = new boolean[n]; //定义一个boolean数组记录每一行是否有0，初始值均为false
        boolean[] cols = new boolean[m]; //定义一个boolean数组积累每一列是否有0
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
