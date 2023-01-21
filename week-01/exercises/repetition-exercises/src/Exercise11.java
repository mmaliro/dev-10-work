import java.util.Scanner;

public class Exercise11 {

    public static void main(String[] args) {


        Scanner console = new Scanner(System.in);
        System.out.print("Start: ");
        int start = Integer.parseInt(console.nextLine());

        System.out.print("End: ");
        int end = Integer.parseInt(console.nextLine());

        System.out.print("Increment: ");
        int inc = Integer.parseInt(console.nextLine());


        int total = 0;

        for (int num = start; num <= end; num += inc) {
            total += num;
            System.out.println(total);
        }



    }

}
