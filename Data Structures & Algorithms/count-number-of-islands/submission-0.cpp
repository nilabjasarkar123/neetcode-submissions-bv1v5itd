class Solution {
public:
    bool validIndex(int i,int j,vector<vector<char>>& grid){
        return (i>=0 && i< grid.size() && j>=0 && j<grid[0].size());
    }

    void dfs(vector<vector<char>>& grid, int i,int j,vector<vector<int>>& visited)
    {

        if(validIndex(i,j,grid) == false)
            return ;
        
        visited[i][j] = 1;

        vector<vector<int>> neighbours = {{i+1,j},{i-1,j},{i,j-1},{i,j+1}};
        for(auto nbr: neighbours){
            int fi = nbr[0],se = nbr[1];

            if(validIndex(fi,se,grid) && grid[i][j] == grid[fi][se]&& !visited[fi][se])
                dfs(grid,fi,se,visited);
        }
    }
    
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        int cnt = 0;

        vector<vector<int>> visited(n,vector<int>(m,0));

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }
};
