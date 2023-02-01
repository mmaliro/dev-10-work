public class Kata {
    public static String reverseWords(final String original)
    {
        // Have at it
        String words [] = original.split("\\s");
        String reverseWords = "";
        for (String w:words) {
            StringBuilder sb = new StringBuilder(w);
            sb.reverse();
            reverseWords += sb.toString() + "";
        }
        return reverseWords.trim();


    }

}
