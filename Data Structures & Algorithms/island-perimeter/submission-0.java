class Solution {
    
    int dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if(i >=  grid.length || i < 0 || j >=  grid[0].length || j < 0|| grid[i][j] == 0) return 1;
        if(vis[i][j] == true) return 0;
        vis[i][j] = true;

        int right = dfs(grid,i, j+1, vis);
        int left =  dfs(grid,i, j-1, vis);
        int up   =  dfs(grid,i-1, j, vis);
        int down =  dfs(grid,i+1, j, vis);
        return right + left + up + down;
    }
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int area = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                   area = dfs(grid, i, j, vis);
                }
            }
        }
        return area;
    }
}