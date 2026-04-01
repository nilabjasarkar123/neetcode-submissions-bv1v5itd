class Solution {
public:
    int maxArea(vector<int>& heights) {
        int n = heights.size();
        int i = 0, j = n-1;
        int area = 0;
        while(i < j) {
            int size = min(heights[i], heights[j]) * (j-i);
            if(heights[i] < heights[j]) {
                i++;
            } else j--;
            area = max(area, size);
        }
        return area;
    }
};
