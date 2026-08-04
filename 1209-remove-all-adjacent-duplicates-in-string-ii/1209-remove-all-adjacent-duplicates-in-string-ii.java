class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(stack.isEmpty()) {
                stack.push(new Pair(c, 1));
            }
            else if(stack.peek().ch == c) {

                stack.peek().count++;

                if(stack.peek().count == k) {
                    stack.pop();
                }
            }
            else {
                stack.push(new Pair(c, 1));
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!stack.isEmpty()) {

            Pair current = stack.pop();

            for(int i = 0; i < current.count; i++) {
                ans.append(current.ch);
            }
        }

        return ans.reverse().toString();
    }
    class Pair{
    char ch;
    int count;
    Pair(char ch,int count){
        this.ch = ch;
        this.count = count;
    }
    }
}
