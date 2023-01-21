import java.util.Scanner;
public class Exercise14 {
    /* SHORT SURVEY

    Write a program that asks a user four questions and prints the results:
    - What is your first name?
    - What is your last name?
    - How many towns/cities have you lived in?
    - How many musical instruments can you play?

    Store each answer in a variable with an appropriate type.
    Print the results after the user has answered all four questions.

    Use methods to break the program into reusable blocks of code.
     */
    public static void main(String[] args) {
        String first = readString("What is your first name? ");
        String last = readString("What is your last name? ");
        int towns = readInt("How many towns/cities have you lived in? ");
        int music = readInt("How many musical instruments can you play? ");
        System.out.printf("%s %s has lived in %s towns and can play %s instruments", first, last, towns, music);
    }

    public static int readInt(String prompt) {
        return Integer.parseInt(readString(prompt));
    }

    public static String readString(String prompt) {
        Scanner console = new Scanner(System.in);
        System.out.print(prompt);
        return console.nextLine();
    }

}
