class Main {
    public static void main(String[] args) {

        System.out.println(isPalindrome("tatertot")); // false
        System.out.println(isPalindrome("tacocat"));  // true
        System.out.println(isPalindrome("racecar"));  // true
        System.out.println(isPalindrome("noodles"));  // false
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));                  // true
        System.out.println(isPalindrome("'til I find the righteous one, Computer blue"));  // false
    }

    public static boolean isPalindrome(String word) {
        String reversed = "";


        for (int i = (word.length() - 1); i >= 0; --i) {
            if ((word.charAt(i) >= 'a' && word.charAt(i) <= 'z'))
                reversed = reversed + word.charAt(i);

            if (word.equals(reversed)) {
                return true;
            }

        }



return false;
    }


}
