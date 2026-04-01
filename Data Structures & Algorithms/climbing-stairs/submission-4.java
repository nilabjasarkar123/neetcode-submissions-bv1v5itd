class Solution {
    int solve(int n, int[] dp) {
        if(n == 0 || n == 1 || n == 2) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        // for(int i = 0; i <= n; i++) dp[i] = -1;
        int a = 1; int b = 1; int c = 0;
        if(n == 0 || n == 1 || n == 2) return n;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
