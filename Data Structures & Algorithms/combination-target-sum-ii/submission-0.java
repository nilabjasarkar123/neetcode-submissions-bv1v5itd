class Solution {
    void solve(int[] nums, int i, int target, List<Integer> ds, Set<List<Integer>> res) {
        if(target < 0 || i >= nums.length) {
            if(target == 0) {
                res.add(new ArrayList<>(ds));
                return;
            }
            return;
        }
        ds.add(nums[i]);
        solve(nums, i+1, target-nums[i], ds, res);
        ds.remove(ds.size()-1);
        solve(nums, i+1, target, ds, res);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, ds, res);
        return new ArrayList<>(res);
    }
}
