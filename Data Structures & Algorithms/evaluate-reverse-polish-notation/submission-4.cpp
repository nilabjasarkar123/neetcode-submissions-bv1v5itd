class Solution {
public:


    int evalRPN(vector<string>& tokens) {
        stack<int> st;
        for(auto token : tokens) {
            if(token != "+" && token != "-" &&token != "*" && token != "/") {
                st.push(stoi(token));
            }
            else  {
                int a = st.top(); st.pop();
                int b = st.top(); st.pop();
                int total = 0;
                if(token == "+") {
                    total = a+b;
                }
                else if(token == "-") {
                    total = b - a;
                }
                else if(token == "*") {
                    total = a*b;
                }
                else if(token == "/" && b != 0) {
                    total = b/a;
                }
                st.push(total);
            }
        }
        return st.top();
    }
};
