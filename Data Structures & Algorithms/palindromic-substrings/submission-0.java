class Solution {
    Boolean[][] t;
    boolean isPal(String s, int i, int j) {
        if(i > j) return true;
        if(t[i][j] != null) return t[i][j];
        if(s.charAt(i) != s.charAt(j)) return false;
        return t[i][j] = isPal(s, i+1, j-1);
        
    }
    public int countSubstrings(String s) {
        int n = s.length(), res = 0;
        t = new Boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPal(s, i, j)) res++;
            }
        }
        return res;
    }
}
