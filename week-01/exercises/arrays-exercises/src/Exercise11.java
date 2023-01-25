import java.util.Random;

public class Exercise11 {

    public static void main(String[] args) {
        int[] values = makeRandomArray();

        // 1. Count the number of positive elements in `values`.

        int positiveValueCount = 0;
        for (int value : values) {
            if (value >= 0) {
                positiveValueCount++;
            }
        }

        System.out.println("Positive value count: " + positiveValueCount);
        // 2. Create a new int[] to hold the positive elements.

        int[] positiveValues = new int[positiveValueCount];

        // (We must count first to know the capacity to allocate.)
        // 3. Loop through `values` a second time. Add positive elements to the new array.

        for (int valuesIndex = 0, positiveValuesIndex = 0; valuesIndex < values.length; valuesIndex++) {
            if (values[valuesIndex] >= 0) {
                positiveValues[positiveValuesIndex] = values[valuesIndex];
                positiveValuesIndex++;
            }
        }

        // 4. Confirm the positive array is properly populated either by debugging or printing its elements.

        for (int i = 0; i < positiveValues.length; i++) {
            System.out.printf("%s: %s%n", i + 1, positiveValues[i]);
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





