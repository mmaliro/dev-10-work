import java.util.Random;

public class Exercise15 {

    public static void main(String[] args) {
        int[] one = makeRandomArray();
        int[] two = makeRandomArray();

        System.out.println("Array One");
        for (int i = 0; i < one.length; i++) {
            System.out.printf("%s: %s%n", i + 1, one[i]);
        }

        System.out.println("Array Two");
        for (int i = 0; i < two.length; i++) {
            System.out.printf("%s: %s%n", i + 1, two[i]);
        }

        // 1. Create a new int[] with room enough for all elements in `one` and `two`.

        int combinedLength = one.length + two.length;
        int[] combined = new int[combinedLength];
        // 2. Copy elements from `one` into the beginning of the array.
        System.arraycopy(one, 0, combined, 0, one.length);

        // 3. Copy elements from `two` at the end of the array.

        for (int i = 0; i < two.length; i++) {
            int newIndex = (combinedLength - 1) - i;
            combined[newIndex] = two[i];
        }
        // 4. Print the results to confirm that it worked.

        System.out.println("Combined");
        for (int i = 0; i < combined.length; i++) {
            System.out.printf("%s: %s%n", i + 1, combined[i]);
        }

    }

    public static int[] makeRandomArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(1000) - 500;
        }
        return result;
    }
}
