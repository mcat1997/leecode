/**
 * @Author liuxiao
 * @Date 2022/2/7 15:26
 * @Desc
 */
public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int left = -1;
        int right = -1;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (index1 < len1 && (index2 >= len2 || nums1[index1] < nums2[index2])) {
                right = nums1[index1 ++];
            } else {
                right = nums2[index2 ++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        }
        return right;
    }
}
