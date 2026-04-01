class Solution {
public:
    void dfs(int i, vector<vector<int>>& edges, vector<bool>& vis) {
        if(vis[i] == true) return ;
        vis[i] = true;
        for(auto x : edges[i]){
            if(!vis[x])
            dfs(x, edges, vis);
        }
    }
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<bool> vis(n, 0);
        vector<vector<int>> adj(n);
        for(auto edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].push_back(v);
            adj[v].push_back(u);  
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs(i, adj, vis);
                count++;
            }
        }
        return count;
    }
};
