class Solution {
    public String reorganizeString(String s) {
               HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max Heap based on frequency
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Add characters to heap
        for (char ch : map.keySet()) {
            pq.offer(ch);
        }

        StringBuilder result = new StringBuilder();

        while (pq.size() > 1) {

            char first = pq.poll();
            char second = pq.poll();

            result.append(first);
            result.append(second);

            map.put(first, map.get(first) - 1);
            map.put(second, map.get(second) - 1);

            if (map.get(first) > 0) {
                pq.offer(first);
            }

            if (map.get(second) > 0) {
                pq.offer(second);
            }
        }

        // Handle remaining character
        if (!pq.isEmpty()) {

            char last = pq.poll();

            if (map.get(last) > 1) {
                return "";
            }

            result.append(last);
        }

        return result.toString();
    }
}