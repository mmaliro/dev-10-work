import java.util.Scanner;

public class Exercise09 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("Please enter a minimum value: ");
        int min = Integer.parseInt(console.nextLine());

        System.out.println("Please enter a maximum value: ");
        int max = Integer.parseInt(console.nextLine());

        System.out.println("Please enter your actual value: ");
        int actual = Integer.parseInt(console.nextLine());

        if (actual > min && actual < max) {
            System.out.println("Very good! Your actual number is between your minimum and maximum number. ");
        }

        else
        {
            System.out.println("Oops! Your actual number is not between the minimum and maximum number.");
        }


    }
}
