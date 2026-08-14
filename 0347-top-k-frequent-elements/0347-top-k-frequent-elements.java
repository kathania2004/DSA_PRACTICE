class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap storing {frequency, element}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Step 3: Put every {frequency, element} into heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int element = entry.getKey();
            int frequency = entry.getValue();

            pq.offer(new int[]{frequency, element});

            // Keep only K most frequent elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Build answer
        int[] result =  new int[k];
        for(int i = 0;i < k;i++){
            result[i] = pq.poll()[1];
        }
        return result;

    }
}