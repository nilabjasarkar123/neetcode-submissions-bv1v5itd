class Solution {
    int minCost(int i, int[] cost, int n, int[] dp) {
        if(i >= n) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        dp[i] = cost[i] + Math.min(minCost(i+1, cost, n, dp),
                                minCost(i+2, cost, n, dp));
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = -1;
        int a = minCost(0, cost, n, dp);
        int b = minCost(1, cost, n, dp);
        return Math.min(a, b);
    }
}
