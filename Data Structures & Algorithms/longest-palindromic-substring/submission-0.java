class Solution {
    
    boolean isPalindrom(String s, int i, int j, Boolean[][] dp) {
        if(i >= j) return true;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return  dp[i][j] = isPalindrom(s, i+1, j-1, dp);
        return dp[i][j] = false;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int startPoint = 0, endPoint = 0;
        int len = 0;
        Boolean[][] dp = new Boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrom(s, i, j, dp)){
                    int size = j - i + 1;
                    if(size >= len) {
                        len = size;
                        startPoint = i;
                        endPoint = j;
                    }

                }
            }
        }
        
        return s.substring(startPoint, endPoint+1);
    }
}
  