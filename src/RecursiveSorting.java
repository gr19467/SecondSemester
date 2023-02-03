public class RecursiveSorting {

    ///region Merge

    public static void mergeSort(int[] arr, int l, int r){
        //check if there is any array left to sort/split
        if(l < r){
            //calculate the middle
            int mid = (l + r)/2;
            //call mergeSort() on both halves
            mergeSort(arr,l,mid);
            mergeSort(arr,mid + 1,r);
            //call merge() on the half this run of the method is dealing with
            merge(arr,l,mid,r);
        }

    }

    private static void merge(int[] mainArr, int l, int mid, int r){
        //find the sizes of two sub-arrays that are to be merged
        int n1 = mid - l + 1;
        int n2 = r - mid;

        //create two temporary arrays, one for the left sub array and one for the right
        int[] leftSub = new int[n1];
        int[] rightSub = new int[n2];

        //copy data from main array to the sub arrays
        for (int i = 0; i < n1; i++) {
            leftSub[i] = mainArr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            rightSub[i] = mainArr[mid + 1 + i];
        }

        //actually merge the temporary arrays

        //get the initial indices of the first and second sub arrays
        int i = 0; //left pointer
        int j = 0; //right pointer

        //initial index of the merged array
        int k = l;

        //do the actual sorting
        while(i < n1 && j < n2){

            //put the smaller values earlier in the main array
            if(leftSub[i] <= rightSub[j]){

                //copy the smaller value into the main array
                mainArr[k] = leftSub[i];

                //increment the correct pointer
                i++;

            }else{
                //copy the smaller value into the main array
                mainArr[k] = rightSub[j];

                //increment the correct pointer
                j++;
            }


            //increment the main pointer
            k++;
        }

        //copy any extra data directly into the array (it does not get sorted)
        while(i < n1){
            mainArr[k] = leftSub[i];
            i++;
            k++;
        }

        while(j < n2){
            mainArr[k] = rightSub[i];
            j++;
            k++;
        }


    }

    ///endregion

    ///region Heap
    public static void heapSort(int[] arr){
        int size = arr.length;

        for (int i = size/2 - 1; i >= 0; i--) {
            heapify(arr,size,i);
        }

        for (int heapSize = size - 1; heapSize >= 0; heapSize--) {
            int temp = arr[0];
            arr[0] = arr[heapSize];
            arr[heapSize] = temp;

            heapify(arr,heapSize,0);
        }
    }

    private static void heapify(int[] arr, int size, int i){
        int largest = i;
            int l = 2*i + 1;
            int r = 2*i + 2;

            if(l < size && arr[l] > arr[largest]){
                largest = l;
            }

            if (r < size && arr[r] > arr[largest]){
                largest = r;
            }

            if(largest != i){
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;

                heapify(arr,size,largest);
            }
    }
    ///endregion

    ///region Quick
    public static void quickSort(int[] arr, int firstIndex, int lastIndex){
        if(firstIndex < lastIndex){
            int p = partition(arr, firstIndex, lastIndex);
            quickSort(arr, firstIndex, p - 1);
            quickSort(arr, p + 1, lastIndex);
        }
    }

    private static int partition(int[] arr, int firstIndex, int lastIndex){
        int pivot = arr[lastIndex];

        int i = firstIndex-1;

        for (int j = firstIndex; j <= lastIndex - 1; j++) {
            if(arr[j] <= pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[lastIndex];
        arr[lastIndex] = temp;

        return i + 1;
    }

    ///endregion
}
