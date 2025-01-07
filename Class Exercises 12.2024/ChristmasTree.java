public class ChristmasTree {
    public static void main(String[] args) {
        int levels = 5; // 

        // this is for the top star
        for (int i = 0; i < levels - 1; i++) {
            System.out.print(" ");
        }
        System.out.println("+");

        // here begins the tree
        for (int i = 1; i <= levels; i++) {
            // we need space for the aligments
            for (int j = 1; j <= levels - i; j++) {
                System.out.print(" ");
            }
            // write the stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //stand of the tree
        int standHeight = 2; // how many lines has the stand
        for (int i = 0; i < standHeight; i++) {
            for (int j = 0; j < levels - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("***");
        }
    }
}
