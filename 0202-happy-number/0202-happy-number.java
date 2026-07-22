class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(fast != 1){
            slow = squares(slow);
            fast = squares(fast);
            fast = squares(fast);
            if(slow == fast && slow != 1){
                slow = n;
                while(slow != fast){
                    slow = squares(slow);
                    fast = squares(fast);
                }
                return false;
            }
        }
        return true;  
    }
    static int squares(int n){
        int sum = 0;
        while(n > 0){
            int d = n % 10;
            n = n / 10;
            sum = sum + d * d;
        }
        return sum;
    }
}