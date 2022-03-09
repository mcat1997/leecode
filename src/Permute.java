import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuxiao
 * @Date 2022/3/9 21:33
 * @Desc 全排列 https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    /**
     * @param nums 原数组
     * @param len  原数组长度
     * @param depth 当前遍历深度
     * @param path 当前遍历路径
     * @param res 结果集
     */
    public static void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 非叶子节点
        for (int i = 0; i < len; i ++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, path, used, res);
            // 回溯，当前使用false
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.err.println(permute(nums));
    }
}
