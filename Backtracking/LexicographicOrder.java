package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LexicographicOrder {
    static int[] D = new int[401];
    static int[] X = new int[401];
    static int n = 0;
    static long s;

    static void afisare(int k) {
        for (int i = 1; i <= k; i++) {
            System.out.print(D[X[i]] + " ");
        }
        System.out.println();
    }

    static void back(int k, long pp) {
        for (int i = X[k - 1] + 1; i <= n && pp * D[i] <= s; i++) {
            X[k] = i;
            pp *= D[X[k]];
            if (pp <= s) {
                if (pp == s) {
                    afisare(k);
                } else {
                    back(k + 1, pp);
                }
            }
            pp /= D[X[k]];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLong();

        ArrayList<Integer> divisors = new ArrayList<>();

        for (long i = 2; i * i <= s; i++) {
            if (s % i == 0) {
                divisors.add((int) i);
                if (i * i != s) {
                    divisors.add((int) (s / i));
                }
            }
        }

        if (divisors.isEmpty()) {
            System.out.println("NU EXISTA");
        } else {
            Collections.sort(divisors);

            for (int i = 0; i < divisors.size(); i++) {
                D[++n] = divisors.get(i);
            }

            back(1, 1);
        }

        scanner.close();
    }
}

