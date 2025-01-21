public class MatrixTraversal {

    public static void main(String[] args) {
        int n = 4; 
        int[][] A = {
            {0, 0, 0, 0},
            {0, 1, 2, 3},
            {0, 4, 5, 6},
            {0, 7, 8, 9}
        };

        int[][] D = calculatePaths(n);

        System.out.println("Nr of paths: " + D[1][n]);

        int[][] S = calculateMaxSum(A, n);

        System.out.println("Max SUM: " + S[1][n]);
    }

    public static int[][] calculatePaths(int n) {
        int[][] D = new int[n + 1][n + 1];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i == n || j == 1) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i][j - 1] + D[i + 1][j - 1] + D[i + 1][j];
                }
            }
        }

        return D;
    }

    public static int[][] calculateMaxSum(int[][] A, int n) {
        int[][] S = new int[n + 1][n + 1];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                S[i][j] = A[i][j] + Math.max(Math.max(S[i][j - 1], S[i + 1][j - 1]), S[i + 1][j]);
            }
        }

        return S;
    }
}
