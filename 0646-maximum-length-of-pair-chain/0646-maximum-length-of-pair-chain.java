class Solution {
    int[][] dp;
    int n;
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        Arrays.sort(pairs,(a,b) -> Integer.compare(a[0],b[0]));
        dp = new int[n][n];

        for(int i = 0;i < n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(pairs,-1,0);
    }
    private int solve(int[][] pairs,int p, int i){
        if(i == n){
            return 0;
        }
        if(p != -1 && dp[p][i] != -1){
            return dp[p][i];
        }
        int take = 0;
        if(p == -1 || pairs[i][0] > pairs[p][1]){
            take = 1 + solve(pairs,i,i+1);
        }

        int skip = solve(pairs,p,i+1);
        if(p != -1){
            dp[p][i] = Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}