class Solution {
    boolean dfs(List<List<Integer>> adj, int u, boolean vis[], int par) {
        vis[u] = true;
        for(int v : adj.get(u)) {
            if(v == par) continue;
            if(vis[v] == true && par != u) return true;
            if(dfs(adj, v, vis, u) == true) return true;
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        int r = edges.length;
        if(r < n-1) return false;
        boolean vis[] = new boolean[n];
        int parent = -1;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i = 0; i < n; i++) {
           if(!vis[i] && dfs(adj, i, vis, parent)) {
            return false;
           }
        }
        for(boolean i : vis) {
            if(i == false) return false;
        }
        return true;
    }
}
/*
3
|
0-1-4
|
2

0-1-2-3

*/