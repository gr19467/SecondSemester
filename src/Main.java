public class Main{

    public static void main(String[] args) {
        int[] arr = {1,7,4,9,12,3,5};

        RecursiveSorting.quickSort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
     }
}
