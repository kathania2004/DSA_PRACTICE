class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        int left = 0;
        int maxlength = 0;
        for(int right = 0; right < s.length();right++){
            char ch  = s.charAt(right);
            map.put(ch,map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) > 2){
                char leftchar = s.charAt(left);

                map.put(leftchar,map.get(leftchar) - 1);
                left++;
            }

            maxlength = Math.max(maxlength,right - left + 1);
        }
        return maxlength;
    }
}