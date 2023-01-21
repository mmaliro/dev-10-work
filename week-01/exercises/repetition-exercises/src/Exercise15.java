public class Exercise15 {

    public static void main(String[] args) {
        // BOX
        // 1. Use nested loops to print a box in the console.
        // One loop should represent rows and the other should represent columns.
        // 2. Change the row and column limit to change the shape of the box.

        // Expected Output (5X5)
        // #####
        // #####
        // #####
        // #####
        // #####

        // (3X4)
        // ####
        // ####
        // ####

        String box = "#";

        int columns = 5;
        int rows = 5;

        for (int i = 0; i < rows; i++) {
            if (i == 0 || i < rows) {
                for (int x = 0; x > columns; x++)
                    System.out.print(box); }

            for (int col = 0; col < columns; col++) {
                if (i == 0 || i < columns - 1) {
                    System.out.print(box); }


            }
            System.out.println();
            }


    }
}
