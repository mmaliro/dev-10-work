import java.util.Objects;
import java.util.Scanner;
public class Pangram2 {
    public static void main(String[] args) {
//        System.out.println(isPangram("A quick brown fox jumps over the lazy dog."));
//        System.out.println(isPangram("This string doesn't contain everything."));
//        System.out.println(isPangram(" "));
        Scanner console = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("Enter a string: ");
//            System.out.println("enter 'STOP' to stop");
            userInput = console.nextLine();
            if (isPangram(userInput)) {
                System.out.println("This is a pangram.");
            } else {
                System.out.println("This is not a pangram");
            }
        } while (!Objects.equals(userInput, "STOP"));
    }
    public static boolean isPangram(String input){
        input = input.toLowerCase();
        boolean hasAllLetters = false;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if(!input.contains(ch + "")){
//                System.out.println(ch + " is not in the text");
                hasAllLetters = false;
            } else{
                hasAllLetters = true;
            }
        }
        return hasAllLetters;
    }
}