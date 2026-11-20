class Solution {
    int n;
    int[][] dp;
    public int longestStrChain(String[] words) {
        n = words.length;
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        dp = new int[n][n];
        for(int i = 0;i < n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(words,-1,0);
    }
    private boolean isPred(String prev,String curr){
        int m = prev.length();
        int n = curr.length();
        if(m >= n || (n - m) != 1){
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            j++;
        }
        return i == m;
    }
    private int solve(String[] words,int p,int i){
        if(i == n){
            return 0;
        }

        if(p != -1 && dp[p][i] != -1){
            return dp[p][i];
        }
        int take = 0;

        if(p == -1 || isPred(words[p],words[i])){
            take = 1 + solve(words,i,i + 1);
        }
        int skip = solve(words,p,i+1);
        if(p != -1){
            return dp[p][i] = Math.max(take,skip);
        }
        return Math.max(take,skip);
    }
}