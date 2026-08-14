class Solution {
    public List<String> topKFrequent(String[] words, int k) {
          // 1. Count frequency of each word
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // 2. Min Heap
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (map.get(a).equals(map.get(b))) {
                    return b.compareTo(a);
                }
                return map.get(a) - map.get(b);
            }
        );

        // 3. Put words into heap
        for (String word : map.keySet()) {
            pq.offer(word);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 4. Get result
        List<String> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // 5. Reverse because it's a min heap
        Collections.reverse(result);

        return result;
    }
}