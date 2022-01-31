import java.util.Arrays;

/**
 * @Author liuxiao
 * @Date 2022/1/7 14:32
 * @Desc
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.err.println(Arrays.toString(arr));
    }

    public static void quickSort(int [] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }

    public static int partition(int [] arr, int left, int right) {
        int stand = arr[right];
        int i = left;
        for (int j = left; j < right; j ++) {
            if (arr[j] < stand) {
                swap(arr, j, i);
                i ++;
            }
        }
        swap(arr, right, i);
        return i;
    }

    public static void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
