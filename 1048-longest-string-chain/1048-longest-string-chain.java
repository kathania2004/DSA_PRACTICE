class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        int[] dp = new int[n];
        for(int i = 0;i < n;i++){
            Arrays.fill(dp,1);
        }
        int maxLis = 1;
        for(int i = 0;i < n;i++){
            for(int j = 0;j< i;j++){
                if(isPred(words[j],words[i])){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    maxLis = Math.max(maxLis,dp[i]);
                }
            }
        }
        return maxLis;
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
    
}