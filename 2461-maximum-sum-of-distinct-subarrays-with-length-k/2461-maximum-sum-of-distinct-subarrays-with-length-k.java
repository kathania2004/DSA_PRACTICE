class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long result = 0;
        // Build the first window
        //he first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Check first window
        if (map.size() == k) {
            result = sum;
        }

        // Slide the window
        for (int high = k; high < nums.length; high++) {

            int low = high - k;

            // Remove outgoing element
            sum -= nums[low];
            map.put(nums[low], map.get(nums[low]) - 1);

            if (map.get(nums[low]) == 0) {
                map.remove(nums[low]);
            }

            // Add incoming element
            sum += nums[high];
            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);

            // If all elements are distinct
            if (map.size() == k) {
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}