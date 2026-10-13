class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int s, f;
        Stack<Integer> st = new Stack<>();
        for(String ch : tokens) {
            
            if(ch.equals("+") || ch.equals("*") || ch.equals("/") || ch.equals("-")) {
                s = st.pop();
                f = st.pop();
                int res = 0;
                if(ch.equals("+")) {
                    res = f + s;
                } else if(ch.equals("-")) {
                    res = f - s;
                }  else if(ch.equals("/")) {
                    res = f / s;
                } else if(ch.equals("*")) {
                    res = f * s;
                }
                st.push(res);
            } else {
                st.push(Integer.parseInt(ch));
            }
            
        }
        return st.pop();
    }
}
