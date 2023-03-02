package learn.rps;

import java.util.Scanner;

public class ConsoleIO {

    private static final Scanner console = new Scanner(System.in);

    public static int readInt(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = console.nextLine();
            try {
                int result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.out.printf("%s is not between %s and %s.%n", result, min, max);
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.out.println("That's not a number.");
            }
        }
    }
}
