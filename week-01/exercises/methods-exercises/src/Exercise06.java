public class Exercise06 {

    // 1. Create a method.
    // Name: isBetween
    // Inputs: int, int, int
    // Output: boolean
    // Description: return true if the first parameter is between the second and third parameter.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.
        boolean result = isBetween(2, 2, 2);
        System.out.println(result);

        System.out.println(isBetween(5, 2, 3));
        System.out.println(isBetween(10, 20, 13));
        System.out.println(isBetween(25, 12, 30));

    }

    public static boolean isBetween(int low, int med, int high) {
            return low < high && low > med;

    }
}
