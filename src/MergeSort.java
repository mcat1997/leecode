import java.util.Arrays;

/**
 * @Author liuxiao
 * @Date 2022/1/7 13:47
 * @Desc
 */
public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.err.println(Arrays.toString(arr));
    }

    public static void sort(int [] arr) {
        int [] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int [] arr, int left, int right, int [] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) /2;
        sort(arr, left, mid, temp);
        sort(arr, mid+1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    public static void merge(int [] arr, int left, int mid, int right, int [] temp) {
        int i = left;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        k = 0;
        i = left;
        while (i <= right) {
            arr[i++] = temp[k++];
        }
    }
}
