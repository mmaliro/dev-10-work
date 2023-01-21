import java.util.Scanner;
public class Exercise12 {

    // 1. Create a method.
    // Name: readRequiredString
    // Inputs: String
    // Output: String
    // Description: prompts a user to enter a required string and returns their validated input.
    // The parameter is the message displayed to the user.
    private static String readRequiredString(Scanner console, String prompt) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(prompt);
            input = console.nextLine();
        }
        return input;
    }
    // See the readRequiredString implementation in the methods lesson.
    // You can definitely improve it. Make sure you don't allow blank input. Checking the length() is not enough.

    // 2. Create a method.
    // Name: printNounPhrase
    // Inputs: none
    // Output: none
    // Description: prints an adjective + noun phrase to the console based on user input.
    // Internally, prompts a user for an adjective and a noun with readRequiredString.
    // Concatenates adjective and noun and prints it to the console.

    private static void printNounPhrase(Scanner console) {
        String adjective = readRequiredString(console, "An adjective please: ");
        String noun = readRequiredString(console, "A noun please: ");
        System.out.printf("%s %s%n", adjective, noun);
    }

    public static void main(String[] args) {
        // 3. Uncomment the code below and confirm it works.

        Scanner console = new Scanner(System.in);
        printNounPhrase(console);
        printNounPhrase(console);
        printNounPhrase(console);
        console.close();
    }
}
