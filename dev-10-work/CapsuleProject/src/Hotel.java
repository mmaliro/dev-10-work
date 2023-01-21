import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        displayWelcomeMessage();

    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome!");
    }

    private static void run(String[] capsules, Scanner console) {
        boolean exit = false;
        do {
            String menuOption = getMenuOption(console);

            switch (menuOption) {
                case "1" : handleCheckin(console, capsules);
                case "2" : handleCheckout(console, capsules);
                case "3" : handle
            }

        }

    }

    private static void confirmExit(Scanner console, String)
}
