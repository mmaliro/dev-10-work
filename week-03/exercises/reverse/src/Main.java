import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        class Kata {
            public static String reverseWords(final String original) {
                // Have at it
                String str = "name ching chang field computer engineering grade 9.98";
                String[] splits = str.split(" ");
                for (int i = 0; i < splits.length; i++) {
                    StringBuilder sb = new StringBuilder(splits[i]);
                    splits[i] = sb.reverse().toString();
                }
                System.out.println(Arrays.asList(splits));

                return reverseWords(splits);
            }

        }
    }
}