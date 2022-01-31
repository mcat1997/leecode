/**
 * @Author liuxiao
 * @Date 2022/1/31 15:26
 * @Desc 最长回文字符串， https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.err.println(getLongestPalindrome("bb"));
    }

    public static String getLongestPalindrome(String inputStr) {
        int len = inputStr.length();
        // 若输入串长度为1，则直接返回
        if (len < 2) {
            return inputStr;
        }
        // 初始化最长回文串长度，和开始下标
        int maxLength = 1;
        int beginIndex = 0;
        // 状态二维数组, dp[i][j] = true，即为 i->j 为回文字符串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = inputStr.toCharArray();
        // 递推
        // 先固定长度递推
        for (int L = 2; L <= len; L++) {
            // 左边界枚举
            for (int i = 0; i < len; i++) {
                // 右边界
                int j = i + L - 1;
                // 越界则跳出循环
                if (j >= len) {
                    break;
                }
                // i j 不相等，证明 i -> j 不是回文串
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // i j 相等
                    // 两个字符的情况
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 若 dp[i][j]是回文串，且大于之前记录的最大长度，则更新
                if (dp[i][j] && L > maxLength) {
                    maxLength = L;
                    beginIndex = i;
                }

            }
        }
        return inputStr.substring(beginIndex, beginIndex + maxLength);
    }
}
