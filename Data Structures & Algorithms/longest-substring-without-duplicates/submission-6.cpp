class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.length()==0 or s.length()==1) return s.length();
        set<char> st;
        int i = 0, j = 0;
        int len = 0;
        while(j < s.size()) {
            if(st.find(s[j]) == st.end()) {
                st.insert(s[j]);
                len = max(len, j-i+1);
                j++;
            }
            else {
                st.erase(s[i]);
                i++;
            }
        }
        return len;
    }
};
