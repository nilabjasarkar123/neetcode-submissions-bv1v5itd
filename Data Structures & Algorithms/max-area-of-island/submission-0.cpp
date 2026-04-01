class Solution {
public:
    int dfs(vector<vector<int>>& grid, int n, int m, 
            vector<vector<bool>>& vis, int i, int j) {
                if(i < 0 || i >= n || j >= m || j < 0 || vis[i][j] == true
                ||grid[i][j] == 0) return 0;
                
                vis[i][j] = true;
                int up    =  dfs(grid, n, m, vis, i+1, j); 
                int down  = dfs(grid, n, m, vis, i, j-1);
                int left  = dfs(grid, n, m, vis, i, j+1);
                int right =  dfs(grid, n, m, vis, i-1, j);
                return 1 + up + down + left + right;
            }
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size(), island = 0;
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    //cout << i <<": "<<j<<endl;
                    island = max(island, dfs(grid, n, m, vis, i, j));
                }
            }
        }
        return island;
    }
};
