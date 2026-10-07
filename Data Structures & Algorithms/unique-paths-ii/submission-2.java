class Solution {
    int[][] dp ;
    int findPath(int[][] grid, int i, int j) {
        int m = grid.length, 
            n = grid[0].length;
        if(i >= m || i < 0 || j >= n || j < 0 ) return 0;
        if(grid[i][j] == 1) return 0;
        if(i == m-1 && j == n-1) {
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int right = findPath(grid, i, j+1); // right
        int down  = findPath(grid, i+1, j); // down
        
        return dp[i][j] = right + down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, 
            n = obstacleGrid[0].length;
        dp = new int[m+1][n+1];
        //for(int[] row : dp) Arrays.fill(row, -1);
        //return findPath(obstacleGrid, 0, 0);
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    int right = (j > 0) ? dp[i] [j-1] : 0; // right
                    int down  = (i > 0) ? dp[i-1][j]: 0; // down
                    dp[i][j] += right + down;
                }
            }
        }
        return dp[m-1][n-1];
    }
    
}