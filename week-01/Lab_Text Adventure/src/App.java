import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String location = "front entrance";

        boolean move = true;
        boolean foundItem = false;

        System.out.println("You just locked yourself out of your house, and you remember that you hid a spare key outside of the house months ago, but you don't remember where. Below are a few places you may have hidden the key.");
        System.out.println("Continue? Y/N ");
        String cont = console.nextLine();


        String command;
        while (move) {
            if (cont.equalsIgnoreCase("N")) {
                System.out.println("Ok, bye.");
                break;

            } else {
                System.out.println(location);
            }
            switch (location) {
                case "front entrance":
                    System.out.println("You're at the front entrance");
                    System.out.println("Type 'under the welcome mat' to check under the mat");
                    break;
                case "under the welcome mat":
                    System.out.println("You look under the mat");
                    System.out.println("Type 'front entrance' or 'buried in the gravel' to check front entrance or dig up the gravel");
                    break;
                case "buried in the gravel":
                    System.out.println("You dig up the gravel by the entrance");
                    System.out.println("Type 'under the welcome mat' or 'behind the house' to check if key is in the front entrance or in the back.");
                    break;
                case "behind the house":
                    System.out.println("You look behind the house under the bushes");
                    System.out.println("Type 'front entrance' or 'under the welcome mat' to go back to the front or check under the mat");
                    break;
            }

            System.out.print("Command: ");
            command = console.nextLine();

            if (command.equalsIgnoreCase("done")) {
                move = false;
            } else if (command.equalsIgnoreCase("front entrance")) {
                if (location.equalsIgnoreCase("front entrance")) {
                    System.out.println("You're already at the entrance");
                } else {
                    location = "front entrance";
                }

        } else if (command.equalsIgnoreCase("under the welcome mat")) {
            if (location.equalsIgnoreCase("under the welcome mat")) {
                System.out.println("You've already checked.");
            } else {
                location = "under the welcome mat";
            }
        } else if (command.equalsIgnoreCase("buried in the gravel")) {
            if (location.equalsIgnoreCase("buried in the gravel")) {
                System.out.println("You're already at the gravel spot");
            } else {
                location = "buried in the gravel";
            }
        } else if (command.equalsIgnoreCase("behind the house")) {
            if (location.equalsIgnoreCase("behind the house")) {
                System.out.println("You're already in the back");
            }  else {
                location = "behind the house";
            }
        } else if (command.equalsIgnoreCase("search")) {
            if (location.equalsIgnoreCase("buried in the gravel")) {
                System.out.println("You found the key!");
                foundItem = true;
            } else {
                System.out.println("Your search did not find anything");
            }
        } else {
            System.out.println("Hmmm ... I don't recognize that command");
        }

        if (foundItem) {
            System.out.println("YAY!! You won the game!");
            move = false;
        }
    }

            System.out.println();
            System.out.println("Thanks for playing");
        }

    }


