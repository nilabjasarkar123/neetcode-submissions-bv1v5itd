class Solution {
    void solve(int[] nums, int i, int target, List<Integer> ds, List<List<Integer>> res) {
       if(target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }
        if(target < 0 || i >= nums.length) {
            return;
        }
        
        for(int ind = i; ind < nums.length; ind++) {
            if(ind > i && nums[ind] == nums[ind-1]) continue;
            ds.add(nums[ind]);
            solve(nums, ind+1, target-nums[ind], ds, res);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, ds, res);
        return new ArrayList<>(res);
    }
}
