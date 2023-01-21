import java.util.Scanner;

public class Exercise15 {

    public static void main(String[] args) {
        // SWITCH OPPOSITES
        // Given a word, print its opposite using a switch statement.
        Scanner console = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = console.nextLine();
        String opposite = null;

        // 1. Re-implement Exercise08 using a switch statement.

        switch (word) {
            case "high":
                if (word.equalsIgnoreCase("high")) {
                    opposite = "low";
                    break;}


        }

        switch (word) {
            case "cold":
                if (word.equalsIgnoreCase("cold")) {
                    opposite = "hot";
                    break;}


        }

        switch (word) {
            case "little":
                if (word.equalsIgnoreCase("little"))
                { opposite = "big";
                    break;}


        }

        switch (word) {
            case "short":
                if (word.equalsIgnoreCase("short"))
                { opposite = "tall";
                    break;}


        }

        switch (word) {
            case "bald":
                if (word.equalsIgnoreCase("bald"))
                { opposite = "hairy";
                    break;}



            default:
                if (opposite == null) {
                    System.out.println("I don't have an opposite for %s.%n" + word);
                }
                break;
        }
    }
}
