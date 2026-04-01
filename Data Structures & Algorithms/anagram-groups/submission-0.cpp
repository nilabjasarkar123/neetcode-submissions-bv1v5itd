class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        unordered_map<string,vector<string>> bucket;

        for(auto x : strs) {
            string s = x;
            sort(begin(s), end(s));
            bucket[s].push_back(x);
        }
        
        for(auto x : bucket) {
            ans.push_back(x.second);
        }
        return ans;
    }
};
