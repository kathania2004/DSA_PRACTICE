class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // Check whether (x, y) is inside the grid
    boolean valid(int x, int y, int n, int m) {

        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }

        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair<Integer,Integer>> q =  new LinkedList<>();

        int fresh = 0;
        int time = 0;

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){

                if(grid[i][j] == 2){
                    q.offer(new Pair<>(i,j));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        //BFS
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int k = 0;k < size;k++){
                Pair<Integer,Integer> p = q.poll();

                int x = p.getKey();
                int y = p.getValue();

                //check all four directions
                for(int i = 0;i < 4;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(valid(nx,ny,n,m) && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        fresh--;

                        q.offer(new Pair<>(nx,ny));

                    }
                }
            }
            time++;
        }
        if(fresh > 0){
            return -1;
        }
        return time;
    }
}