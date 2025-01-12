package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeElementsOrder {

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static void reverse(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    public static int[] readArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        scanner.close();

        return array;
    }

    public static int[] modifyArray(int[] array) {
        int[] primes = new int[array.length];
        int[] nonprimes = new int[array.length];
        int primeCount = 0;
        int nonprimeCount = 0;

 
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                primes[primeCount] = array[i];
                primeCount++;
            } else {
                nonprimes[nonprimeCount] = array[i];
                nonprimeCount++;
            }
        }


        primes = Arrays.copyOf(primes, primeCount);
        nonprimes = Arrays.copyOf(nonprimes, nonprimeCount);


        Arrays.sort(primes);
        Arrays.sort(nonprimes);
        reverse(nonprimes);

        int[] result = new int[primes.length + nonprimes.length];
        System.arraycopy(primes, 0, result, 0, primes.length);
        System.arraycopy(nonprimes, 0, result, primes.length, nonprimes.length);

        return result;
    }

    public static void main(String[] args) {
        int[] userArray = readArray();

        int[] resultArray = modifyArray(userArray);

        System.out.println("Solution:");
        for (int solutionElement : resultArray) {
            System.out.print(solutionElement + " ");
        }
    }
}
