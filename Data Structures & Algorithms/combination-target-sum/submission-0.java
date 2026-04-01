class Solution {
    void solve(int[] nums, int i , int target, List<Integer> ds, List<List<Integer>>res) {
        if(i == nums.length || target < 0) {
            if(target == 0) {
                res.add(new ArrayList<>(ds));
                return ;
            }
            return ;
        }
        ds.add(nums[i]);
        solve(nums, i, target - nums[i], ds, res);
        ds.remove(ds.size()-1);
        solve(nums, i+1, target, ds, res);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(nums, 0, target, ds, res);
        return res;
    }
}
