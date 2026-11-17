class Solution {
     int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int i = 0;i < m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(obstacleGrid,0,0,m,n);
   }
   private int solve(int[][] obstacleGrid,int i ,int j,int m,int n){
    if(i >= m || i < 0 || j >= n || j < 0 || obstacleGrid[i][j] == 1){
        return 0;
    }
    if(dp[i][j] != -1){
        return dp[i][j];
    }

    if(i == m - 1 && j == n - 1){
        return 1;
    }
    return dp[i][j] = solve(obstacleGrid,i + 1,j,m,n) + solve(obstacleGrid,i,j + 1,m,n);
   }
}