class Solution {
    public int countCommas(int n) {
        int commas = 0;
        long start = 1000;
        while(start <= n){
            commas += n - start + 1;
            start = start * 1000;
        }
        return commas;
    }
}