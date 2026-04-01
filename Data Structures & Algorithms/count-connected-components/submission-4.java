class Solution {
    boolean bfs(ArrayList<ArrayList<Integer>> adj, int ind, boolean[] vis) {
        if(vis[ind] == true) return false;
        vis[ind] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(ind);
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int it : adj.get(node)) {
                if(!vis[it]) {
                    q.offer(it);
                    vis[it] = true;
                }
            }
        }
        return true;
    }
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean [] vis = new boolean[n];
        int com = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                bfs(adj, i, vis);
                com++;
            }
        }
        return com;
    }
}
