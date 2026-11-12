class Solution {
    int n;
    int[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        n = startTime.length;
        int[][] arr = new int[n][3];

        for(int i = 0;i < n; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));

        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(arr,0,dp);
        
    }
    private int solve(int[][] arr,int i,int[] dp){

        //base case
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int next = getNextIndex(arr,i + 1,arr[i][1]);

        //take job
        int take = arr[i][2] + solve(arr,next,dp);

        //not take current job
        int notTake = solve(arr,i + 1,dp);

        return dp[i] = Math.max(take,notTake);
    }
    
    private int getNextIndex(int[][] arr,int i, int currentJobEnd){
        int low = i;
        int high = n - 1;
        int ans = n;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid][0] >= currentJobEnd){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return ans;
    }
}