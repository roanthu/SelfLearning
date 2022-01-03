package sort;

import java.util.logging.Logger;

public class QuickSort {
    private static Logger logger = Logger.getLogger("QuickSort");
    private static int[] runQuickSort(int[] inputArray){
        inputArray[0] = 99999666;
        return inputArray;
    }

    private static void swap(int[] inputArray, int i, int j) throws Exception {
        if(i >= inputArray.length || j > inputArray.length){
            throw new Exception("WTF man");
        }
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }

    private static int quicksort(int[] inputArray, int low, int high) throws Exception {
        if (low < high) {
            int pivot = inputArray[high];
            int left = low;
            int right = high-1;

            while(true) {
                while (left <= right && inputArray[left] < pivot) {
                    left++;
                }

                while (right >= left && inputArray[right] > pivot) {
                    right--;
                }
                if (left >= right) {
                    break;
                }
                swap(inputArray, left, right);
                logger.info("swap " + left + " and " + right);
                DataGenerator.logArrayInt(inputArray);
                left++; right--;
            }

            swap(inputArray, left, high);
            quicksort(inputArray, low, left-1);
            quicksort(inputArray, left+1, high);
        }
        return 0;
    }

    private static boolean check(int[] inputArray){
        for(int i = 0; i < inputArray.length-1; i++){
            if(inputArray[i] > inputArray[i+1]){
                logger.info("sorted fail in index " + i + " " + inputArray[i]);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int[] randomArray = DataGenerator.genRandomIntArray(100);
        DataGenerator.logArrayInt(randomArray);


        quicksort(randomArray, 0, randomArray.length-1);
        DataGenerator.logArrayInt(randomArray);
        if(check(randomArray)){
            logger.info("Sorted successfully");
        }else {
            logger.info("Sorted failed");
        }
    }
}
