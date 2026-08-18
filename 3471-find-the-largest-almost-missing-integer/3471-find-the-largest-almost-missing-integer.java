class Solution {
    public int largestInteger(int[] nums, int k) {
          HashMap<Integer, Integer> map = new HashMap<>();

        // Generate every window of size k
        for (int i = 0; i <= nums.length - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            // Put unique elements of current window into set
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Count how many windows contain each element
            for (int num : set) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        // Find the largest element that appears in exactly one window
        int answer = -1;

        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                answer = Math.max(answer, num);
            }
        }
        return answer;
    }
}