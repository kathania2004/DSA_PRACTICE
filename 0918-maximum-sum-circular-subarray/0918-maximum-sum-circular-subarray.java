class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int best = nums[0];
        int maximum = nums[0];
        int maxsum = nums[0];

        int minimum = nums[0];
        int minsum = nums[0];

        int total = 0;
        for(int i = 0;i < nums.length;i++){
            total = total + nums[i];

            if(i > 0){
            maximum = Math.max(nums[i],maximum + nums[i]);
            maxsum = Math.max(maxsum,maximum);

            minimum = Math.min(nums[i],minimum + nums[i]);
            minsum = Math.min(minsum,minimum);
            }
        }
        if(maxsum < 0){
            return maxsum;
        }
        int circularsum = total - minsum;
        return Math.max(circularsum,maxsum);
    }
}