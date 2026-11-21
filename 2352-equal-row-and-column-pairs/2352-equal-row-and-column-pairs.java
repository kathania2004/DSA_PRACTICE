class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid[0].length;
        int count = 0;
        
        for(int row = 0;row < n;row++){
            for(int col = 0;col < n;col++){
                int isEqual = 1;
                for(int i = 0;i < n;i++){
                    if(grid[row][i] != grid[i][col]){
                        isEqual = 0;
                        break;
                    }   
                }
                count += isEqual;
            }
        }
        return count;
    }
}