class Solution {
public:
   void solve(vector<int>& nums, vector<vector<int>>& res, 
   vector<int>&ds, int n, unordered_set<int>& st) {

        if(ds.size() >= n) {
            res.push_back(ds);
            return ;
        }

        for(int i = 0; i < n; i++) {
            if(st.find(nums[i]) == st.end()) {
                ds.push_back(nums[i]);
                st.insert(nums[i]);
                solve(nums, res, ds, n, st);
                ds.pop_back();
                st.erase(nums[i]);
            }
        }

   }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res; 
        int n = nums.size();
        vector<int> ds;
        unordered_set<int> st;

        solve(nums, res, ds, n, st);
        
        
        return res;
    }
};
