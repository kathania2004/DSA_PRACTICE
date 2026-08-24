class Solution {
    public int addDigits(int num) {
        if(num >= 0 && num <= 9)
        return num;

        int sum = add(num);
        return addDigits(sum);    
    }

    static int add(int num){
        int sum = 0;
        while(num > 0){
        int temp = num % 10;
        sum  = sum  + temp;
        num = num / 10;
        }
    return sum;   
    }
}