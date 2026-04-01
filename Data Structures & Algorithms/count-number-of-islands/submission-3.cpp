class Solution {
public:
    bool dfs(vector<vector<char>>& grid, int n, int m, 
            vector<vector<bool>>& vis, int i, int j) {
                if(i < 0 || i >= n || j >= m || j < 0 || vis[i][j] == true
                ||grid[i][j] == '0') return false;
                
                vis[i][j] = true;
                //if(i+1 < n && grid[i+1][j] == '1')
                    dfs(grid, n, m, vis, i+1, j); 
                //if(j-1 >= 0 && grid[i][j-1] == '1')
                    dfs(grid, n, m, vis, i, j-1);
                //if(j+1 < n && grid[i][j+1] == '1')
                    dfs(grid, n, m, vis, i, j+1);
                //if(i-1 >= 0 && grid[i-1][j] == '1')
                    dfs(grid, n, m, vis, i-1, j);
                return true;
            }
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size(), m = grid[0].size(), island = 0;
        vector<vector<bool>> vis(n, vector<bool>(m, false));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    //cout << i <<": "<<j<<endl;
                    if(dfs(grid, n, m, vis, i, j))
                    island++;
                }
            }
        }
        
        return island;
    }
};
