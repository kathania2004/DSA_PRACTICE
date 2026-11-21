class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid[0].length;
        int count = 0;
        HashMap<List<Integer> , Integer> map = new HashMap<>();

        //step1 : store each row and its frequecy
        for(int row = 0;row < n;row++){
            List<Integer> temp = new ArrayList<>();

            for(int col = 0;col < n;col++){
                temp.add(grid[row][col]);
            }
            map.put(temp,map.getOrDefault(temp,0) + 1);
        }

        //step 2 : construct col and check if it  is present in map or not
        for(int  col = 0;col < n;col++){
            List<Integer> temp = new ArrayList<>();

            for(int row = 0;row < n;row++){
                temp.add(grid[row][col]);
            }
            count += map.getOrDefault(temp,0);
        }
        return count;
    }
}