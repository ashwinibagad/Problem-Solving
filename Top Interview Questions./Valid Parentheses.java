import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack<>();
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            switch(c[i]){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')': case ']': case '}': 
                    if(stack.isEmpty() || stack.pop() != c[i]){
                        return false;
                    }
            }
        }
        
        return stack.isEmpty();
    }
}
