package NiuKe;

/**
 * 输出所有路径中最小的路径和
 */
public class MinLength {
    public static void main(String[] args) {
        int [][]arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
    }
    public  int minPathSum (int[][] matrix) {
       int n = matrix.length;
       int m = matrix[0].length;

       int [][]arr = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                arr[0][i]+=matrix[0][j];
            }
        }

        arr[0][0] = matrix[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][0]+=matrix[j][0];
            }
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1])+matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

       return arr[n-1][m-1];
    }
}
