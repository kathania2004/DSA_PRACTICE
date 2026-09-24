class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int low = 0;
       int maxLen = 0;

       for(int high = 0;high < nums.length;high++){
        if(nums[high] == 0){
            low =  high + 1;
        }
        maxLen = Math.max(maxLen,high - low + 1);
       }
       return maxLen;
    }
}