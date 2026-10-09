class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder string = new StringBuilder();

        for(char ch : s.toCharArray()){
        
            if(ch == '('){
                if(count > 0){
                    string.append(ch);
                }
                count++;
            }else{
                if(ch == ')'){
                    count--;
                    if(count > 0){
                        string.append(ch);
                    }
                }
            }
        }
        return string.toString();
    }
}