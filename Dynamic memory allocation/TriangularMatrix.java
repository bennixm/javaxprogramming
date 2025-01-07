public class TriangularMatrix {
    public static void main(String[] args) {
        int n = 5;

        int[][] A = new int[n][];
        for (int i = 0; i < n; i++) {
            A[i] = new int[i + 1];
        }

        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                A[i][j] = k++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
