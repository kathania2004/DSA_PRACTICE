class Solution {
    public long countCommas(long n) {
         
        long commas = 0;
        long start = 1000;

        while(start <= n){
            commas = commas + n - start + 1;
            start = start * 1000;
        }
        return commas;
        
    }
}