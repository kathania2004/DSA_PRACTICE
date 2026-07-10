class Solution {
    public double findMaxAverage(int[] nums, int k) {
         int low = 0;
        int high = k - 1;
        int sum = 0;
        double avg = 0;
        double res = Double.NEGATIVE_INFINITY;
        for(int i = low;i < k;i++){
            sum = sum + nums[i];
        }
        avg = (double) sum/k;
        while(high < nums.length - 1){
            res = Math.max(res,avg);
            low++;
            high++;
            if(high == nums.length){
                break;
            }
            sum = sum - nums[low - 1];
            sum = sum + nums[high];
            avg = (double) sum/k;

        }
        res = Math.max(res,avg);
        return res;
    }
}