import java.util.Scanner;

public class Exercise14 {

    public static void main(String[] args) {
        // DAYS OF THE WEEK
        Scanner console = new Scanner(System.in);

        System.out.println("1. Monday");
        System.out.println("2. Tuesday");
        System.out.println("3. Wednesday");
        System.out.println("4. Thursday");
        System.out.println("5. Friday");
        System.out.println("6. Saturday");
        System.out.println("7. Sunday");
        System.out.print("Select a day [1-7]: ");

        int day = Integer.parseInt(console.nextLine());

        // 1. Add cases for days 2-7. Print a tired cliché for each day.
        switch (day) {
            case 1:
                if (day == 1)
                {System.out.println("I refuse to say \"a case of the Mondays\".");
                break;}

        }

        switch (day) {
            case 2:
                if (day == 2)
                { System.out.println("I refuse to say \"Live every day like it's Taco Tuesday.\".");
                break;}


        }

        switch (day) {
            case 3:
                if (day == 3)
                {System.out.println("I refuse to say \"It's Hump Day!\".");
                break;}


        }

        switch (day) {
            case 4:
                if (day == 4)
                { System.out.println("I refuse to say \"Nothing ruins a Friday like realizing it’s Thursday\".");
                break;}


        }

        switch (day) {
            case 5:
                if (day == 5)
                { System.out.println("I refuse to say \"Friday sees more smiles than any other day of the workweek!\".");
                break;}


        }

        switch (day) {
            case 6:
                if (day == 6)
                System.out.println("I refuse to say \"Saturday is for SOLITUDE. Spend time with YOU.\".");
                break;


        }

        switch (day) {
            case 7:
                if (day == 7)
                System.out.println("I refuse to say \"The goal of Sunday is to leave my home as little as possible.\".");
                break;



            default:
                if (day < 1 || day > 7) {
                    System.out.println("I don't recognize that day.");
                }
                break;
        }




    }
}
