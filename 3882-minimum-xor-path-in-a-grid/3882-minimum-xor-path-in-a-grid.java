class Solution {
    public int minCost(int[][] grid) {


        int m = grid.length;
        int n = grid[0].length;

       int[][][] dp = new int[m][n][1024];

       for(int[][] layer : dp){
        for(int[] row : layer){
            Arrays.fill(row,-1);
        }
        
       }
        return solve(grid,0,0,m,n,grid[0][0],dp);
    }

    private int solve(int[][]grid,int i, int j, int m, int n,int xor,int[][][] dp){
        if(i == m - 1 && j == n - 1){
            return xor;
        }

        if(dp[i][j][xor] != -1){
            return dp[i][j][xor];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(i + 1 < m){
            down = solve(grid,i + 1,j,m,n,xor ^ grid[i + 1][j],dp);
        }

        if(j + 1 < n){
            right = solve(grid,i,j + 1,m,n,xor ^ grid[i][j + 1],dp);
        }

        return dp[i][j][xor] = Math.min(down,right);
    }
}