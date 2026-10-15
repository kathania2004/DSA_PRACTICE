class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum = totalSum + num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum == 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= target; j++) {

                // Not take
                dp[i][j] = dp[i + 1][j];

                // Take
                if (nums[i] <= j) {
                    dp[i][j] = dp[i][j] ||
                               dp[i + 1][j - nums[i]];
                }
            }
        }

        return dp[0][target];
        
    }
}