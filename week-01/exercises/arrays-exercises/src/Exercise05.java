public class Exercise05 {

    public static void main(String[] args) {
        // 1. Declare an array to hold the names of the world's continents.
        // Do not use array literal notation. Allocate space for 6 continents and then set each value by index.
        // 2. Loop over each element and print it.

        String[] continents = {"North America", "South America", "Antarctica", "Asia", "Africa", "Australia"};

        for (int i = 0; i < continents.length; i++) {
            System.out.println(continents[i]);
        }
    }
}
