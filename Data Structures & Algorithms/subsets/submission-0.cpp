class Solution {
public:
    void solve(vector<int>& nums, int i, vector<int>& ds, vector<vector<int>>& res) {
        if(i >= nums.size()) {
            res.push_back(ds);
            return ;
        }
        ds.push_back(nums[i]);
        solve(nums, i+1, ds, res);
        ds.pop_back();
        solve(nums, i+1, ds,res);
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> ds;
        solve(nums, 0, ds, res);
        
        return res;
    }
};
