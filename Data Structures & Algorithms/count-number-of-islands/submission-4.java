class Solution {
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean dfs(char[][] grid, int i, int j, boolean[][] vis) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0
           || vis[i][j] || grid[i][j] == '0') return false;
        vis[i][j] = true;

        for(int d = 0; d < 4; d++) {
            int x = dir[d][0], y = dir[d][1];
            dfs(grid, i+x, j+y, vis);
        }
        return true;
    }
    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length, count = 0;
        boolean[][] vis = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    if(dfs(grid, i, j, vis))
                    count++;
                }
            }
        }
        return count;
    }
}
