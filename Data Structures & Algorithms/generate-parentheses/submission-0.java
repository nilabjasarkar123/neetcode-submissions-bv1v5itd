class Solution {
    void generate(List<String> res, String s, int open, int close, int n) {
        if(s.length() == 2*n) {
            res.add(s);
            return;
        }
        if(open < n)
            generate(res, s+"(", open+1, close, n);
        if(open > close)
            generate(res, s+")", open, close+1, n);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open = 0, close = 0;
        generate(res, "", open, close, n);
        return res;
    }
}
