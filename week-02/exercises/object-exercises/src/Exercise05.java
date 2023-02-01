import java.util.Scanner;

public class Exercise05 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Musician[] musicians = new Musician[5];
        musicians[0] = new Musician("Frank Ocean", 10);

        // 1. Use a loop to populate the `musicians` array with your top 5 favorite musicians.
        // (Replace Frank Ocean.)
        // Create musicians from user input. (See Exercise04.)

        for (int i = 0; i < musicians.length; i++) {
            Musician m = new Musician();
            System.out.print("Joe:");
            m.setName(console.nextLine());
            System.out.print("Keyshia Cole:");
            m.setName(console.nextLine());
            System.out.print("Avant:");
            m.setName(console.nextLine());
            System.out.print("Toni Braxton:");
            m.setName(console.nextLine());
            System.out.print("Chris Brown:");
            m.setName(console.nextLine());
            int rating = Integer.parseInt(console.nextLine());
            m.setRating(rating);
            musicians[i] = m;
        }

        // 2. Use a second loop to print details about each musician.

        for (Musician musician : musicians) {
            System.out.printf("%s: %s%n", musician.getName(), musician.getRating());
        }
    }
}
