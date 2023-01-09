public class LinearSearch {

    static String[] studentNames = {"Alice", "Bob", "Charlie", "David", "Eve"};
    static String target = "Charlie";

    static double[] sheepWeights = {100.0, 105.5, 110.0, 115.0, 120.5};
    static double sheepTarget = 111.0;

    static String[] DNA = {"ATCG", "GTAC", "CGAT", "TCGA"};
    static String DNATarget = "CGAT";

    static String[] callNumbers = {"A123", "B456", "C789", "D012", "E345"};
    static String callTarget = "C789";

    static String[] serialNumbers = {"123A", "456B", "789C", "012D", "345E"};
    static String serialTarget = "012D";


    private static int StringIndexOf(String[] s, String t){
        for (int i = 0; i < s.length; i++) {
            if(s[i] == t){
                return i;
            }
        }
        return -1;
    }

    private static int DoubleIndexOf(double[] d, double t){
        for (int i = 0; i < d.length; i++) {
            if(d[i] == t){
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(StringIndexOf(studentNames,target));
        System.out.println(DoubleIndexOf(sheepWeights,sheepTarget));
        System.out.println(StringIndexOf(DNA,DNATarget));
        System.out.println(StringIndexOf(callNumbers,callTarget));
        System.out.println(StringIndexOf(serialNumbers,serialTarget));
    }
}
