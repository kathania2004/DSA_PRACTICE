class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n][2];

        for(int i = 0; i < n ; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(nums,n,0,1);
    }
    private int solve(int[] nums,int n ,int i, int free){
        if(i == n){
            return 0;
        }

        if(dp[i][free] != -1){
            return dp[i][free];
        }

        if(free == 0){
            return dp[i][free] = solve(nums,n,i + 1,1);
        }

        int c1 = nums[i] + solve(nums,n, i + 1,0);
        int c2 = solve(nums,n,i + 1,1);

        return dp[i][free] = Math.max(c1,c2);
    }
}