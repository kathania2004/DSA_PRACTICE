class Solution {
    int n ;
    int[][] dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[5001][5001];
        for(int i = 0;i < n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(coins,0,amount);
    }
    private int solve(int[] coins,int i,int amount){

        if(amount == 0){
            return 1;
        }
        
        if(i >= n){
            return 0;
        }
        
        if(amount < coins[i]){
            return solve(coins,i + 1,amount);
        }
        if(dp[i][amount] != -1){
            return dp[i][amount]; 
        }

        

        int take = solve(coins,i,amount - coins[i]);
        int skip = solve(coins,i + 1,amount);
        return dp[i][amount] = take + skip ;
    }
}