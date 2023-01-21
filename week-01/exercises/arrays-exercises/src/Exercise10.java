import java.util.Arrays;
import java.util.Random;

public class Exercise10 {

    public static void main(String[] args) {
        String[] bugs = makeBugArray();

        // The bugs array elements are either the value "beetle" or "mosquito".
        // 1. Count the number of beetles and mosquitoes.
        // 2. Print the result.
        // Results will vary because of randomness.

        int beetlesCount = 0;
        int mosquitoesCount = 0;
        for (int i = 0; i < bugs.length; i++) {
            if (bugs[i] == "beetle") {
                beetlesCount++;
            } else if (bugs[i] == "mosquito") {
                mosquitoesCount++;
            }
        }
        System.out.println("Beetle Count: " + beetlesCount);
        System.out.println("Mosquito Count: " + mosquitoesCount);
    }

    public static String[] makeBugArray() {
        String[] bugs = new String[200];
        Arrays.fill(bugs, "beetle");
        Random random = new Random();
        for (int i = 0; i < random.nextInt(150); i++) {
            bugs[random.nextInt(bugs.length)] = "mosquito";
        }
        return bugs;
    }
}
