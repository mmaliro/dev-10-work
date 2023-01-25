import java.util.Random;

public class Exercise12 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();

        // 1. Count the number of positive and non-positive elements in `values`.
        int positiveValueCount = 0;
        int negativeValueCount = 0;
        for (int value : values) {
            if (value >= 0) {
                positiveValueCount++;
            } else {
                negativeValueCount++;
            }
        }

        System.out.println("Positive value count: " + positiveValueCount);
        System.out.println("Negative value count: " + negativeValueCount);
        // 2. Create two new int[]s, one for positive elements and one for non-positive.
        int[] positiveValues = new int[positiveValueCount];
        int[] negativeValues = new int[negativeValueCount];

        // (We count first to determine the capacity to allocate.)
        // 3. Loop through `values` a second time. If an element is positive, add it to the positive array.
        for (int valuesIndex = 0, positiveValuesIndex = 0, negativeValuesIndex = 0;
             valuesIndex < values.length; valuesIndex++) {
            if (values[valuesIndex] >= 0) {
                positiveValues[positiveValuesIndex] = values[valuesIndex];
                positiveValuesIndex++;
            } else {
                negativeValues[negativeValuesIndex] = values[valuesIndex];
                negativeValuesIndex++;
            }
        }
        // If it is non-positive, add it to the non-positive array.
        // 4. Confirm that your secondary arrays are properly populated either by debugging or printing their elements.

        System.out.println("Positive Values");
        for (int i = 0; i < positiveValues.length; i++) {
            System.out.printf("%s: %s%n", i + 1, positiveValues[i]);
        }

        System.out.println("Negative Values");
        for (int i = 0; i < negativeValues.length; i++) {
            System.out.printf("%s: %s%n", i + 1, negativeValues[i]);
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
