class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case '(' :
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                  if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                   } else stack.push(ch) ;
                    break;
                case ']':
                  if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                  } else stack.push(ch);
                    break;
                case '}':
                  if(!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                  } else stack.push(ch);
                  break;        
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
