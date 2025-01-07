public class Main {
    
    public static void P(int n, int[] x, int index, int[] mini, int[] maxi, int[] sum) {
        if (index == n) {
            return;
        }
        
        if (index == 0) {
            mini[0] = x[index];
            maxi[0] = x[index];
            sum[0] = x[index];
        } else {
            if (x[index] < mini[0]) mini[0] = x[index];
            if (x[index] > maxi[0]) maxi[0] = x[index];
            sum[0] += x[index];
        }

        P(n, x, index + 1, mini, maxi, sum);
    }

    public static void main(String[] args) {
        int n = 5;
        int[] x = {12, 5, 34, 9, 20};

        int[] mini = new int[1];
        int[] maxi = new int[1];
        int[] sum = new int[1];

        P(n, x, 0, mini, maxi, sum);

        System.out.println("Min: " + mini[0]);
        System.out.println("Max: " + maxi[0]);
        System.out.println("Sum " + sum[0]);
    }
}
