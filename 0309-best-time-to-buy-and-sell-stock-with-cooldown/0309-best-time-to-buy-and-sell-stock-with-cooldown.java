class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int i  = 0 ; i < n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(prices,0,n,true);
    }

    private int solve(int[] prices,int days,int n,boolean buy){
        if(days >= n){
            return 0;
        }
        int state = buy ? 1: 0;
        if(dp[days][state] != -1){
            return dp[days][state];
        }
        int profit = 0;

        if(buy){
            int take = solve(prices, days + 1, n, false) - prices[days];
            int notTake = solve(prices,days + 1,n,true);

            return dp[days][state] = Math.max(take,notTake);

        }else{
            int sell = prices[days] + solve(prices, days + 2,n,true);
            int notSell = solve(prices,days + 1,n,false);
            return dp[days][state] = Math.max(sell,notSell);
        }
    }
}