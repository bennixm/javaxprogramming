package Arrays;

import java.util.Scanner;

public class CyclicPalindrome {

    public static int[] readArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Size of vector: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Add Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        scanner.close();

        return array;
    }

    public static int cyclicCheck(int[] array) {
        int arrayStartPoint = 0;
        int arrayEndPoint = array.length - 1;

        while (arrayStartPoint <= arrayEndPoint) {
            if (array[arrayStartPoint] != array[arrayEndPoint]) {
                return 1;
            }
            arrayStartPoint++;
            arrayEndPoint--;
        }

        return 0;
    }

    public static int[] cyclicShift(int[] array) {
        int firstElement = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = firstElement;
        return array;
    }

    public static int cyclicMove(int[] array) {
        int move = 0;

        for (int i = 0; i < array.length; i++) {
            if (cyclicCheck(array) == 0) {
                return move;
            }
            cyclicShift(array);
            move++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] userArray = readArray();

        int cyclicMovements = cyclicMove(userArray);

        if (cyclicMovements == -1) {
            System.out.print("no way to convert into palindrome array.");
        } else if (cyclicMovements == 0) {
            System.out.print("we already have a cyclic palindrome array.");
        } else {
            System.out.print("number of cyclic movements: " + cyclicMovements);
        }
    }
}
