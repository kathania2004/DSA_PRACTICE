class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> stack = new Stack<>();
        //StringBuilder ans = new StringBuilder();
        //int n = s.length();
        for(String token : tokens){
            switch(token){
                case "+" : 
                stack.push(stack.pop() + stack.pop());
                break;

                case "-" :
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                    break;

                case "*" :
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(b * a);
                    break;

                case "/" :
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;

                default:
                    stack.push(Integer.parseInt(token));
            }            
        }
        return stack.pop();
    }
}