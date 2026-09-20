class Solution {
    int dfs(int[] nums, int i, int target, int n, int[][] dp, int bias) {
        // base case
        if (target + bias < 0 || target + bias >= dp[0].length) {
            return 0;
        }
        if(i >= n) {
            if(target == 0) {
                return 1;
            } else return 0;
        }
        if(dp[i][target+bias] != Integer.MAX_VALUE) return dp[i][target+bias];
        int takePositive = (+1) * nums[i] + dfs(nums, i+1, target - nums[i], n, dp, bias);
        int takeNegative = (-1) * nums[i] + dfs(nums, i+1, target + nums[i], n, dp, bias);
        return dp[i][target+bias] = takePositive + takeNegative;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n+1][2001];
        int bias = 0;
        for(int num : nums) bias += num;
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < 2001; j++) {
                dp[i][j] =  Integer.MAX_VALUE;
            }
        }
        int res = dfs(nums, 0, target, n, dp, bias);
        return res;
    }
}

