class Solution {
    public int hammingWeight(int n) {
        StringBuilder s = new StringBuilder();
        int count = 0;

        while(n > 0){
            if(n % 2 == 1){
                s.append(1);
                count = count + 1;
            }else{
                s.append(0);
            }
            //count = count + 1;
            n = n /2;
        }
        return count;
    }
}