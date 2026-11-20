class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
       dp = new int[n][n];
       for(int i = 0;i < n;i++){
        Arrays.fill(dp[i],-1);
       }
       return solve(nums,0,-1,n);
    }
    private int solve(int[] nums,int i ,int p,int n ){
        if(i >= n){
            return 0;
        }
        if(p != -1 && dp[i][p] != -1){
            return dp[i][p];
        }
        int take = 0;
        int skip = 0;

        if(p == -1 || nums[p] < nums[i]){
            take = 1 + solve(nums,i + 1,i,n);
        }
        skip  = solve(nums,i + 1,p,n);
        if(p != -1){
            dp[i][p] = Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}