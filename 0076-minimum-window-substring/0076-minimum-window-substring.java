class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        if (t.length() > n) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int reqCount = t.length();
        int i = 0;
        int j = 0;

        int winSize = Integer.MAX_VALUE;
        int startIndex = 0;

        while (j < n) {
            char ch = s.charAt(j);

            if (map.getOrDefault(ch, 0) > 0) {
                reqCount--;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while (reqCount == 0) {
                int currWinSize = j - i + 1;

                if (winSize > currWinSize) {
                    winSize = currWinSize;
                    startIndex = i;
                }

                char left = s.charAt(i);

                map.put(left, map.getOrDefault(left, 0) + 1);

                if (map.get(left) > 0) {
                    reqCount++;
                }

                i++;
            }

            j++;
        }

        return winSize == Integer.MAX_VALUE
            ? ""
            : s.substring(startIndex, startIndex + winSize);
    }
}