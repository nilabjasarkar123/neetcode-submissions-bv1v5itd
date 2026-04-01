class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        pre[0] = nums[0];
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i-1] * nums[i];
        }
        post[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            post[i] = nums[i] * post[i+1];
        }

        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                res[i] = post[i+1];
                continue;
            }
            if(i == n-1) {
                res[i] = pre[i-1];
                continue;
            }
            
            
            res[i] = pre[i-1] * post[i+1];
            
        }
        return res;
    }
}  
/*
1   2  8  48
48 48 24  
------------
48 12     8
*/
