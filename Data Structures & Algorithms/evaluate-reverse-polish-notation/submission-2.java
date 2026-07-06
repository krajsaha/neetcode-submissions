class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String c : tokens) {
            if(c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")){
                int n = Integer.valueOf(stack.pop());
                int m = Integer.valueOf(stack.pop());
                
                if(c.equals("+")){
                    stack.push(String.valueOf(m+n));
                }
                if(c.equals("-")){
                    stack.push(String.valueOf(m-n));
                }
                if(c.equals("*")){
                    stack.push(String.valueOf(m*n));
                }
                if(c.equals("/")){
                    stack.push(String.valueOf(m/n));
                }
            }else{
                stack.push(c);
            }
        }

        return Integer.valueOf(stack.peek());
    }
}
