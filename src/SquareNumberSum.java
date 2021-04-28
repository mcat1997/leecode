public class SquareNumberSum {

    public static void main(String[] args) {
        class Solution {
            public boolean judgeSquareSum(int c) {
                for (long a = 0; a * a <= c; a++) {
                    double b = Math.sqrt(c - a * a);
                    if (b == (int) b) {
                        return true;
                    }
                }
                return false;
            }
        }

        Solution solution = new Solution();

        System.err.println(solution.judgeSquareSum(100));
        System.err.println(solution.judgeSquareSum(5));
    }
}
