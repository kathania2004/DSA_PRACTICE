class Solution {
    public long sumAndMultiply(long n) {
        long ans = revNum(n);
        long num = 0;
        long sum = 0;
        while(ans > 0){
            long rem = ans % 10;
            sum = sum + rem;
            if(rem != 0){
                num = num * 10 + rem;
            }

            ans = ans / 10;
        }
        return num * sum;
    }
        static long revNum(long n){
        long rev = 0;
        while(n > 0){
        long digit = n % 10;
        rev = rev * 10 + digit;
        n = n / 10;
        }
        return rev;
    }
}