class Solution {
    public int smallestNumber(int n, int t) {
        while(n > 0){
            int product = digit(n);
            if(product % t == 0){
                return n;
            }else{
                n++;
            }
        }
        return -1;
    }
    static int digit(int n){
        int product = 1;
        while(n > 0){
            int temp = n % 10;
            product = product * temp;
            n = n / 10;
        }
        return product;
    }
}