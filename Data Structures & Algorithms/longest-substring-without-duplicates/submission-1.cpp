class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int i = 0, j = 0, len = 0, maxlen = 0;
        int n = s.length();
        if(n == 0 || n == 1) return n; 
        unordered_set<char> dup;
        while(j < n){
            if(dup.find(s[j]) == dup.end()) {
                dup.insert(s[j]);
                j++;
            }
            else {
                dup.erase(s[i]);
                i++;
            }
            maxlen = max(maxlen, j-i+1);
        }
        return maxlen-1;
    }
};
