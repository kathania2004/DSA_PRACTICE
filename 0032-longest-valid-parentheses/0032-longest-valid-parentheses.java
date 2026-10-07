class Solution {
    public int longestValidParentheses(String s) {

        //calculating using index push from 1st valid index for valid string which will start with ( 

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        int max = 0;

        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{

                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i - stack.peek());
                }
            }
        }
        return max;
    }
}