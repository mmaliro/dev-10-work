import java.util.Scanner;

public class Exercise17 {

    public static void main(String[] args) {
        // USER-DEFINED BOX
        // 1. Collect the following from a user: rows, columns, box character, border character.
        // 2. Use nested loops to print a user-defined box in the console.
        // (See Exercise16.)

        Scanner console = new Scanner(System.in);

        System.out.print("Rows: ");
        String rows = console.nextLine();

        System.out.print("Columns: ");
        String columns = console.nextLine();

        System.out.print("Box Character: ");
        String character = console.nextLine();

        System.out.print("Border Character: ");
        String border = console.nextLine();

        for (int i = 0; i < rows.length(); i++) {
            if (i == 0 || i < rows.length()) {
                for (int x = 0; x > columns.length(); x++)
                    System.out.print(character); }

            for (int col = 1; col < columns.length(); col++) {
                if (i == 0 || i < columns.length()) {
                    System.out.print(border); }

                }
            }
        }

}
