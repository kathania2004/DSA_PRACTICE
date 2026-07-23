class Solution {
    public int uniqueXorTriplets(int[] nums) {
         int n = nums.length;

        if (n < 3) {
            return n;
        }

        int highestPowerOfTwo = Integer.highestOneBit(n);

        return highestPowerOfTwo * 2;
    }
}