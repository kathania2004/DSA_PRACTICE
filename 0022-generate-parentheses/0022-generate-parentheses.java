class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        StringBuilder tmp = new StringBuilder();

        fun(0, 0, n, tmp, res);

        return res;
    }
    static void fun(int open, int close,int n, StringBuilder tmp,List<String> res){
        if(open == n && close == n){
            res.add(tmp.toString());
            return;
        }

        if(open < n){
            tmp.append('(');

            fun(open + 1, close, n, tmp, res);

            tmp.deleteCharAt(tmp.length() - 1);
                                   
        }
         // close bracket
        if (close < open) {

            tmp.append(')');

            fun(open, close + 1, n, tmp, res);

            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}