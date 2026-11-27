class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int maxEle = 0;

        for(int num : nums){
            maxEle = Math.max(maxEle,num);
        }
        
        int[] freq = new int[maxEle + n];

        for(int num : nums){
            freq[num]++;
        }
        int moves = 0;

        for(int i = 0 ; i < n + maxEle ;i++){
            if(freq[i] <= 1){
                continue;
            }

            int extra = freq[i] - 1;
            freq[i + 1] += extra;
            freq[i] = 1;
            moves += extra;
 
        }
        return moves;
    }
}