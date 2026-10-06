class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int fib(int n) {

        // base answer 
        if(n <= 1){
            return n;
        }

        //Already calculated
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        //calculate
        int ans = fib(n - 1) + fib(n - 2);

        //store answer
        memo.put(n,ans);
        return ans;
        
    }
}