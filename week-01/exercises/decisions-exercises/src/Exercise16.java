import java.util.Scanner;

public class Exercise16 {

    public static void main(String[] args) {
        // 1. Display the following menu and collect an integer choice from the user.
        // (See Exercise14 for a menu example.)
        //
        // Menu
        // 1. Print the name of an animal.
        // 2. Print the name of a state.
        // 3. Print the name of a beetle.
        // 4. Print the name of a mineral.
        // Select [1-4]:
        //
        // 2. Use a switch to cover cases 1-4 as well as a default.
        // For 1-4, print an animal, state, beetle, or mineral respectively.
        // For the default case, print "Unknown Menu Option".

        Scanner console = new Scanner(System.in);

        System.out.println("1.Print the name of an animal.");
        System.out.println("2.Print the name of a state.");
        System.out.println("3.Print the name of a beetle.");
        System.out.println("4.Print the name of a mineral.");

        System.out.print("Select a choice [1-4]: ");

        String animal;
        String state;
        String beetle;
        String mineral;

        int choice = Integer.parseInt(console.nextLine());

                switch (choice) {
                    case 1:
                        if (choice == 1) {
                            System.out.println("Print the name of an animal here: ");
                            animal = console.next();
                            System.out.println("You put down " + animal);
                            break;
                        }
                }

                switch (choice) {
                    case 2:
                        if (choice == 2) {
                            System.out.println("Print the name of a state here: ");
                            state = console.next();
                            System.out.println("You put down " + state);
                            break;
                        }
                }

                switch (choice) {
                    case 3:
                        if (choice == 3) {
                            System.out.println("Print the name of a beetle here: ");
                            beetle = console.next();
                            System.out.println("You put down " + beetle);
                            break;
                        }
                }

                switch (choice) {
                    case 4:
                        if (choice == 4) {
                            System.out.println("Print the name of a mineral here: ");
                            mineral = console.next();
                            System.out.println("You put down " + mineral);
                            break;
                        }


                    default:
                        if (choice < 1 || choice > 4) {
                            System.out.println("Unknown Menu Option.");
                        }
                        break;
                }



    }


}

