import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Welcome to Capsule Hotel!");
        System.out.println("====================================");
        System.out.println("Enter the number of capsules available: ");


        int numCapsules = Integer.parseInt(console.nextLine());
        System.out.println("There are " + numCapsules + " unoccupied capsules ready to be booked.");
        String[] capsules = new String[51];



        boolean run = true;

        while (run) {
            String menuOption = getMenuOption(console);

            // handle each menu option
            switch (menuOption) {
                case "1" -> handleCheckin(console, capsules);
                case "2" -> handleCheckout(console, capsules);
                case "3" -> viewGuests(console, capsules);
                case "4" -> {
                    System.out.println("Exit" + "\n" + "==========");
                    System.out.println("Are you sure you want to exit? [Y/N]");
                    String choice = console.nextLine();
                    if (choice.equalsIgnoreCase("y")) {
                        run = false;
                        break;
                    }

                }
                default -> System.out.printf("Sorry ... %s is not a valid menu option.%n", menuOption);
            }
        }
    }



    private static void viewGuests(Scanner console, String[] capsules) {
        System.out.println("View guests from: ");
        int guests = Integer.parseInt(console.nextLine());
        int i;
        for (i = guests; i < capsules.length; i++) {
            System.out.printf("Capsule #%s: %s%n", i , capsules[i] == null ? "[unoccupied]" : capsules[i]);
        }


    }

    private static void handleCheckout(Scanner console, String[] capsules) {
        System.out.printf("Guest Check Out #[1 - %s]:", capsules.length);
        int checkout = Integer.parseInt(console.nextLine());


            if ((capsules[checkout]) != null) {
                (capsules[checkout]) = null;
                System.out.println("Capsule " + checkout + " is now empty.");

            }

            else {
                System.out.println("This capsule is already empty.");
            }

        }




    private static void handleCheckin(Scanner console, String[] capsules) {
        System.out.println("Guest Check In " + "\n" + "==============");
        System.out.println("Guest Name: ");
        String name = console.nextLine();
        System.out.println("Capsule #: ");
        int checkin = Integer.parseInt(console.nextLine());

        if ((capsules[checkin]) == null) {
            capsules[checkin] = name;
            System.out.println(name + " is now booked in room " + checkin);
        } else {
            System.out.println("Error, room " + checkin + " is occupied.");
        }


    }

    private static String getMenuOption(Scanner console) {
        //display main menu
        System.out.println("Guest Menu " + "\n" + "==========");
        System.out.print("1. Check In" + "\n" + "2. Check Out" + "\n" + "3. View Guests" + "\n" + "4. Exit" + "\n" + "Choose an option [1-4]: ");
        String menuOption = (console.nextLine());
        return menuOption;
    }





}