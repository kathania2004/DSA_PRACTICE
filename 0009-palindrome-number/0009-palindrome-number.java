class Solution {
    public boolean isPalindrome(int x) {
        int ans = pallindrome(x);
        if(ans == x){
            return true;
        }else{
            return false;
        }
    }
    static int pallindrome(int x){
        int rev = 0;
        while(x > 0){
            int num  = x % 10;
            rev = rev * 10 + num;
            x = x / 10;
        }
        return rev;
    }
}