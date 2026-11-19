class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;
        for(int i = 0;i < cuts.length;i++){
            arr[i + 1] = cuts[i];
        }
        dp = new int[arr.length + 1][arr.length + 1];
        for(int i = 0;i < arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,0,arr.length - 1);
    }
    private int solve(int[] arr,int l,int r){
        if(r - l < 2){
            return 0;
        }
        if(dp[l][r] != -1){
            return dp[l][r];
        }
        int result = Integer.MAX_VALUE;
        for(int index = l + 1;index < r;index++){
            int cost = (arr[r] - arr[l]) + solve(arr,l,index) + solve(arr,index,r);
            result = Math.min(result,cost); 
        }
        return dp[l][r] = result;
    }
}