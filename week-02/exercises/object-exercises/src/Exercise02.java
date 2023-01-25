public class Exercise02 {

    public static void main(String[] args) {

        // 1. Add a getter for the rating field in Musician.

        Musician ocean = new Musician("Frank Ocean", 10);
        System.out.println(ocean.getName());
        // 2. Uncomment the line below and ensure that it compiles and runs.
        System.out.println(ocean.getRating());

        // 3. Instantiate two musicians and assign them to new variables.
        // 4. Print each musicians' name and rating on a single line.

        Musician cole = new Musician ("Keyshia Cole" , 10);
        System.out.println(cole.getName());
        System.out.println(cole.getRating());


        Musician thomas = new Musician ("Joe Thomas" , 20);
        System.out.println(thomas.getName());
        System.out.println(thomas.getRating());
    }
}
