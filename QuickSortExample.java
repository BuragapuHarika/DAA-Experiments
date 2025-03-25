import java.util.Arrays;

public class QuickSortExample {
    // QuickSort function
    public static void quickSort(char[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function
    private static int partition(char[] arr, int low, int high) {
        char pivot = arr[high]; // Choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and pivot
        char temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        char[] letters = { 'E', 'X', 'A', 'M', 'P', 'L', 'E' };
        
        System.out.println("Original List: " + Arrays.toString(letters));
        
        quickSort(letters, 0, letters.length - 1);
        
        System.out.println("Sorted List: " + Arrays.toString(letters));
    }
}
