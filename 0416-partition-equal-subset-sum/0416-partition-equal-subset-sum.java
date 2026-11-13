class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum % 2 != 0){
            return false;
        }
        int s = totalSum / 2;
        return solve(nums,s);
    }

    private boolean solve(int[] nums,int sum){
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int i = 0;i <= n;i++){
            dp[i][0] = true;
        }

        for(int i = 1;i < n + 1;i++){
            for(int j = 1; j < sum + 1;j++){

                boolean skip = dp[i - 1][j];
                boolean take = false;
                if(nums[i - 1] <= j){
                    take = dp[i - 1][j - nums[i - 1]];
                }
                dp[i][j] = take || skip;
            }
        }
        return dp[n][sum];
    }
}