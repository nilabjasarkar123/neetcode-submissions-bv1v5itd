class Solution {
public:
    void dfs(int u, unordered_map<int, vector<int>>& edges, vector<bool>& vis) {
        if(vis[u] == true) return ;
        vis[u] = true;

        for(auto edge : edges[u]) {
            if(!vis[edge]) {
                dfs(edge, edges, vis);
            }
        }
    }
    int countComponents(int n, vector<vector<int>>& edges) {
        unordered_map<int, vector<int>> adj;
        vector<bool> vis(n, false);
        for(int i = 0; i < edges.size(); i++) {
            int u = edges[i][0], 
                v = edges[i][1];
            
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        int count = 0;
        for(int i = 0;  i < n; i++) {
            if(!vis[i]) {
                dfs(i, adj, vis);
                count++;
            }
        }
        return count;
    }
};
