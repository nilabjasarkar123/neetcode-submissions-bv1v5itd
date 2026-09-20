class Solution {
    
    int dfs(int[] nums, int i, int n, int[] dp) {
        if(i > n) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + dfs(nums, i+2, n, dp);
        int notTake = 0 + dfs(nums, i+1, n, dp);
        return dp[i] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];;
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        // 0 - n-2 index
        int firstRob = dfs(nums, 0, n-2, dp1);
        // 1 - n-1 index
        int secondRob = dfs(nums, 1, n-1, dp2);

        return Math.max(firstRob, secondRob);
    }
}
/*
[2,9,8,3,6]
/ \
2
*/