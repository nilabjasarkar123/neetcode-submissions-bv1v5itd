class Pair{
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();
        int j = n-1;
        for(int i = n-1; i >= 0; i--) {
            if(!st.isEmpty() && st.peek().first > temperatures[i]) {
                res[j] = st.peek().second - i;
                st.push(new Pair(temperatures[i], i));

            } else if(!st.isEmpty() && st.peek().first <= temperatures[i]) {
                while(!st.isEmpty() && st.peek().first <= temperatures[i]) {
                    st.pop();
                }
                 if(!st.isEmpty() && st.peek().first > temperatures[i]) {
                    res[j] = st.peek().second - i;
                    st.push(new Pair(temperatures[i], i));

                 }
                 else {
                    res[j] = 0;
                    st.push(new Pair(temperatures[i], i));
                 }
            } else if(st.isEmpty()) {
                res[j] = 0;
                st.push(new Pair(temperatures[i], i));
            }
            j--;
        }
        return res;
    }
}
