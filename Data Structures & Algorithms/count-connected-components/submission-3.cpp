class Solution {
public:
    bool bfs(int n, vector<vector<int>>& edges, int i, vector<int>& vis) {
        if(vis[i] == 1) return false;
        queue<int> q;
        vis[i] = 1;
        q.push(i);
        while(!q.empty()) {
            int node = q.front();
            q.pop();
            for(auto it : edges[node]){
                if(!vis[it]){
                    q.push(it);
                    vis[it] = 1;
                }
            }
        }
        return true;
    }
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> adj(n);
        for(int i = 0; i < edges.size(); i++) {
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
        }
        vector<int> vis(n, 0);
        int no_of_component = 0;
        for(int i = 0; i < n; i++) {
           if(!vis[i]) {
            bfs(n, adj, i, vis);
            no_of_component++;
           }
        } 
        return no_of_component;
    }
};
