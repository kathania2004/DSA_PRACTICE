class Solution {
    public int uniqueXorTriplets(int[] nums) {
         int max = 0;

        // Find maximum element
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // XOR of two numbers <= max can be less than 2 * max
        int size = max << 1;

        boolean[] pairXor = new boolean[size];

        // Store all possible XOR values of two elements
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                int xor = nums[i] ^ nums[j];

                pairXor[xor] = true;
            }
        }

        boolean[] tripletXor = new boolean[size];

        // Combine every pair XOR with every third number
        for (int xor = 0; xor < size; xor++) {

            if (pairXor[xor]) {

                for (int i = 0; i < nums.length; i++) {

                    int result = xor ^ nums[i];

                    tripletXor[result] = true;
                }
            }
        }

        // Count unique XOR values
        int answer = 0;

        for (int i = 0; i < size; i++) {
            if (tripletXor[i]) {
                answer++;
            }
        }

        return answer;
    }
}