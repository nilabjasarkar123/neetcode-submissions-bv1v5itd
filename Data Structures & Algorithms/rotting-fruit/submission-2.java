class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int freshOrange = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) freshOrange++;
            }
        }
        if(q.isEmpty() && freshOrange == 0) return 0;
        if(q.isEmpty() && freshOrange > 0) return -1;
        int min = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] front = q.poll();
                int x = front[0];
                int y = front[1];
                for(int[] dir : dirs) {
                    int new_x = x + dir[0];
                    int new_y = y + dir[1];
                    
                    if(new_x >= m || new_y >= n || new_x < 0 || new_y < 0
                    || grid[new_x][new_y] == 2 || grid[new_x][new_y] == 0){
                        continue;
                    }
                    q.offer(new int[]{new_x, new_y});
                    grid[new_x][new_y] = 2;
                    freshOrange--;
                }
            }
            min++;
        }
        if(freshOrange != 0) return -1;
        return min-1;
    }
}
// [[2,1,0],
//  [0,1,1],
//  [0,1,2]] 
//  (0, 0)(2, 2) -> 
// fornt = (0, 0) x= 0, y = 0




