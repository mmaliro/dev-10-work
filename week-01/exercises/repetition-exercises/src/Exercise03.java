public class Exercise03 {

    public static void main(String[] args) {
        // 1. Write a loop to count backward from 23 to 17.

        // Expected Output
        // 23
        // 22
        // 21
        // 20
        // 19
        // 18
        // 17

        int back = 23;
        while (back >= 17 && back <= 23) {
            System.out.println(back);
            back--;
        }
    }
}
