import java.util.*;

/**
 * @Author liuxiao
 * @Date 2021/4/29 6:59 下午
 * @Desc
 */
public class FrogCrossRiver {

    public static void main(String[] args) {
        class Recursion {
            private boolean checkOne(int[] stones, int index, int k) {
                for (int i = index + 1; i < stones.length; i++) {
                    int gap = stones[i] - stones[index];
                    if (gap >= k - 1 && gap <= k + 1) {
                        if (checkOne(stones, i, gap)) {
                            return true;
                        }
                    }
                    if (gap > k + 1) {
                        break;
                    }
                }
                return index == stones.length - 1;
            }

            public boolean solution(int[] stones) {
                return checkOne(stones, 0, 0);
            }
        }

        class MemRecursion {
            private boolean checkOne(int [] stones, int index, int k, Set<Integer> mem) {
                int key = index * 1000 + k;
                if (mem.contains(key)) {
                    return false;
                }
                mem.add(key);
                for (int i = index + 1; i < stones.length; i++) {
                    int gap = stones[i] - stones[index];
                    if (gap >= k - 1 && gap <= k + 1) {
                        if (checkOne(stones, i, gap, mem)) {
                            return true;
                        }
                    }
                    if (gap > k + 1) {
                        break;
                    }
                }
                return index == stones.length - 1;
            }

            public boolean solution(int [] stones) {
                Set<Integer> mem = new HashSet<>();
                return checkOne(stones, 0, 0, mem);
            }
        }

        class Dynamic {
            public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        for (int i = 1; i < n; ++i) {
            for (int j = i -1; j >=0; --j) {
                int k = stones[i] - stones[j];
                if (k > j +1) {
                    break;
                }
                dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
            }
        }

        int [] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        int [] noStones = {0, 1, 2, 3, 4, 8, 9, 11};

        Recursion recursion = new Recursion();
        System.err.println(recursion.solution(stones));
        System.err.println(recursion.solution(noStones));

        MemRecursion memRecursion = new MemRecursion();
        System.err.println(memRecursion.solution(stones));
        System.err.println(memRecursion.solution(noStones));

        Dynamic dynamic = new Dynamic();
        System.err.println(dynamic.canCross(stones));
        System.err.println(dynamic.canCross(noStones));


    }
}
