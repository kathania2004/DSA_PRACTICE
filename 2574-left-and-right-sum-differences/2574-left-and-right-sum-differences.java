class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int left = 0;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int[] result = new int[n];
        for(int i = 0 ;i < n;i++){
            int right = totalSum - left - nums[i];
            int diff = Math.abs(right - left);
            result[i] = diff;

            left += nums[i];
        }
        return result;
    }
}