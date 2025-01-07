public class ArrayStats {

    public static void P(int n, int[] x, int index, int[] mini, int[] maxi, int[] sum) {
        if (index == n) return;
        if (index == 0) mini[0] = maxi[0] = sum[0] = x[index];
        else {
            mini[0] = Math.min(mini[0], x[index]);
            maxi[0] = Math.max(maxi[0], x[index]);
            sum[0] += x[index];
        }
        P(n, x, index + 1, mini, maxi, sum);
    }

    public static void main(String[] args) {
        int[] x = {12, 5, 34, 9, 20};
        int[] mini = new int[1], maxi = new int[1], sum = new int[1];
        P(x.length, x, 0, mini, maxi, sum);
        System.out.println("Min: " + mini[0] + ", Max: " + maxi[0] + ", Sum: " + sum[0]);
    }
}
