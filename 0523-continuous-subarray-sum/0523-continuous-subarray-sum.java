class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {

                int previousIndex = map.get(rem);

                if (i - previousIndex >= 2) {
                    return true;
                }

            } else {

                // Store only the first index
                map.put(rem, i);
            }
        }

        return false;
    }
}