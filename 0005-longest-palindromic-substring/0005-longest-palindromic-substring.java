class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
       int maxLen = 0;
       int idx = 0;

       boolean[][] dp = new boolean[n][n];
       for(int i = 0;i < n;i++){
        Arrays.fill(dp[i],false);
       } 
       for(int i = 0;i < n;i++){
        dp[i][i] = true;
        maxLen = 1;
       }

       for(int l = 2;l <= n;l++){
        for(int i = 0;i < n - l + 1;i++){
            int j = i + l - 1;
            if(s.charAt(i) == s.charAt(j) && l == 2){
                dp[i][j] = true;
                maxLen = 2;
                idx = i;
            }else if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                dp[i][j] = true;
                maxLen = j - i + 1;
                idx = i;
            }else{
                dp[i][j] = false;
            }
        }
       }
       return s.substring(idx,idx + maxLen);
    }
}