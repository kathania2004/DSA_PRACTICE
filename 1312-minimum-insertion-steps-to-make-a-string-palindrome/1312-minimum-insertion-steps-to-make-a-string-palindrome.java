class Solution {
    int[][] dp;
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];

        for(int l = 2 ; l <= n;l++){
            for(int i = 0;i < n - l + 1;i++){
                int j = i + l - 1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],dp[i + 1][j]);
                }  
            }
        }
        return dp[0][n - 1];
    }
    
}