public class IterativeSorting {

    /**
     * Time complexity: 0(n^2);
     * @param arr
     */

    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {

            //store the smallest thing
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                //if we find a new smallest thing, update the smallest thing
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }



    }

    static int swaps = 0;

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps += 1;
                }
            }
        }
        System.out.println("Number of swaps: " + swaps);
    }

    public static void insertionSort(int[] arr){
        int key;
        for (int i = 1; i < arr.length-1; i++) {

            key = arr[i];

            for (int j = arr.length-1; j >= 0 && arr[j] > key; j--) {

            }
        }
    }
}
