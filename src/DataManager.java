import java.util.Objects;

public class DataManager {

    public static MedicalRecord[] records;

    public DataManager(){
        records = new MedicalRecord[40];
    }

    public static void addRecord(MedicalRecord mr){
        records[lastPatient() + 1] = mr;

        //make sure the records are sorted now that a new record has been added
        sortRecords();
    }

    /**
     * Last patient finds the last index that is not null, since .length will return 40.
     * @return
     */
    private static int lastPatient(){
        int i = 0;

        //if the index you're on is null, return -1
        if(records[i] == null){
            return -1;
        }

        //if the next index is not null, keep counting
        while(records[i + 1] != null){
            i++;
        }

        //if the next index was null, i is now the last patient
        return i;
    }

    /**
     * Removes a record that is no longer needed by copying on top of that index and moving everything backwards.
     * @param mr
     */
    public static void removeRecord(MedicalRecord mr){
        //make sure the records are sorted
        sortRecords();

        //get the index we need to remove
        int remove = getRecordIndex(mr.getlName(), mr.getfName());

        //copy over our index, then move all indexes above that backwards
        while(records[remove] != null){
            records[remove] = records[remove + 1];
            remove++;
        }
    }

    /**
     * Gets the index of whatever record you're looking for using the last name and first name.
     * @param lastName
     * @param firstName
     * @return
     */
    private static int getRecordIndex(String lastName, String firstName){
        //set up for the split
        int leftPointer = 0;
        int rightPointer = lastPatient();

        //as long as we have data left to search
        while(leftPointer <= rightPointer){
            //find the middle index
            int mid = (leftPointer + rightPointer)/2;
            System.out.println("Mid is " + mid);

            //if the middle index contains the target last name
            if(Objects.equals(records[mid].getlName(), lastName)){
                System.out.println("Last names match.");

                //make sure the first name also matches
                if (Objects.equals(records[mid].getfName(),firstName)) {
                    System.out.println("First names matched, returned " + mid);
                    return mid;
                }else{
                    System.out.println("First names did not match.");
                    //move the pointers
                    if((records[mid].getfName().compareTo(firstName)) > 0){
                        //left half
                        rightPointer = mid-1;
                        System.out.println("First name comes before mid: " + records[mid].getfName() + " vs. " + firstName);
                    }

                    if((records[mid].getfName().compareTo(firstName)) < 0){
                        //right half
                        leftPointer = mid+1;
                        System.out.println("First name comes after mid: " + records[mid].getfName() + " vs. " + firstName);
                    }
                }
            }

            //move the pointers
            if((records[mid].getlName().compareTo(lastName)) > 0){
                //left half
                rightPointer = mid - 1;
                System.out.println("Last name comes before mid: " + records[mid].getlName() + " vs. " + lastName);
            }

            if((records[mid].getlName().compareTo(lastName)) < 0){
                //right half
                leftPointer = mid+1;
                System.out.println("Last name comes after mid: " + records[mid].getlName() + " vs. " + lastName);
            }

        }

        return -1;
    }

    ///region Sorting Methods
    /**
     * Uses quick sort to sort the records by last name, then by first name if needed.
     */
    public static void sortRecords(){
        quickSort(records, 0, lastPatient());
    }

    /**
     * A quick sort algorithm.
     * @param arr
     * @param firstIndex
     * @param lastIndex
     */
    private static void quickSort(MedicalRecord[] arr, int firstIndex, int lastIndex){
        if(firstIndex < lastIndex){
            int p = partition(arr, firstIndex, lastIndex);
            quickSort(arr, firstIndex, p - 1);
            quickSort(arr, p + 1, lastIndex);
        }
        for (int i = 0; i < lastIndex; i++) {
            if(arr[i].getlName().compareTo(arr[i + 1].getlName()) == 0){
                if(arr[i].getfName().compareTo(arr[i + 1].getfName()) > 0){
                    MedicalRecord temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * The helper method for quick sort.
     * @param arr
     * @param firstIndex
     * @param lastIndex
     * @return
     */
    private static int partition(MedicalRecord[] arr, int firstIndex, int lastIndex){
        MedicalRecord pivot = arr[lastPatient()];

        int i = firstIndex-1;

        for (int j = firstIndex; j <= lastIndex - 1; j++) {
            if(arr[j].getlName().compareTo(pivot.getlName()) < 0){
                i++;

                MedicalRecord temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        MedicalRecord temp = arr[i + 1];
        arr[i + 1] = arr[lastIndex];
        arr[lastIndex] = temp;

        return i + 1;
    }
    ///endregion

    /**
     * Prints each record in the format "last name, first name".
     * @param arr
     */
    public static void printRecords(MedicalRecord[] arr) {
        for (int i = 0; i <= lastPatient(); i++) {
            System.out.println(arr[i].getlName() + ", " + arr[i].getfName());
        }
    }

}