public class Exercise09 {

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.

        int rows = 5;
        int columns = 5;

        printBox(5, 5);



    }

    // 1. Create a method.
    // Name: printBox
    // Inputs: int, int
    // Output: void
    // Description: prints a visual box to the console. The first parameter is the number of rows to print.
    // The second parameter is the number of columns.
    // See repetition Exercise15.

    // Expected Output (5 rows, 5 columns)
    // #####
    // #####
    // #####
    // #####
    // #####

    // (3 rows, 4 columns)
    // ####
    // ####
    // ####



    public static int printBox(int rows, int columns) {

        String box = "#";

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                System.out.print(box);
            }
            System.out.println();
        }

        return rows;
    }

}


