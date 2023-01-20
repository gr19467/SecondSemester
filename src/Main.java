public class Main{

    public static void main(String[] args) {
        int[] arr = new int{6, 3, 2, 7, 1 };

        IterativeSorting.bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
     }
}
