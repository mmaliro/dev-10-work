import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Start: ");
        int start = Integer.parseInt(console.nextLine());

        System.out.print("End: ");
        int end = Integer.parseInt(console.nextLine());

        // 1. Write a loop to sum all numbers between start and end.
        // 2. Print the result.

        int total = 0;

        for (int num = start; num <= end; num ++) {
            total += num;
            System.out.println(total);
        }
    }
}
