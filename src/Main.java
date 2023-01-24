public class Main{

    public static void main(String[] args) {
        int[] arr = {1,7,4,9,12,3,5};

        IterativeSorting.bubbleSort(arr);

        for (int i = 0; i < arr.length-1; i++) {
            System.out.println(arr[i]);
        }
     }
}
