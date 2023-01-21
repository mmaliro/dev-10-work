public class Exercise10 {
    public static void main(String[] args) {
    // 1. Add a `main` method.
    // 2. Create method that accepts a String and returns that string with all of its whitespace remove.
    // 2. Call your method in various ways in the main method.

        System.out.println(NoWhiteSpace("The United States."));

}

    public static String NoWhiteSpace(String s) {
        return s.replace("\s", "");
    }

}
