public class RNA {
    public static void main(String[] args) {
        System.out.println(getRNAPair("AACG"));
    }
    public static String getRNAPair(String rna1){
        String[] rnaArray2 = new String[rna1.length()];
        String rna2;
        String[] rnaArray = rna1.split("");
        for(int i = 0; i < rna1.length() ; i++) {
            switch (rnaArray[i]) {
                case "A" -> rnaArray2[i] = "U";
                case "C" -> rnaArray2[i] = "G";
                case "G" -> rnaArray2[i] = "C";
                case "U" -> rnaArray2[i] = "A";
            }
        }
        //finds pair
        rna2 = String.join("", rnaArray2);
        return rna2;
    }
}