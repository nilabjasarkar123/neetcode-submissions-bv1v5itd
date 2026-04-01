class Solution {
public:
    bool dfs(vector<vector<char>>& board, int n, int m, int i, int j, string word, int k, 
    vector<vector<int>>& vis) {
        if(i < 0 or i >= n or j < 0 or j >= m) return false;
        if(board[i][j] != word[k]) return false;
        if(vis[i][j] == 1) return false;
        if(k == word.size()-1) return true;
        vis[i][j] = 1;
        bool ans = dfs(board, n, m, i+1, j, word, k+1, vis) ||
        dfs(board, n, m, i-1, j, word, k+1, vis) ||
        dfs(board, n, m, i, j+1, word, k+1, vis) ||
        dfs(board, n, m, i, j-1, word, k+1, vis);
        vis[i][j] = 0;
        return ans;
    }
    bool exist(vector<vector<char>>& board, string word) {
        // seeing the first letter we stop and 
        // run dfs in all 4 directions
        // if we found match we increment the index
        // else return false
        
        int n = board.size();
        int m = board[0].size();
        int k = 0, w_size = word.size();
        bool res = false;
        vector<vector<int>> vis(n, vector<int>(m, 0));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word[0] && !vis[i][j]) {
                    res = dfs(board, n, m, i, j, word, 0, vis);
                    if(res == true) return res;
                }
            }
        }
        return res; 
    }
};
