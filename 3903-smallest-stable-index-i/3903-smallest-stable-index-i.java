class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i = 0;i < nums.length;i++){
            int minimum = nums[i];
            int maximum = nums[i];
            for(int j = i + 1;j < nums.length;j++){
                minimum = Math.min(minimum,nums[j]);
            }
            for(int j = 0;j < i + 1;j++){
                maximum = Math.max(maximum,nums[j]);
            }
            if(maximum - minimum <= k){
            return i;
            }
        }
        return - 1;
    }
}