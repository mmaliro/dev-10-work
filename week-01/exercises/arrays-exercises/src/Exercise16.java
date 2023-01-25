import java.util.Random;

public class Exercise16 {

    public static void main(String[] args) {
        // MERGE
        int[] one = makeRandomAscendingArray();
        int[] two = makeRandomAscendingArray();

        System.out.println("Array One");
        for (int i = 0; i < one.length; i++) {
            System.out.printf("%s: %s%n", i + 1, one[i]);
        }

        System.out.println("Array Two");
        for (int i = 0; i < two.length; i++) {
            System.out.printf("%s: %s%n", i + 1, two[i]);
        }

        // makeRandomAscendingArray creates a random array with a capacity between 50 and 150.
        // Its elements are guaranteed to be sorted ascending.
        // 1. Create a new int[] with capacity for all elements from `one` and `two`.

        int combinedLength = one.length + two.length;
        int[] combined = new int[combinedLength];

        // 2. "Merge" elements from `one` and `two` into the new array so that its values are sorted.

         /* Pseudocode:
         Create an integer index for `one`, `two`, and the result array, all starting at 0.
         Loop resultIndex from 0 to result.length - 1:
           if one[oneIndex] is less than two[twoIndex], add it to the result and increment oneIndex.
           if two[twoIndex] is less than one[oneIndex], add it to the result and increment twoIndex.
           determine how to settle ties
           if oneIndex >= one.length, there are no `one` elements remaining so use elements from two
           if twoIndex >= two.length, there are no `two` elements remaining so use elements from one
          */

        for (int combinedIndex = 0, oneIndex = 0, twoIndex = 0; combinedIndex < combined.length; combinedIndex++) {
            if (oneIndex >= one.length) {
                combined[combinedIndex] = two[twoIndex];
                twoIndex++;
            } else if (twoIndex >= two.length) {
                combined[combinedIndex] = one[oneIndex];
                oneIndex++;
            } else if (one[oneIndex] <= two[twoIndex]) {
                combined[combinedIndex] = one[oneIndex];
                oneIndex++;
            } else if (two[twoIndex] < one[oneIndex]) {
                combined[combinedIndex] = two[twoIndex];
                twoIndex++;
            }
        }
        System.out.println("Combined");
        for (int i = 0; i < combined.length; i++) {
            System.out.printf("%s: %s%n", i + 1, combined[i]);
        }
    }



    public static int[] makeRandomAscendingArray() {
        Random random = new Random();
        int[] result = new int[random.nextInt(100) + 50];
        int current = random.nextInt(11);
        for (int i = 0; i < result.length; i++) {
            result[i] = current;
            current += random.nextInt(4);
        }
        return result;
    }
}
