class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int maxLen = 0;
        int zeroCount = 0;
        for(int high = 0;high < nums.length;high++){
            if(nums[high] == 0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[low] == 0){
                    zeroCount--;
                }
                low++;
            }
            maxLen = Math.max(maxLen,high - low + 1);
        }
        return maxLen;
    }
}