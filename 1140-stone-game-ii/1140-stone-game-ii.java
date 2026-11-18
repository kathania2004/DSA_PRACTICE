class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[2][n][n + 1];
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(piles,1,0,1,n);
    }
    private int solve(int[] piles,int person,int i,int m,int n){
        if(i >= n){
            return 0;
        }
        if(dp[person][i][m] != -1){
            return dp[person][i][m];
        }
        int stones = 0;
        int result = (person == 1) ? 0 : Integer.MAX_VALUE;
        for(int x = 1;x <= Math.min(2 * m,n - i);x++){
            stones += piles[i + x - 1];
            if(person == 1){
                result = Math.max(result,stones + solve(piles,0,i + x,Math.max(m,x),n));
            }else{
                result = Math.min(result,solve(piles,1,i + x,Math.max(m,x),n));
            }
        }
        return dp[person][i][m] = result;
    }
}