import java.util.Objects;

public class DataManager {

    private static MedicalRecord[] records;

    public DataManager(){
        records = new MedicalRecord[40];
    }

    //done
    public void addRecord(MedicalRecord mr){
        mr = records[lastPatient() + 1];

        //make sure the records are sorted now that a new record has been added
        sortRecords();
    }

    //done
    private static int lastPatient(){
        int i = 0;

        while(records[i + 1] != null){
            i++;
        }

        return i;
    }

    //done
    public void removeRecord(MedicalRecord mr){
        sortRecords();

        int remove = getRecordIndex(mr.getlName(), mr.getlName());

        int i = remove;

        while(records[i] != null){
            records[i] = records[i + 1];
        }
    }

    //done
    private int getRecordIndex(String lastName, String firstName){
        //set up for the split
        int leftPointer = 0;
        int rightPointer = lastPatient();

        //as long as we have data left to search
        while(leftPointer <= rightPointer){
            //find the middle index
            int mid = (leftPointer + rightPointer)/2;

            //if the middle index contains the target
            if(Objects.equals(records[mid], lastName) && Objects.equals(records[mid], firstName)){
                //make sure the first name also matches
                if (records[mid].getfName().compareTo(firstName) == 0) {
                    return mid;
                }else{
                    //move the pointers
                    if((records[mid].getfName().compareTo(firstName)) > 0){
                        //left half
                        rightPointer = mid-1;
                    }

                    if((records[mid].getfName().compareTo(firstName)) < 0){
                        //right half
                        leftPointer = mid+1;
                    }
                }
            }

            //move the pointers
            if((records[mid].getlName().compareTo(lastName)) > 0){
                //left half
                rightPointer = mid-1;
            }

            if((records[mid].getlName().compareTo(lastName)) < 0){
                //right half
                leftPointer = mid+1;
            }

        }

        return -1;
    }

    //done
    public void sortRecords(){
        quickSort(records, 0, lastPatient());
    }

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

    public static void printRecords(MedicalRecord[] arr){
        for (int i = 0; i < lastPatient(); i++) {
            System.out.println(arr[i].getlName() + ", " + arr[i].getfName());
        }
    }

}