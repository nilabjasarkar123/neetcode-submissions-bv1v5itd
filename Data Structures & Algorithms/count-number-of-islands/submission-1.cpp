class Solution {
public:
    void coutIsland(vector<vector<char>>& grid, int i, int j, int n, int m, vector<vector<int>>& vis) {
        if(i < 0 or i >= n or j < 0 or j >= m or grid[i][j] =='0') return ;
        if(vis[i][j] == 1) return ;
        vis[i][j] = 1;
        coutIsland(grid, i-1, j, n, m, vis);
        coutIsland(grid, i+1, j, n, m, vis);
        coutIsland(grid, i, j-1, n, m, vis);
        coutIsland(grid, i, j+1, n, m, vis);
    }
    int numIslands(vector<vector<char>>& grid) {
        // seeing 1 start traversing 
        // no more 1 count++;
        int n = grid.size(), m = grid[0].size(), count = 0;
        vector<vector<int>> vis(n, vector<int>(m, 0));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0) {
                    coutIsland(grid, i, j, n, m, vis);
                    count++;
                }
            }
        }
        return count;
    }
};
