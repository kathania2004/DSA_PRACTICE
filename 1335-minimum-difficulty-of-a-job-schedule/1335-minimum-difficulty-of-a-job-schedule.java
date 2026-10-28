class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d) {
            return -1;
        }

        int[][] dp = new int[n][d + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(jobDifficulty, n, 0, d, dp);
    }

    private int solve(int[] jobDifficulty, int n,
                      int index, int d, int[][] dp) {

        // Last day: all remaining jobs must be done
        if (d == 1) {
            int maxDiff = 0;

            for (int i = index; i < n; i++) {
                maxDiff = Math.max(maxDiff, jobDifficulty[i]);
            }

            return maxDiff;
        }

        if (dp[index][d] != -1) {
            return dp[index][d];
        }

        int maxDiff = 0;
        int finalResult = Integer.MAX_VALUE;

        // Leave at least one job for each remaining day
        for (int i = index; i <= n - d; i++) {
            maxDiff = Math.max(maxDiff, jobDifficulty[i]);

            int result = maxDiff
                       + solve(jobDifficulty, n, i + 1, d - 1, dp);

            finalResult = Math.min(finalResult, result);
        }

        return dp[index][d] = finalResult;
    }
}