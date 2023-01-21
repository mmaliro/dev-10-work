import java.util.Scanner;

public class Exercise13 {

    public static void main(String[] args) {
        // NEEDLE & HAYSTACK
        Scanner console = new Scanner(System.in);
        boolean contains = false;

        System.out.print("Needle: ");
        String needle = console.nextLine();

        System.out.print("Haystack: ");
        String haystack = console.nextLine();

        // 1. Given two string variables: needle and haystack, determine if haystack contains needle.
        // Examples
        // needle  haystack contains?
        //     an      bean      yes
        //    een      bean       no
        //    ury   Mercury      yes
        //    ury     curry       no
        //    mer   Mercury       no (case sensitive)
        // 2. As a stretch goal, display the location (index) of needle in haystack.

       int length = needle.length();

       //Starts from beginning of haystack
       //Loop ends at the length of haystack minus the length of the needle (since we do not want to go out of bounds) when looking at substrings
       //We check if each substring of haystack equals "needle"
       //If so, it'll change the boolean value to true
       //If not, the boolean remains false
       for(int x = 0; x < haystack.length() - length + 1; x++){
           if(haystack.substring(x, x + length).equals(needle)){
               contains = true;
           }
       }

        if(contains){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }
}
