class Solution {
    public int maxArea(int[] heights) {
        int area = Integer.MIN_VALUE;
        int n = heights.length;
        int i = 0, j = n-1;
        while(i < j){
            area = Math.max(area, (j-i) * Math.min(heights[i], heights[j]));
            if(heights[i] < heights[j]) {
                i++;
            } 
            else j--;
        }
        return area;
    }
}
