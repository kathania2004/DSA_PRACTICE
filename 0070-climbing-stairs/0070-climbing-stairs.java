class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        return fun(0,n,memo);
    }
    int fun(int i, int n , HashMap<Integer,Integer> memo){
        if(i == n){
            return 1;
        }

        if(i > n){
            return 0;
        }

        if(memo.containsKey(i)){
            return memo.get(i);
        }

        int a1 = fun(i + 1,n,memo);
        int a2 = fun(i + 2,n,memo);

        int ans = a1 + a2;

        memo.put(i,ans);
        return ans;
    }
}