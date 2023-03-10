import java.util.Objects;

public class BinarySearch {

    static int[] grades = {60, 70, 75, 80, 85, 90, 95};
    static int target = 80;
    static double[] atomicWeights = {1.0079, 4.0026, 6.941, 6.941, 9.0122, 10.811, 12.0107, 12.0107, 14.0067};
    static double weightTarget = 12.0107;
    static short[] dates = {1492, 1776, 1803, 1861, 1861, 1861, 1945};
    static short dateTarget = 1861;
    static String[] patientNames = {"Brown", "Johnson", "Johnson", "Johnson", "Johnson", "Jones", "Smith", "Williams"};
    static String patientTarget = "Johnson";
    static Ingredient[] ingredients = {new Ingredient("cinnamon", 12.25f), new Ingredient("flour", 400.50f), new Ingredient("pepper", 10.56f), new Ingredient("salt", 40.78f), new Ingredient("salt", 50), new Ingredient("sugar")};
    static Ingredient ingredientTarget = new Ingredient("pepper");

    public static int iterativeBinarySearch(int[] arr,int target){
        //set up for the split
        int leftPointer = 0;
        int rightPointer = arr.length-1;

        //as long as we have data left to search
        while(leftPointer <= rightPointer){
            //find the middle index
            int mid = (leftPointer + rightPointer)/2;
            //if the middle index contains the target
            if(mid == target){
                //if it does, return
                return mid;
            }
            //if not:
            if(arr[mid] > target){
                //left half
                rightPointer = mid-1;
            }

            if(arr[mid] < target){
                //right half
                leftPointer = mid+1;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] arr, int target, int left, int right){
        if(right < left){
            return -1;
        }else {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                return recursiveBinarySearch(arr, target, left, mid - 1);
            }

            if (arr[mid] < target) {
                return recursiveBinarySearch(arr, target, mid + 1, right);
            }
        }
        return -1;
    }

    public static int question1(int[] arr,int target){
        //set up for the split
        int leftPointer = 0;
        int rightPointer = arr.length-1;

        //as long as we have data left to search
        while(leftPointer <= rightPointer){
            //find the middle index
            int mid = (leftPointer + rightPointer)/2;
            //if the middle index contains the target
            if(arr[mid] == target){
                //if it does, return
                return mid;
            }
            //if not:
            if(arr[mid] > target){
                //left half
                rightPointer = mid-1;
            }

            if(arr[mid] < target){
                //right half
                leftPointer = mid+1;
            }
        }
        return -1;
    }

    //TODO: Find the first occurrence
    public static int question2(double[] arr,double target){
        //set up for the split
        int leftPointer = 0;
        int rightPointer = arr.length-1;

        //as long as we have data left to search
        while(leftPointer <= rightPointer){
            //find the middle index
            int mid = (leftPointer + rightPointer)/2;
            //if the middle index contains the target
            if(arr[mid] == target){
                while(arr[mid] == target){
                    mid -= 1;
                }
                return mid + 1;
            }
            //if not:
            if(arr[mid] > target){
                //left half
                rightPointer = mid-1;
            }

            if(arr[mid] < target){
                //right half
                leftPointer = mid+1;
            }
        }
        return -1;
    }

    public static int question3(short[] arr, short target){
        //set up for the split
        int leftPointer = 0;
        int rightPointer = arr.length-1;

        //as long as we have data left to search
        while(leftPointer <= rightPointer){
            //find the middle index
            int mid = (leftPointer + rightPointer)/2;
            //if the middle index contains the target
            if(arr[mid] == target){
                while(arr[mid] == target){
                    mid += 1;
                }
                return mid - 1;
            }
            //if not:
            if(arr[mid] > target){
                //left half
                rightPointer = mid-1;
            }

            if(arr[mid] < target){
                //right half
                leftPointer = mid+1;
            }
        }
        return -1;
    }

    public static int question4(String[] arr, String target){
        //set up for the split
        int leftPointer = 0;
        int rightPointer = arr.length-1;

        //add a counter for the name
        int occurrences = 0;

        //as long as we have data left to search
        while(leftPointer <= rightPointer){
            //find the middle index
            int mid = (leftPointer + rightPointer)/2;

            //if the middle index contains the target
            if(Objects.equals(arr[mid], target)){
                occurrences += 1;
                leftPointer += 1;
                rightPointer -=1;
            }

            //move the pointers
            if(arr[mid].compareTo(target) > 0){
                //left half
                rightPointer = mid-1;
            }

            if(arr[mid].compareTo(target) < 0){
                //right half
                leftPointer = mid+1;
            }

        }
        return occurrences;
    }

    public static int question5(Ingredient[] arr, Ingredient target){
        //set up for the split
        int leftPointer = 0;
        int rightPointer = arr.length-1;

        //as long as we have data left to search
        while(leftPointer <= rightPointer){
            //find the middle index
            int mid = (leftPointer + rightPointer)/2;

            //if the middle index contains the target
            if(arr[mid].sameIngredientType(target)){
                return mid;
            }

            //move the pointers
            if(arr[mid].compareTo(target) > 0){
                //left half
                rightPointer = mid-1;
            }

            if(arr[mid].compareTo(target) < 0){
                //right half
                leftPointer = mid+1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(question1(grades,target));
        System.out.println(question2(atomicWeights,weightTarget));
        System.out.println(question3(dates,dateTarget));
        System.out.println(question4(patientNames,patientTarget));
        System.out.println(question5(ingredients,ingredientTarget));
    }
}
