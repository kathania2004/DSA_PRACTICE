class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = (a & b) << 1; // HERE AND TELLS WHERE IS CARRY
            a = a ^ b; //here XOR performs addition without carry
            b = carry; // it will perform addition with carry
        }
        return a;
    }
}