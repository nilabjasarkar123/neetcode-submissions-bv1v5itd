class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        set<int>s(nums.begin(), nums.end());
        int n = nums.size(), size = 0, maxsize = 0;
        for(int i = 0; i < n; i++) {
            int prev = nums[i];
            size = 1;
            while(s.find(prev+1) != s.end()){
                prev = prev+1;
                size++; 
            }
            maxsize = max(size, maxsize);
        }
        return maxsize;
    }
};
