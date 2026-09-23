class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum = totalSum + num;
        }
        int target = totalSum - x;
        if(target < 0){
            return -1;
        }
        if(target == 0){
            return n;
        }
        int low = 0;
        int sum = 0;
        int  maxLen = -1;


        for(int high = 0;high < n;high++){
            sum = sum + nums[high];

            while(sum > target){
                sum = sum - nums[low];
                low++;
            }
            if(sum == target){
                 int len = high - low + 1;
                 maxLen = Math.max(maxLen,len);
            }
        }
        if(maxLen == -1){
            return maxLen;
        }
        return n - maxLen;
    }
}