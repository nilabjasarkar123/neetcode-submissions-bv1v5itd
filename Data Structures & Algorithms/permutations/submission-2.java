class Solution {
    void solve(int[] nums, int ind, List<Integer> ds, List<List<Integer>> res, boolean[] vis) {
        if(ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return ;
        }
        if(ind >= nums.length) return;
        
        for(int i = 0; i < nums.length; i++) {
            if(vis[i] == true) continue;
            
            vis[i] = true;
            ds.add(nums[i]);
            solve(nums, i, ds, res, vis);
            ds.remove(ds.size()-1);
            vis[i] = false;
        }
        
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds        = new ArrayList<>();
        boolean vis[] = new boolean[nums.length];
        solve(nums, 0, ds, res, vis);
        return res;
    }
}
