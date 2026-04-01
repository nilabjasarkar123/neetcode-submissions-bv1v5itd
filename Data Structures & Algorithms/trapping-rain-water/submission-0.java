class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        int lm = Integer.MIN_VALUE;
        int rm = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            lm = Math.max(height[i], lm);
            leftMax[i] = lm;
        }
        for(int i = n-1; i >= 0; i--) {
            rm = Math.max(height[i], rm);
            rightMax[i] = rm;
        }
        for(int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return totalWater;
    }
}


/*
0 1 2 3 4 5 6 7 8
0 2 0 3 1 0 3 2 1
      i 
water += min(left[3], right[3]) - h[3]; 2+ 
           
leftmax  [0, 2, 2, 3, 3, 3, 3, 3, 3]
rightmax 
         [3, 3, 3, 3, 3, 3, 3, 1, 2]
i 
left = 3, right = 3 
water +=  min(left, right) - height[i];
0 1 2 

0 1 2 3 4 5 6 7 8
0 2 4 3 2 0 3 5 1

*/