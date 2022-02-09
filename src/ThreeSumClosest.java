import java.util.Arrays;

/**
 * @Author liuxiao
 * @Date 2022/2/9 15:08
 * @Desc
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int [] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i=0; i<len; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(target - closest) > Math.abs(target - sum)) {
                    closest = sum;
                }
                if (sum > target) {
                    R --;
                } else {
                    L ++;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-100,-98,-2,-1};
        System.err.println(threeSumClosest(nums, -101));
    }
}
