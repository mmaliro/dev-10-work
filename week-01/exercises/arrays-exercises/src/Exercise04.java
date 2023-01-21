public class Exercise04 {

    public static void main(String[] args) {
        // 1. Declare an array to hold the names of the world's oceans.
        // Set its value using array literal notation.
        // 2. Loop over each element and print it.

        String[] worldsOceans = new String [4];

        worldsOceans[0] = "Atlantic";
        worldsOceans[1] = "Pacific";
        worldsOceans[2] = "Indian";
        worldsOceans[3] = "Arctic";

        for (int i = 0; i < worldsOceans.length; i++) {
            System.out.println(worldsOceans[i]);
        }
    }
}
