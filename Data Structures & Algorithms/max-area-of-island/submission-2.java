class Solution {
    int dfs(int[][] grid, int i, int j, boolean[][] vis) {
        int n = grid.length, m = grid[0].length;
        if(i >= n || i < 0 || j >= m || j < 0 || vis[i][j] 
          || grid[i][j] == 0) return 0;
        
        vis[i][j] = true;

        return 1 + dfs(grid, i+1, j, vis) + 
            dfs(grid, i-1, j, vis) +
            dfs(grid, i, j+1, vis) +
            dfs(grid, i, j-1, vis);
        
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int area = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    int size = dfs(grid, i, j, vis);
                    if(size > area) {
                        area = size;
                    }
                }
            }
        }
        return (area == Integer.MIN_VALUE) ? 0 : area;
    }
}
