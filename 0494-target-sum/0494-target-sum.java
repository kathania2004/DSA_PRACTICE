class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        dp = new int[21][1001];
        for(int i = 0 ; i <= n;i++){
            Arrays.fill(dp[i],-1);
        }

        target = Math.abs(target);
        int sum = Arrays.stream(nums).sum();

        if((sum + target) % 2 != 0){
            return 0;
        }
        int s1 = (sum + target) / 2;
        return solve(nums,n,s1);
    }
    private int solve(int[] nums,int n,int sum){
        if(n == 0){
            return (sum == 0) ? 1 : 0;
        }
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }

        int skip = solve(nums, n - 1,sum);
        int take = 0;

        if(nums[n - 1] <= sum){
            take = solve(nums,n - 1,sum - nums[n - 1]);
        }
        return dp[n][sum] = skip + take;
    }
}