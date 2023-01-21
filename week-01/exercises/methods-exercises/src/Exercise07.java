public class Exercise07 {

    // 1. Create a method.
    // Name: areInOrder
    // Inputs: int, int, int, int
    // Output: boolean
    // Description: return true if the four parameters are in ascending order.
    // Otherwise, returns false.

    public static void main(String[] args) {
        // 2. Call your method in various ways to test it here.

        boolean result = areInOrder(9, 10, 11, 20);
        System.out.println(result);

        System.out.println(areInOrder(5,2,10, 1));
        System.out.println(areInOrder(9,19,15, 19));
        System.out.println(areInOrder(15,25,30, 41));
    }


    public static boolean areInOrder(int a, int b, int c, int d){
        return (a < b && b < c && c < d);

        }

}


